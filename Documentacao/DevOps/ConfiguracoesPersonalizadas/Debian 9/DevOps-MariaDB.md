# RECOMENDADO Instalação do MariaDB com os pacotes do Debian

<!-- language: shell -->
    sudo apt update && sudo apt upgrade
    sudo apt install mariadb-server
<!-- language: shell -->

Agora iremos inserir a senha do MariaDB

<!-- language: shell -->
    sudo mysql -u root 
    use mysql; 
    UPDATE user SET Password=PASSWORD('SENHA_SECNET') WHERE User='root'; 
    FLUSH PRIVILEGES; 
    exit;

<!-- language: shell -->

# NÃO RECOMENDADO Instalacao MariaDB no debian com os pacotes do MariaDB

Efetue a instalação conforme esse [site](https://downloads.mariadb.org/mariadb/repositories/#mirror=UFSCar&distro=Debian&distro_release=stretch--stretch&version=10.2)
<!-- language: shell -->
    sudo apt-get install software-properties-common dirmngr
    sudo apt-key adv --recv-keys --keyserver keyserver.ubuntu.com 0xF1656F24C74CD1D8
    sudo add-apt-repository 'deb [arch=amd64,i386,ppc64el] http://mirror.ufscar.br/mariadb/repo/10.2/debian stretch main'
    sudo apt-get update
    sudo apt-get upgrade
    sudo apt-get install mariadb-server
<!-- language: shell -->

Pronto deve estar instalado, agora verifique se está funcionando com o comando abaixo:

<!-- language: shell -->
    mysql -u root -p
<!-- language: shell -->

Solução de problemas:
---
---

Se der erro é só seguir os procedimentos abaixo, descritos nesse [site](https://elias.praciano.com/2017/07/como-resolver-o-erro-1698-de-acesso-negado-no-mysql-e-mariadb/)

Obs.: Os comandos abaixo que tiverem *MariaDB [] >* não precisa digitar porque isso quer dizer que você está dentro do shell do MariaDB, ou seja, apenas o que está após o *>* é o que importa.

<!-- language: shell -->

    $ sudo mysql -u root 
    MariaDB [] > use mysql
    MariaDB [mysql] > update user set plugin='' where User='root';
    MariaDB [mysql] > flush privileges;
    MariaDB [mysql] >exit;
    $ mysql -u root -p
<!-- language: shell --> 

Se mesmo após tudo isso não resolver me envie um [e-mail](mailto:nosrednawall@gmail.com)
