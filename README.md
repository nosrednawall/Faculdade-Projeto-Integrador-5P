    .______       _______   ______ .______       __    __  .___________.     ___               __   _______ 
    |   _  \     |   ____| /      ||   _  \     |  |  |  | |           |    /   \             |  | |   ____|
    |  |_)  |    |  |__   |  ,----'|  |_)  |    |  |  |  | `---|  |----`   /  ^  \     ______ |  | |  |__   
    |      /     |   __|  |  |     |      /     |  |  |  |     |  |       /  /_\  \   |______||  | |   __|  
    |  |\  \----.|  |____ |  `----.|  |\  \----.|  `--'  |     |  |      /  _____  \          |  | |  |     
    | _| `._____||_______| \______|| _| `._____| \______/      |__|     /__/     \__\         |__| |__|   
===================


Repositório da documentação e do código fonte do projeto **Recruta-if** (brincadeira com recruta-se)

----------
Pré-requisitos
-------------

O software **Recruta-if** necessita dos seguintes softwares instalados para ser executado.

> **Nota:**

> - Estamos assumindo que você está com um dos sistemas operacionais abaixo instalado, configurado e atualizado.
> - Linux Debian 9 64bits.
> - Windows 10 64bits

> **Com os software abaixo instalados e configurados**
> 
> - Java JDK, na versão 1.8, que pode ser adquirido [aqui](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html) 
> - Wildfly 11, que pode ser adquirido [aqui](http://wildfly.org/downloads/)
> - Navegador Firefox atualizado até a versão 52.8.0 (64-bit).
> - Navegado Chrome atualizado até a versão 66.0.3359.181 64 bits.
> - Eclipse a na versão de março de 2018, que pode ser obtido [aqui](http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/oxygen3a)
>- JBoos Tools instalado no eclipse, caso não esteja procure no marketshare do eclipse.
>- PostgreSQL na versão 10, e já com o seu usuário cadastrado.

### Obtendo o software
Efetue um git clone:
> git clone https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P.git

### Adicionando o projeto no eclipse
Adicione o projeto importando o como um projeto Maven existente, dúvidas veja [esse tutorial](https://javabydeveloper.com/import-maven-project-eclipse/)
Após ser importado o Maven baixará todas as dependências descritas no **pom.xml**, se for na primeira vez pode ser que demore bastante.

### Adicionando o driver do postgre ao wildfly

Acesse a pasta **doc/DevOps/configuracoes/ambiente/datasource_wildfly/**

    Raiz
        \- doc
            \- DevOps
                \- configuracoes
                    \- ambiente
                        \-datasource_wildfly

nela está a pasta **org**, copie ela e cole dentro na pasta modules do wildfly, ficando com o caminho assim:

    wildfly<versao>
        \-modules
            \-org

### Configurando o Wildfly
Caso não tenha adicionado o wildfly, veja [esse tutorial](https://pablonobrega.wordpress.com/2016/06/06/configurando-o-wildfly-10-no-eclipse-mars/), só se atente a mudar as versões de 10 para 11 :)

Abra o standalone.xml
![](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/blob/master/doc/DevOps/ConfiguracoesPersonalizadas/imagens/standlone.png?raw=true)

Aperte Control+F para abrir a janela de busca, e busque **datasources**, será aberto uma tela assim:
![datasources](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/blob/master/doc/DevOps/ConfiguracoesPersonalizadas/imagens/datasources.png?raw=true)

Dentro das tags **datasources** você deverá colar o código abaixo

                <datasource jndi-name="java:/jboss/datasources/recrutaifDS" pool-name="recrutaifPool">
                    <connection-url>jdbc:postgresql://localhost/recrutaif</connection-url>
                    <driver>postgres</driver>
                    <security>
                        <user-name>sa_recrutaif</user-name>
                        <password>abc</password>
                    </security>
                </datasource>

E logo após colar esse código:

                    <driver name="postgres" module="org.postgres">
                        <driver-class>org.postgresql.Driver</driver-class>
                    </driver>
Ficando assim:

            <datasources>
                <datasource jndi-name="java:jboss/datasources/ExampleDS" pool-name="ExampleDS"
                 enabled="true" use-java-context="true">
                    <connection-url>jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE</connection-url>
                    <driver>h2</driver>
                    <security>
                        <user-name>sa</user-name>
                        <password>sa</password>
                    </security>
                </datasource>
                <datasource jndi-name="java:/jboss/datasources/recrutaifDS" pool-name="recrutaifPool">
                    <connection-url>jdbc:postgresql://localhost/recrutaif</connection-url>
                    <driver>postgres</driver>
                    <security>
                        <user-name>sa_recrutaif</user-name>
                        <password>abc</password>
                    </security>
                </datasource>
                <drivers>
                    <driver name="h2" module="com.h2database.h2">
                        <xa-datasource-class>org.h2.jdbcx.JdbcDataSource</xa-datasource-class>
                    </driver>
                    <driver name="postgres" module="org.postgres">
                        <driver-class>org.postgresql.Driver</driver-class>
                    </driver>
                </drivers>
            </datasources>

Detalhe não apague nada que já estiver nesse arquivo, apenas adicione esses dois trechos dentro de **datasources**

#### Criando o banco de dados

Acesse o psql do postgres, crie o seu **usuário** e depois crie o database **recrutaif**

Se estiver com dificuldades execute os comandos abaixo dentro do psql postgres:
>create user sa_recrutaif with password 'abc';

>create database recrutaif with owner sa_recrutaif;

# Executando

Após isso apenas click em **Start Server** e acesse o sistema em http://localhost:8080/recrutaif

## Aviso
> O Software está em desenvolvimento, não estando próprio para qualquer uso não acadêmico, dúvidas e ou melhorias por favor faça um [issue](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/issues)
>

# Equipe

[Everton Sausen](https://github.com/EvertonSausen) 	A.K.A  **Gerente de projeto**

[Joziel Alves](https://github.com/jozielalves) A.K.A  **Analista de Requisitos**

[Alisson](https://github.com/alibueno) A.K.A  **Analista de testes**

[Fernando](https://github.com/FernandoAndreLima) A.K.A  **Analista de sistema**

[Anderson J.S. Inácio](https://github.com/nosrednawall) A.K.A **DevOps**
