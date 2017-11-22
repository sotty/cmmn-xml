mvn install:install-file -DgroupId=com.signavio -DartifactId=diagram -Dpackaging=jar -Dversion=1.0 -Dfile=diagram-1.0-SNAPSHOT.jar -DgeneratePom=true

mvn install:install-file -DgroupId=com.signavio -DartifactId=diagram-core -Dpackaging=jar -Dversion=1.0 -Dfile=diagram-core-1.0-SNAPSHOT.jar -DgeneratePom=true

mvn install:install-file -DgroupId=com.signavio -DartifactId=utils -Dpackaging=jar -Dversion=1.0.2 -Dfile=utils-1.0.2-SNAPSHOT.jar -DgeneratePom=true