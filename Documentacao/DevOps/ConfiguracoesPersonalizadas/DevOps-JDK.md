# Instalando o Java JDK 1.8 no Debian 9 "Stretch"

Començando desinstale o plugin do IcedTea (openjre) para navegadores, mas não é necessário remover o OpenJDK, apenas esse plugin.
<!-- language: shell -->
    apt-get remove icedtea-*-plugin
<!-- language: shell -->

Após isso é só fazer o download do JDK 8 (ou 1.8 para os mais intimos) no site da Oracle.

[Site para Download](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

Mas se você não quiser perder tempo, click [aqui](http://download.oracle.com/otn-pub/java/jdk/8u162-b12/0da788060d494f5095bf8624735fa2f1/jdk-8u162-linux-x64.tar.gz)

Após terminar o download, abra o terminal e acesse o local de download do JDK.
<!-- language: shell -->
    $ cd /home/$USER/Downloads
    $ tar xvzf jdk-*.tar.gz
    $ mv jdk*/ jdk-oracle
    $ su
    # cp -rp jdk-oracle /usr/lib/jvm && rm -r jdk-oracle/
    # update-alternatives --install "/usr/bin/java" "java" "/usr/lib/jvm/jdk-oracle/bin/java" 1
    # update-alternatives --install "/usr/bin/javac" "javac" "/usr/lib/jvm/jdk-oracle/bin/javac" 1
    # update-alternatives --install "/usr/bin/jar" "jar" "/usr/lib/jvm/jdk-oracle/bin/jar" 1
    # update-alternatives --install "/usr/bin/javaws" "javaws" "/usr/lib/jvm/jdk-oracle/bin/javaws" 1
    # update-alternatives --set java /usr/lib/jvm/jdk-oracle/bin/java
    # update-alternatives --set javac /usr/lib/jvm/jdk-oracle/bin/javac
    # update-alternatives --set jar /usr/lib/jvm/jdk-oracle/bin/jar
    # update-alternatives --set javaws /usr/lib/jvm/jdk-oracle/bin/javaws
<!-- language: shell -->

Agora só falta configurar as variáveis do ambiente, abra o arquivo */etc/profile*:

<!-- language: shell -->
    nano /etc/profile
<!-- language: shell -->

Vá para o final do arquivo e cole o código abaixo:

<!-- language: shell -->    
    JAVA_HOME=/usr/lib/jvm/jdk-oracle
    PATH=$PATH:$HOME/bin:$JAVA_HOME/bin
    export JAVA_HOME
    export PATH
<!-- language: shell -->

Saia do modo root e execute o comando abaixo:

<!-- language: shell -->
    su -c 'source /etc/profile'
<!-- language: shell -->    

Reinicie o computador e depois rode o comando:

<!-- language: shell -->
    java -version
<!-- language: shell -->

Se tudo ocorrer bem você deve receber uma mensagem como a abaixo:

<!-- language: shell -->
    anderson@debian-laptop:~/g/ProjetoIntegradorQuintoPeriodo|master✓
    ➤ java -version                                                                                         6.1s  sáb 24 fev 2018 18:10:12 -03
    java version "1.8.0_162"
    Java(TM) SE Runtime Environment (build 1.8.0_162-b12)
    Java HotSpot(TM) 64-Bit Server VM (build 25.162-b12, mixed mode)
<!-- language: shell -->

Erros? me envie um [e-mail](mailto:nosrednawall@gmail.com)
