# Java 8/9 needs explicit access to external schemas
# https://stackoverflow.com/questions/23011547/webservice-client-generation-error-with-jdk8

gradle xjc -Djavax.xml.accessExternalSchema=all
