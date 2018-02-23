# Instalacao conforme DebianWiki
<!-- language: shell -->
$ sudo aptitude update && aptitude upgrade
$ sudo aptitude install mysql-server mysql-client
$ su 
# /usr/bin/mysqladmin -u root password 'enter-your-good-new-password-here'
<!-- language: shell -->

Agora acesse usando
mysql -u root -p
deu erro?
Veja esse link https://elias.praciano.com/2017/07/como-resolver-o-erro-1698-de-acesso-negado-no-mysql-e-mariadb/
procedimento abaixo:
sudo mysql -u root 
use mysql
update user set plugin='' where User='root';
flush privileges;
exit;
tente novamente
mysql -u root -p
 
