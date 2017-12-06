package org.omg.spec.CMMN.xml.v11;


import static java.util.Arrays.stream;

public enum CMMNComponents {

	DEFINITIONS( "Definitions" ),
	DOCUMENTATION( "Documentation" ),
	EXTENSION( "Extensions" ),
	;

	private String name;

	CMMNComponents( String name ) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static CMMNComponents parse( final String s ) {
		return stream( CMMNComponents.values() )
		             .filter( (p) -> p.getName().equals( s ) )
		             .findFirst()
		             .orElseThrow( () -> new UnsupportedOperationException( "Element Type not recognized: " + s ) );
	}



}
