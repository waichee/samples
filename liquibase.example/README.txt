The Liquibase data migration is performed via ServletListener which expects JNDI data source to be setup.
Refer to the following for more details:
http://www.liquibase.org/manual/servlet_listener
http://tomcat.apache.org/tomcat-6.0-doc/jndi-datasource-examples-howto.html

Alternatively, the Liquibase changelogs can be executed via the liquibase-maven-plugin (with commented samples in pom.xml)
The application is configured to use Postgres database named liquibaseexample locally and this database is expected to have been installed and created.
