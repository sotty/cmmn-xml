package org.omg.spec.CMMN.xml.v11;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.stream.Collectors;

public class Utils {

	public static <K> LinkedHashMap<K,K> toLinkedMap( K[]... values ) {
		return Arrays.stream( values ).collect( Collectors.toMap( (x) -> x[0],
		                                                          (x) -> x[1],
		                                                          (x,y) -> x,
		                                                          LinkedHashMap::new ) );
	}

	public static String randomID() {
		return "_" + UUID.randomUUID().toString();
	}

}
