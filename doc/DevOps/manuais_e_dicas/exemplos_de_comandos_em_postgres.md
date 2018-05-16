# Exemplo para criar um database

    create database controle_compras;

# Exemplo para acessar o database
    
    \c controle_compras;
    
# Exemplo para criar uma tabela

    create table compras (id serial primary key, valor decimal, data date, observacao varchar(255), recebido smallint);
    
    create table lojas (
        id serial,
        nome varchar(100),
        endereco varchar(100),
        telefone varchar(20),
        primary key(id)
     );


# Exemplo de insert em postgres

    insert into compras (valor, data, observacao, recebido) values(100.0, '2009-12-14', 'presente de aniversario', 1);
    insert into lojas (nome, endereco, telefone) values('pao de acucar', 'rua vergueiro 3102', '12345678'), ('carrefour','av paulista','1212121212');


# Exemplo de select em postgres

    select * from compras;
    select * from compras where valor <= 20;
    select valor,data,observacao from compras where data >= '01-01-2009' and data <= '31-12-2009';
    select valor,data,observacao from compras where data between '01-01-2009' and '31-12-2009';
    select valor, valor*0.2 as Imposto from compras;
    select valor,data,observacao from compras where data between '01-01-2009' and '31-12-2009' and not observacao = 'gasto pequeno';
    select id, data, to_char(data, 'dd-mm-yyyy') as DataFormatada from compras;
    select * from compras where id = 29;



# Exemplo de importação de script utilizando o \i
    
Linux
    \i  /home/anderson/Downloads/dump-postgres.sql

Windows
    \i C:/Users/lfeli/Downloads/dump-postgres.sql

# Exemplo de update

    update compras set data = '03-09-2011' where id = 42;
    update compras set observacao  = 'gasto pequeno' where id = 42;
    update compras set data= '2014-06-12' where id=29
    update compras set forma_pagamento = 'cartao';
    
# Exemplo de delete
    
    delete from compras where data between '01-01-2009' and '31-12-2009';
    delete from compras where id = 32;
    
# Exemplo de alteração de coluna e tabela

    alter table compras alter COLUMN valor set not null;
    alter table compras alter COLUMN valor set default 0;
    alter table compras rename form_pagamento to forma_pagamento;
    alter table compras alter COLUMN forma_pagamento set not null ;
    
# Exemplo de enum

    create type enum_pagamento as enum('cartao','boleto','dinheiro');
    alter table compras add column form_pagamento enum_pagamento;
    insert into compras (valor,data,observacao,recebido,form_pagamento) values(1500, '16-11-1992', 'festa de nascimento', 1 , 'dinheiro');
    create type enum_satisfacao as enum('muito_satisfeito','satisfeito','insatisfeito');
    alter table compras add column satisfacao_cliente enum_satisfacao;
    
# Funções em SQL (SUM,)

    select sum(valor) from compras where data between '2010-01-01' and '2010-12-31';    
    select sum(valor), count(*) from compras where data between '2010-01-01' and '2010-12-31';
    select sum(valor) as Total, avg(valor) as Media, count(*) as Quantidade from compras where data between '2010-01-01' and '2010-12-31';
    select sum(valor) from compras where observacao !='roupas' and valor <= 500;

# Funções Group by e to_char

    select to_char(data, 'YYYY') as ano, sum(valor) from compras group by ano;
    select to_char(data, 'mm') as mes, sum(valor) from compras group by mes; 
    select to_char(data, 'dd') as dia, sum(valor) from compras group by dia;
    
    
#   Fuções min() e max()

    select min(data), max(valor) from compras;
    select max(valor) from compras;
    select min(data) from compras;
    
    
    
# Criando chave estranjeira

    alter table compras add column loja_id int;
    alter table compras add foreign key(loja_id) references lojas(id);

# Join

    select * from compras join lojas on loja_id = lojas.id;
    select * from compras join lojas on loja_id = lojas.id where compras.loja_id = 2;
    
# Select multiplo ser para conseguir todas as variacoes possíveis juntando duas tabelas

    select nome, nome bzt
    

# Jeito bizarro

        SELECT
            c1.id, 
            c1.valor, 
            c2.id, 
            c2.valor
        FROM
            compras c1,
            compras c2
        WHERE
            c1.valor = c2.valor 
            AND c1.id != c2.id
    
    
    
    
    jaas cria usuarios
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
