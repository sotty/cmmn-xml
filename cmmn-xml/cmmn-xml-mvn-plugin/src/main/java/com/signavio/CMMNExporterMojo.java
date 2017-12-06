package com.signavio;

import com.signavio.cmmn.xml.v11.CmmnXmlShapeExporter;
import com.signavio.diagram.model.Diagram;
import com.signavio.diagram.model.DiagramBuilder;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;



@Mojo( name = "cmmn-export")
public class CMMNExporterMojo extends AbstractMojo {

	final Pattern idPattern         = Pattern.compile( ".*\\/model_(.*)\\/model_\\d+_.json" );
	final Pattern modelPattern      = Pattern.compile( "^.*/model_\\d+_.json" );

	@Parameter
	private List<File> folders = null;

	@Parameter
	private String targetFolder = null;

	public void execute() throws MojoExecutionException {
		if ( folders != null ) {
			for ( File dir : folders ) {
				processDir( dir, dir );
			}
		}
	}

	private void processDir( File root, File dir ) {
		if ( dir != null && dir.isDirectory() ) {
			File[] files = dir.listFiles();
			if ( files != null && files.length > 0 ) {
				for ( int j = 0; j < files.length; j++ ) {
					File f = files[ j ];
					if ( f.isDirectory() ) {
						processDir( dir, f );
					} else {
						try {
							processSgxFile( root, f );
						} catch ( Exception e ) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	private void processSgxFile( File root, File f ) throws Exception {
		ZipInputStream zis = new ZipInputStream( new FileInputStream( f ) );
		ZipEntry zipEntry = zis.getNextEntry();
		while( zipEntry != null ) {
			String fileName = zipEntry.getName();
			if ( modelPattern.matcher( fileName ).find() ) {
				saveFile( export( unzip( zipEntry, zis ), getId( fileName ) ), f.getParent(), f.getName(), root.getAbsolutePath(), targetFolder );
			}
			zipEntry = zis.getNextEntry();

		}
		zis.closeEntry();
		zis.close();
	}

	private String getId( String fileName ) {
		Matcher matcher = idPattern.matcher( fileName );
		if ( ! matcher.find () ) {
			throw new IllegalStateException( "Could not detect model ID from entry name pattern " + fileName );
		}
		return matcher.group( 1 );
	}

	private void saveFile( String export, String parent, String name, String root, String tgtFolder ) throws IOException {
		String relativePath = parent.replace( root, "" );
		String outPath = tgtFolder + relativePath + File.separator + name.replace( "sgx", "cmmn" );
		File out = new File( outPath );
		if ( ! out.getParentFile().exists() ) {
			out.getParentFile().mkdirs();
		}
		FileOutputStream fos = new FileOutputStream( out );
		fos.write( export.getBytes() );
		fos.flush();
		fos.close();
	}

	private byte[] unzip( ZipEntry zipEntry, ZipInputStream zis ) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len;
		byte[] buffer = new byte[1024];
		while ( ( len = zis.read( buffer ) ) > 0 ) {
			baos.write( buffer, 0, len );
		}
		return baos.toByteArray();
	}

	private String export( byte[] model, String artifactId ) throws Exception {
		Diagram diagram = DiagramBuilder.parseJson( new String( model ), UUID.randomUUID().toString() );
		return new CmmnXmlShapeExporter( diagram, false ).generateXml( artifactId );
	}

}


