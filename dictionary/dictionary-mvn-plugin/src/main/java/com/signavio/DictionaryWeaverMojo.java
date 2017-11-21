package com.signavio;

import edu.mayo.mea3d.preprocess.meta.DictionaryWeaver;
import edu.mayo.mea3d.util.Util;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;

import javax.swing.text.html.Option;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;


@Mojo( name = "dictionary-weave" )
public class DictionaryWeaverMojo extends AbstractMojo {


	@Parameter
	private List<File> folders = null;

	@Parameter
	private String targetFolder = null;

	@Parameter
	private File dictionary = null;

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
							processXMLFile( root, f );
						} catch ( Exception e ) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	private void processXMLFile( File root, File f ) throws Exception {
		if ( f.getAbsolutePath().endsWith( "dmn" ) ) {
			saveFile( weave( f ), f.getParent(), f.getName(), root.getAbsolutePath(), targetFolder );
		}
	}

	private Document weave( File f ) {
		try {
			Optional<XSSFWorkbook> wk = DictionaryWeaver.getDictionary( new FileInputStream( dictionary ) );
			if ( ! wk.isPresent() ) {
				return null;
			}
			DictionaryWeaver weaver = new DictionaryWeaver( wk.get(), false );
			Optional<Document> dox = Util.loadXMLDocument( f.toURI().toURL() );
			if ( dox.isPresent() ) {
				return dox.map( weaver::weave ).get();
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
		Util.streamXMLDocument( export, fos );
		fos.flush();
		fos.close();
	}


}


