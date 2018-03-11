# Instalando o JDK

#### Passo 1

Baixe o JDK na ultima versão (8u162) nesse [site](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) ou apenas click [aqui](http://download.oracle.com/otn-pub/java/jdk/8u162-b12/0da788060d494f5095bf8624735fa2f1/jdk-8u162-windows-x64.exe)

#### Passo 2

Acesse o local onde baixou o arquivo e click com o botão direito e escolha executar como administrador.

Avance, avance, avance ... install

![imagem 1 de instalacao do jdk]()
![imagem 2 de instalacao do jdk]()

Pronto JDK instalado

#### Passo 3

Vamos configurar as variáveis de ambiente.

Abra o CMD e digite:

<!-- language: shell -->
    setx JAVA_HOME "C:\Program Files\Java\jdk1.8.<versao>"
    setx CLASSPATH "%JAVA_HOME%\lib"
    setx PATH "%PATH%;%JAVA_HOME%\bin"
<!-- language: shell -->

Pronto JDK instalado e pronto para o uso, se o eclipse não reconhecer o JDK é só reiniciar a máquina.

![imagem do cmd com as informacoes do JDK instalado]()
