package org.omg.spec.CMMN.xml.v11;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static java.util.Objects.requireNonNull;
import static org.testng.AssertJUnit.fail;

public abstract class CmmnXmlTestBase<S> {

	protected Map<String,Document> xmls = new HashMap<>();
	protected Map<String,String> paths = new HashMap<>();
	protected XPath xpath;

	public CmmnXmlTestBase() {
		xpath = XPathFactory.newInstance().newXPath();
		xpath.setNamespaceContext( new NameSpaceMapper().getNamespaceContext() );
	}

	protected Node xNode( String key, String xpathExpression ) {
		return (Node) evaluate( key, xpathExpression, XPathConstants.NODE );
	}

	protected NodeList xList( String key, String xpathExpression ) {
		return (NodeList) evaluate( key, xpathExpression, XPathConstants.NODESET );
	}

	protected String xString( String key, String xpathExpression ) {
		return (String) evaluate( key, xpathExpression, XPathConstants.STRING );
	}

	protected Double xNumber( String key, String xpathExpression ) {
		return (Double) evaluate( key, xpathExpression, XPathConstants.NUMBER );
	}

	protected Boolean xBool( String key, String xpathExpression ) {
		return (Boolean) evaluate( key, xpathExpression, XPathConstants.BOOLEAN );
	}

	protected Object attr( Node n, String attribName ) {
		Node att = n.getAttributes().getNamedItem( attribName );
		if ( att == null ) {
			fail( "Expected attribute " + attribName + " is missing" );
		}
		return att.getNodeValue();
	}

	protected List<Node> children( Node parent, String nodeType ) {
		NodeList list = parent.getChildNodes();
		List<Node> l = new ArrayList<>();
		for ( int j=0; j < list.getLength(); j++ ) {
			Node x = list.item( j );
			if ( nodeType.equalsIgnoreCase( x.getNodeName() ) ) {
				l.add( x );
			}
		}
		return l;
	}



	protected Object evaluate( String key, String xpathExpression, QName type ) {
		try {
			Document dox = getDocument( key );

			xpath.reset();
			Object result = xpath.evaluate( xpathExpression, dox.getDocumentElement(), type );
			xpath.reset();

			return result;
		} catch ( Exception e ) {
			e.printStackTrace();
			fail( e.getMessage() );
		}
		return null;
	}

	private Document getDocument( String key ) {
		if ( ! xmls.containsKey( key ) ) {
			loadXML( key, paths.get( key ) );
		}
		return xmls.get( key );
	}


	protected String readFile( String path ) throws IOException {
		InputStream inputStream = CmmnXmlTestBase.class.getClassLoader().getResourceAsStream( path );
		byte[] data = new byte[ inputStream.available() ];
		inputStream.read( data );
		return new String( data );
	}

	protected Map<String,String> toXML( String path ) throws IOException {
		Map<String,String> srcModels = extractModels( path );
		Map<String,String> xmlModels = new HashMap<>();

		srcModels.forEach( (artifactId, model) -> {
			Optional<CmmnXmlExporter<S>> xmlExporter = getExporter( model, artifactId, true );
			if ( xmlExporter.isPresent() ) {
				try {
					xmlModels.put( artifactId, xmlExporter.get().generateXml( artifactId ) );
				} catch ( Exception e ) {
					Optional<CmmnXmlExporter<S>> debugExporter = getExporter( model, artifactId, false );
					fail( e.getMessage() + "\n" + debugExporter.map( (db) -> db.generateXml( artifactId ) ).orElse( "" ) );
				}
			}
		} );
		return xmlModels;
	}

	protected Map<String,String> extractModels( String path ) {

		try {
			if ( path.endsWith( ".sgx" ) ) {
				return loadModelArchive( path );
			} else {
				Map<String,String> res = new HashMap<>();
				res.put( UUID.randomUUID().toString(), readFile( path ) );
				return res;
			}
		} catch ( IOException e ) {
			fail( e.getMessage() );
			e.printStackTrace();
		}
		return Collections.emptyMap();
	}

	private Map<String, String> loadModelArchive( String path ) {
		final Pattern p = Pattern.compile( ".*\\/model_(.*)\\/model_\\d+_.json" );
		HashMap<String,String> map = new HashMap<>();
		try {
			ZipFile zip = new ZipFile( new File( requireNonNull( CmmnXmlTestBase.class.getClassLoader().getResource( path ) ).toURI() ) );

			zip.stream()
			   .forEach( (entry) -> {
			   	    Matcher m = p.matcher( entry.getName() );
			   	    if ( m.find() ) {
			   	    	String artifactId = m.group( 1 );
				        try {
					        InputStream is = zip.getInputStream( entry );
					        byte[] data = new byte[ is.available() ];
					        is.read( data );
					        String model = new String( data );
					        map.put( artifactId, model );
				        } catch ( IOException e ) {
					        e.printStackTrace();
				        }
			        }
			   } );

		} catch ( IOException | URISyntaxException e ) {
			fail( e.getMessage() );
			return Collections.emptyMap();
		}
		return map;
	}

	protected abstract Optional<CmmnXmlExporter<S>> getExporter( String model, String id, boolean b );


	protected void clear() {
		paths.clear();
		xmls.clear();
	}

	protected void load( String key, String path ) {
		paths.put( key, path );
	}

	protected void loadXML( String key, String path ) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware( true );
			DocumentBuilder builder = factory.newDocumentBuilder();

			// in general, a package may contain more than one model. this test class assumes that there is only one.
			String xml = toXML( path ).entrySet().iterator().next().getValue();

			Document dox = builder.parse( new ByteArrayInputStream( xml.getBytes() ) );
			xmls.put( key, dox );

			printDocument( dox, System.out );
		} catch ( IOException | ParserConfigurationException | SAXException e ) {
			e.printStackTrace();
			fail( e.getMessage() );
		}
	}


	public void printDocument(Document dox, OutputStream out ) throws IOException {
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes" );
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			transformer.transform(new DOMSource(dox),
			                      new StreamResult( new OutputStreamWriter( out, "UTF-8")) );
		} catch ( TransformerException e ) {
			e.printStackTrace();
		}
	}

}
