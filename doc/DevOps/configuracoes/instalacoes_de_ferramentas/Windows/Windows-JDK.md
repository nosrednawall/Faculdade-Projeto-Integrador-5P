# Instalando o JDK

#### Passo 1

Baixe o JDK na ultima versão (8u162) nesse [site](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

#### Passo 2

Acesse o local onde baixou o arquivo e click com o botão direito e escolha executar como administrador.

Avance, avance, avance ... install

![imagem 1 de instalacao do jdk](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/blob/master/Documentacao/DevOps/ConfiguracoesPersonalizadas/imagens/jdk1.png?raw=true)
![imagem 2 de instalacao do jdk](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/blob/master/Documentacao/DevOps/ConfiguracoesPersonalizadas/imagens/jdk2.png?raw=true)

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

![imagem do cmd com as informacoes do JDK instalado](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/blob/master/Documentacao/DevOps/ConfiguracoesPersonalizadas/imagens/jdk7.png?raw=true)
