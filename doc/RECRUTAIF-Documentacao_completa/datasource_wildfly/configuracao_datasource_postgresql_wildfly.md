
Colar a pasta org dentro da pasta /<wildfly_home>/modules

            <datasources>
                ...
                
                
                
                
                
                <datasource jndi-name="java:/jboss/datasources/recrutaifDS" pool-name="recrutaifPool">
                    <connection-url>jdbc:postgresql://localhost/recrutaif</connection-url>
                    <driver>postgres</driver>
                    <security>
                        <user-name>anderson</user-name>
                        <password>abc</password>
                    </security>
                </datasource>
                
                
                
                
                <drivers>
                ...
                    <driver name="postgres" module="org.postgres">
                        <driver-class>org.postgresql.Driver</driver-class>
                    </driver>
                </drivers>
            </datasources>




    
