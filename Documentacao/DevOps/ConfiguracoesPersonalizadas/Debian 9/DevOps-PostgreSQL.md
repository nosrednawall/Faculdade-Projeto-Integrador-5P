# Instalando o PostgreSQL no Debian 9

Adicionando os repositórios

<!-- language: shell -->
	sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt/ $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'
	sudo apt-get install wget ca-certificates 
	wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -
	sudo apt update && sudo apt upgrade
	sudo apt install postgresql-9.6 pgadmin3
<!-- language: shell -->

Pronto instalado!

### Pós instalação
Configurando o seu usuário no postgree, e de quebra criando um db e privilégios ao adicionando o seu usuário sobre o db criado.

<!-- language: shell -->
	sudo sudo su - postgres //para acessar via adm
	createdb mydb //para criar o bd, pode mudar o nome
	createuser -P seu_nome //altere o seu_nome
	psql mydb //para acessar o db
	GRANT ALL PRIVILEGES ON DATABASE mydb TO seu_nome; //adicionando privilégios ao seu user nesse DB
	\q //para sair
<!-- language: shell--> 
