package edu.mayo.mea3d.util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.Optional;

public class Util {


	public static URL resolveResource( String path ) {
		return Util.class.getResource( path );
	}

	public static Optional<Document> loadXMLDocument( URL source ) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware( true );
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document dox = builder.parse( source.openStream() );
			return Optional.of( dox );
		} catch ( SAXException | IOException | ParserConfigurationException e ) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public static void streamXMLDocument( Document dox, OutputStream outputStream ) {
		try {
			removeEmptyNodes( dox.getDocumentElement() );

			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty( OutputKeys.INDENT, "yes" );
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			StreamResult result = new StreamResult( new StringWriter() );
			transformer.transform( new DOMSource( dox ), result );
			outputStream.write( result.getWriter().toString().getBytes() );
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}


	public static void removeEmptyNodes( Node node ) {
		NodeList nodeList = node.getChildNodes();
		for( int i = 0; i < nodeList.getLength(); i++ ){
			Node childNode = nodeList.item( i );
			if( childNode.getNodeType() == Node.TEXT_NODE && isEmpty( childNode.getNodeValue() ) ){
				childNode.getParentNode().removeChild( childNode );
				i--;
			}
			removeEmptyNodes( childNode );
		}
	}

	private static boolean isEmpty( String nodeValue ) {
		return nodeValue.trim().length() == 0;
	}
}
