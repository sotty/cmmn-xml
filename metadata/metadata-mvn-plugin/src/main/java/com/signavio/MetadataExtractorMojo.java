package com.signavio;

import edu.mayo.mea3d.preprocess.meta.MetadataExtractor;
import edu.mayo.mea3d.util.Util;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static edu.mayo.mea3d.preprocess.meta.MetadataExtractor.Format.XML;
import static edu.mayo.mea3d.util.Util.processDir;
import static edu.mayo.mea3d.util.XMLUtil.streamXMLDocument;


@Mojo( name = "metadata-extract" )
public class MetadataExtractorMojo extends AbstractMojo {


	@Parameter
	private List<File> modelFolders = Collections.emptyList();

	@Parameter
	private List<File> metaFolders = Collections.emptyList();

	@Parameter
	private String targetFolder = null;

	@Parameter
	private MetadataExtractor.Format format = XML;

	@Parameter
	private Properties config = new Properties();

	@Parameter
	private File graphFile = null;

	private MetadataExtractor extractor = new MetadataExtractor();

	public void execute() {
		if ( modelFolders != null ) {
			for ( File dir : modelFolders ) {
				processDir( dir, dir, this::scan );
			}
			for ( File dir : modelFolders ) {
				processDir( dir, dir, this::processFile );
			}
		}

		if ( graphFile != null ) {
			try {
				extractor.getMapper().serializeModel( new FileOutputStream( graphFile ) );
			} catch ( FileNotFoundException e ) {
				e.printStackTrace();
			}
		}
	}

	private void scan( File folder, File model ) {
		try {
			extractor.getMapper().scan( new FileInputStream( model ) );
		} catch ( FileNotFoundException e ) {
			e.printStackTrace();
		}
	}

	private void processFile( File modelRoot, File f )  {
		if ( isSupported( f.getName() ) ) {

			System.out.println( "Found model file "+ f.getName() );
			String metadataFileName = replaceExt( f.getName(), ".sgx" );

			for ( File dir : metaFolders ) {

				processDir( dir, dir, ( metaRoot, curr ) -> {
					if ( curr.getName().equals( metadataFileName ) ) {
						try {

							System.out.println( "  Joining with metadata info " + metadataFileName );

							extractor.doExtract( new FileInputStream( f ), new FileInputStream( curr ), format, config )
							         .ifPresent( (surr) -> {
								         try {
									         save( surr,
									               f.getParent(),
									               replaceExt( f.getName(), ".surr" + format.ext() ),
									               modelRoot.getAbsolutePath(),
									               targetFolder );
								         } catch ( IOException e ) {
									         e.printStackTrace();
								         }
							         } );
						} catch ( FileNotFoundException e ) {
							e.printStackTrace();
						}
					}
				} );
			}
		}
	}

	private String replaceExt( String name, String ext ) {
		return name.substring( 0, name.lastIndexOf( "." ) ) + ext;
	}


	private boolean isSupported( String name ) {
		return name.endsWith( "dmn" ) || name.endsWith( "cmmn" );
	}



	private void save( ByteArrayOutputStream metadata, String parent, String name, String root, String tgtFolder ) throws IOException {
		if ( metadata == null ) {
			return;
		}

		String outPath = tgtFolder + parent.replace( root, "" ) + File.separator + name;
		File out = new File( outPath );
		if ( ! out.getParentFile().exists() ) {
			out.getParentFile().mkdirs();
		}
		FileOutputStream fos = new FileOutputStream( out );
		fos.write( metadata.toByteArray() );
		fos.flush();
		fos.close();
	}



}


