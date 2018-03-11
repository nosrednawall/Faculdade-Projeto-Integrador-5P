# Baixando, instalando e configurando o Git no Windows

#### Passo 1

Baixe o git nesse [site](https://git-scm.com/download/win) ou click [aqui](https://github.com/git-for-windows/git/releases/download/v2.16.2.windows.1/Git-2.16.2-64-bit.exe)

#### Passo 2

Click com o botão direito sobre o arquivo baixado e execute como administrador.

Aceite os termos de licensa

![licensa gnu](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/blob/master/Documentacao/DevOps/ConfiguracoesPersonalizadas/imagens/git1.png?raw=true)

Avance e quando solicitar para escolher o editor padrão não use o Vim, a não ser que saiba o que está fazendo

![Escolhendo o editor notepad++](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/blob/master/Documentacao/DevOps/ConfiguracoesPersonalizadas/imagens/git2.jpg?raw=true)

Avance e quando chegar no Ajustando o PATH environment escolha a segunda opção, a Use Git from the Windows Command Prompt

![Escolhendo o CMD como principal](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/blob/master/Documentacao/DevOps/ConfiguracoesPersonalizadas/imagens/git3.png?raw=true)

Avance e quando chegar em Choosing HTTPS transport backend, deixe a primeira opção selecionada, a Use the OpenSSH library

![Escolhendo o SSH](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/blob/master/Documentacao/DevOps/ConfiguracoesPersonalizadas/imagens/git4.png?raw=true)

Avance até chegar no finish.

#### Passo 3

Vamos configurar agora, abra o menu windows e pesquise por GitCMD, e insira os comandos abaixo:

<!-- language: shell -->
    git config --global user.email "seu email do git"
    git config --global user.name "seu nome no git"

<!-- language: shell -->

![comandos para configurar o git](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/blob/master/Documentacao/DevOps/ConfiguracoesPersonalizadas/imagens/git6.png?raw=true)

Pronto o seu git está minimamente configurado.

#### Passo 4

Agora vamos gerar uma chave SSH e adicioná-la a sua conta git, para poder fazer **git pull** e **git push** sem solicitar e-mail e senha.

Abra o GitCMD e execute os comandos abaixo:

<!-- language: shell -->
    ssh-keygen -t rsa -b 4096 -C seu@email.aqui
    tecle enter
    tecle enter
    tecle enter
<!-- language: shell -->

Vai gerar uma imagem parecida com essa abaixo:

![comandos para gerar o ssh](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/blob/master/Documentacao/DevOps/ConfiguracoesPersonalizadas/imagens/git7.png?raw=true)

Inicie o agente SSH
<!-- language: shell -->
    eval "$(ssh-agent -s)"
    ssh-add ~/.ssh/id_rsa
<!-- language: shell -->
Vá até o arquivo em **C:\Users\Seu Usuário\.ssh** e abra o arquivo id_rsa com o bloco de notas, copie tudo o que tem lá e vá para a sua conta do github.

No GitHub já logado, click na sua imagem de user, vá em Settings

![Imagem mostrando como ir no settings](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/blob/master/Documentacao/DevOps/ConfiguracoesPersonalizadas/imagens/git9.png?raw=true)

Na barra vertical da sua esquerda click em **SSH and GPG keys**, depois click em New SSH key

![Imagem mostrando o new SSH key](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/blob/master/Documentacao/DevOps/ConfiguracoesPersonalizadas/imagens/git10.png?raw=true)

Dê um título a sua chave SSH, por exemplo pc casa, pc trabalho, etc... , e cole a sua chave no campo Key

![Imagem mostrando onde cola o que](https://github.com/nosrednawall/Faculdade-Projeto-Integrador-5P/blob/master/Documentacao/DevOps/ConfiguracoesPersonalizadas/imagens/git11.png?raw=true)

Click em Add SSH Key e pronto seu SSH foi adicionado com sucesso.
