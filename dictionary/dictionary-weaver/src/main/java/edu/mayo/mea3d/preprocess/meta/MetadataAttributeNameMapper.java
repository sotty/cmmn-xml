package edu.mayo.mea3d.preprocess.meta;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 Signavio 'metadata' attributes use internal names
 derived from the initial name used when the attribute was created,
 regardless of any subsequent label change.

 This class ensures that the names used in the 'published' artifacts
 are up to date.
*/
public class MetadataAttributeNameMapper {

	private static Map<String,String> officialNames;

	public static String KNOWLEDGE_RES_ID       = "knowledgeResourceId";
	public static String FOCAL_CONCEPT          = "focalConcept";
	public static String KNOWLEDGE_RES_TYPE     = "knowledgeResourceType";
	public static String PROP_CONCEPT           = "propositionalConcept";
	public static String EXPR_LANGUAGE          = "expressionLanguage";

	static {
		officialNames = Collections.unmodifiableMap( Stream.of(
				entry( "assetid", KNOWLEDGE_RES_ID ),
				entry( "clinicalconcept", FOCAL_CONCEPT ),
				entry( "knowledgeassettype", KNOWLEDGE_RES_TYPE ),
				entry( "clinicalproposition", PROP_CONCEPT ),
				entry( "expression", EXPR_LANGUAGE ) )
		                                                   .collect(entriesToMap()) );

	}


	private static <K, V> Map.Entry<K, V> entry( K key, V value ) {
		return new AbstractMap.SimpleEntry<>( key, value);
	}

	private static <K, U> Collector<Map.Entry<K, U>, ?, Map<K, U>> entriesToMap() {
		return Collectors.toMap( Map.Entry::getKey, Map.Entry::getValue );
	}

	public static String map( String name ) {
		return officialNames.getOrDefault( name, name );
	}
}
