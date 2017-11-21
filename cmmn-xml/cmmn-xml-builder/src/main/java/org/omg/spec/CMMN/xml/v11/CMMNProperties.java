package org.omg.spec.CMMN.xml.v11;


import static java.util.Arrays.stream;

public enum CMMNProperties {

	DOCUMENTATION( "documentation", Category.MODEL ),
	ID( "id", Category.MODEL ),
	DISCRETIONARY( "discretionary", Category.MODEL ),
	DESCRIPTION( "description", Category.MODEL ),
	REPETITION( "repetition", Category.MODEL ),
	MANUAL_ACTIVATION( "manualActivation", Category.MODEL ),
	REQUIRED( "required", Category.MODEL ),
	ENTRY( "entry", Category.MODEL ),
	NAME( "name", Category.MODEL ),
	IS_BLOCKING( "isBlocking", Category.MODEL ),
	AUTO_COMPLETE( "autoComplete", Category.MODEL ),
	EXPORTER( "exporter", Category.MODEL ),
	EXPORTER_VERSION( "exporterVersion", Category.MODEL ),
	TEXT_FORMAT( "textFormat", Category.MODEL ),

	ORIENTATION( "orientation", Category.DIAGRAM ),
	COLLAPSED( "collapsed", Category.DIAGRAM ),
	BG_COLOR( "bgColor", Category.DIAGRAM ),
	BORDER_COLOR( "borderColor", Category.DIAGRAM ),

	META( "", Category.META ),

	UNKNOWN( "", Category.UNKNOWN );

	private String name;
	private Category cat;

	CMMNProperties( String name, Category cat ) {
		this.name = name.toLowerCase();
		this.cat = cat;
	}

	public String getName() {
		return name;
	}

	public Category getCat() {
		return cat;
	}

	public static CMMNProperties parse( final String s ) {
		return stream( CMMNProperties.values() )
		             .filter( (p) -> p.getName().equalsIgnoreCase( s ) )
		             .findFirst()
		             .orElse( s.startsWith( "meta" ) ? META : UNKNOWN );
	}

	public enum Category {
		MODEL,
		DIAGRAM,
		META,
		UNKNOWN
	}


}
