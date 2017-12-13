package com.signavio.cmmn.xml.v11;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipHelper {

	private ZipInputStream zis;

	public ZipHelper( InputStream is ) {
		zis = new ZipInputStream( is );
	}

	final Pattern idPattern         = Pattern.compile( ".*\\/model_(.*)\\/model_\\d+_.json" );
	final Pattern modelPattern      = Pattern.compile( "^.*/model_\\d+_.json" );


	public Optional<ZipEntry> getModelEntry() throws Exception {
		ZipEntry modelEntry = null;

		ZipEntry zipEntry = zis.getNextEntry();
		while( zipEntry != null ) {
			String fileName = zipEntry.getName();
			if ( modelPattern.matcher( fileName ).find() ) {
				modelEntry = zipEntry;
				break;
			}
			zipEntry = zis.getNextEntry();
		}
		return Optional.ofNullable( modelEntry );
	}


	public String getId( String fileName ) {
		Matcher matcher = idPattern.matcher( fileName );
		if ( ! matcher.find () ) {
			throw new IllegalStateException( "Could not detect model ID from entry name pattern " + fileName );
		}
		return matcher.group( 1 );
	}


	public byte[] unzip() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int len;
		byte[] buffer = new byte[1024];
		while ( ( len = zis.read( buffer ) ) > 0 ) {
			baos.write( buffer, 0, len );
		}
		return baos.toByteArray();
	}

	public void close() {
		try {
			zis.close();
		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}
}
