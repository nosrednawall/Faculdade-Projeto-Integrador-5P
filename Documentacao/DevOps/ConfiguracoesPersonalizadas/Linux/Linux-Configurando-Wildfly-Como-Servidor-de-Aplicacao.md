
https://pedrohosilva.wordpress.com/2014/08/29/configurando-o-datasource-do-postgresql-no-wildfly/

           <datasources>
                <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS" enabled="true" use-java-context="true">
                    <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
                    <driver>h2</driver>
                    <security>
                        <user-name>sa</user-name>
                        <password>sa</password>
                    </security>
                </datasource>
                    <datasource jta="true" jndi-name="java:jboss/datasources/PostgreSQLDS" pool-name="PostgreSQLDS" enabled="true" use-java-context="true">
                        <connection-url>jdbc:postgresql://localhost:5432/livraria</connection-url>
                        <driver>postgresql</driver>
                        <transaction-isolation>TRANSACTION_READ_COMMITTED</transaction-isolation>
                        <pool>
                            <min-pool-size>10</min-pool-size>
                            <max-pool-size>100</max-pool-size>
                            <prefill>true</prefill>
                        </pool>
                        <security>
                            <user-name>anderson</user-name>
                            <password>abc</password>
                        </security>
                        <statement>
                            <prepared-statement-cache-size>32</prepared-statement-cache-size>
                            <share-prepared-statements>true</share-prepared-statements>
                        </statement>
                    </datasource>
                <drivers>
                    <driver name="h2" module="com.h2database.h2">
                        <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
                    </driver>
                    <driver name="postgresql" module="org.postgresql">
                        <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
                    </driver>
                </drivers>
            </datasources>
 
