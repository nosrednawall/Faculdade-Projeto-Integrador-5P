
# passo a passo da configuração:

http://www.mastertheboss.com/jboss-server/jboss-datasource/configuring-a-datasource-with-postgresql-and-jboss-wildfly

inicie o servidor do wildfly, seja pelo eclipse ou terminal, rode os comandos abaixo:


Now start up JBoss / Wildfly application server and launch the CLI:
1
	
    ./jboss-cli.sh

Install module containing the JDBC Driver. Specify the module name and the location where the jdbc driver has been downloaded:
1
	
    module add --name=org.postgres --resources=/tmp/postgresql-9.3-1101.jdbc41.jar --dependencies=javax.api,javax.transaction.api

Now install the JDBC Driver on the application server:
1
	
    /subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgres",driver-class-name=org.postgresql.Driver)

Finally install the datasource which will connect to the default "postgres" database on localhost:
1
	
    data-source add --jndi-name=java:/PostGreDS --name=PostgrePool --connection-url=jdbc:postgresql://localhost/postgres --driver-name=postgres --user-name=postgres --password=postgres

<hr>


    [standalone@localhost:9990 /] module add --name=org.postgres --resources=~/.m2/repository/org/postgresql/postgresql/42.2.2/postgresql-42.2.2.jar --dependencies=javax.api,javax.transaction.api

    [standalone@localhost:9990 /] /subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgres",driver-class-name=org.postgresql.Driver)

    [standalone@localhost:9990 /] data-source add --jndi-name=java:/PostGreDS --name=PostgrePool --connection-url=jdbc:postgresql://localhost/recrutaif --driver-name=postgres --user-name=anderson --password=abc
    
<hr>
# maneira difícil

Colar a pasta org dentro da pasta /<wildfly_home>/modules

            <datasources>
                ...
                <datasource jndi-name="java:/PostGreDS" pool-name="PostgrePool">
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




    
