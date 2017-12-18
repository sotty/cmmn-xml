package com.signavio;

import edu.mayo.mea3d.preprocess.meta.DictionaryEntryWeaver;
import edu.mayo.mea3d.preprocess.meta.DictionaryReader;
import edu.mayo.kmdp.util.Util;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import static edu.mayo.kmdp.util.XMLUtil.loadXMLDocument;
import static edu.mayo.kmdp.util.XMLUtil.streamXMLDocument;


@Mojo( name = "dictionary-weave" )
public class DictionaryWeaverMojo extends AbstractMojo {


	@Parameter
	private List<File> folders = null;

	@Parameter
	private String targetFolder = null;

	@Parameter
	private File dictionary = null;

	@Parameter
	private Properties properties = null;

	public void execute() throws MojoExecutionException {
		if ( folders != null ) {
			for ( File dir : folders ) {
				processDir( dir, dir );
			}
		}
	}

	private void processDir( File root, File dir ) {
		Util.processDir( root, dir, this::processXMLFile );
	}

	private void processXMLFile( File root, File f )  {
		try {
			if ( f.getAbsolutePath().endsWith( "dmn" ) || f.getAbsolutePath().endsWith( "cmmn" ) ) {
				saveFile( weave( f ), f.getParent(), f.getName(), root.getAbsolutePath(), targetFolder );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	private Document weave( File f ) {
		try {
			DictionaryEntryWeaver weaver = new DictionaryEntryWeaver( new FileInputStream( dictionary ), false, properties );
			Optional<Document> dox = loadXMLDocument( f.toURI().toURL() );
			if ( dox.isPresent() ) {
				return dox.map( weaver::weave ).orElse( null );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return null;
	}

	private void saveFile( Document export, String parent, String name, String root, String tgtFolder ) throws IOException {
		if ( export == null ) {
			return;
		}

		String relativePath = parent.replace( root, "" );
		String outPath = tgtFolder + relativePath + File.separator + name;
		File out = new File( outPath );
		if ( ! out.getParentFile().exists() ) {
			out.getParentFile().mkdirs();
		}
		FileOutputStream fos = new FileOutputStream( out );
		streamXMLDocument( export, fos );
		fos.flush();
		fos.close();
	}


}


