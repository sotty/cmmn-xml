package com.signavio;

import com.signavio.cmmn.xml.v11.CmmnXmlShapeExporter;
import com.signavio.cmmn.xml.v11.ZipHelper;
import com.signavio.diagram.model.Diagram;
import com.signavio.diagram.model.DiagramBuilder;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.ZipEntry;



@Mojo( name = "cmmn-export")
public class CMMNExporterMojo extends AbstractMojo {


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
		ZipHelper zips = new ZipHelper( new FileInputStream( f ) );
		Optional<ZipEntry> zipEntry = zips.getModelEntry();
		if ( ! zipEntry.isPresent() ) {
			throw new Exception( "" );
		}

		ZipEntry entry = zipEntry.get();
		saveFile( export( zips.unzip(), zips.getId( entry.getName() ) ),
		          f.getParent(),
		          f.getName(),
		          root.getAbsolutePath(),
		          targetFolder );

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

	private String export( byte[] model, String artifactId ) throws Exception {
		Diagram diagram = DiagramBuilder.parseJson( new String( model ) );
		return new CmmnXmlShapeExporter( diagram, false ).generateXml( artifactId );
	}

}


