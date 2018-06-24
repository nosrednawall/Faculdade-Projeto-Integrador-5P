angular.module('recrutaif').controller('UsuariosController',function($scope,recursoUsuario,listaUsuarios){
    //módulos que não são mais utilizados, porque estão sendo injetados pelo recursoSetor: $http,$resource

//módulo controller, para setor

    //variáveis de interação com o scope
    $scope.usuarios = [];    //variável responsável pelo loop de setor dentro do scope
    $scope.filtro = ''; //variável responsável pelo filtro de setores, dentro do scope
    $scope.mensagem = '';   //variável responsável pela mensagem de interação com o usuário dentro do scope

    // essa variável não é mais utilizada porque está sendo injetada pelo recursoSetor nos módulos acima
    // var recursoSetor = $resource('rest/setores/:setorId');

    //função busca uma lista de setores
    listaUsuarios.query({
        statusId:2
    },function(usuarios){
        //salva a lista de setores dentro da variável de escope $setores
        $scope.usuarios = usuarios;
        console.log(usuarios);
    }, function(erro){
        //caso dê erro imprime o erro para o usuário
        console.log(error);
        console.log("[ERROR] Erro ao listar os usuarios");
    });

    //funcao para remover usuarios
    $scope.inativar = function(usuario){

        console.log(usuario.status);
        usuario.status = 'INATIVO';
        console.log(usuario.status);

        //ele tenta atualiza um usuarios, passando o id em usuarios.id ao coringa usuarioId
        recursoUsuario.update({usuarioId : usuario.id}, usuario, function(){

            //caso dê certo é atualizado a lista e informado o usuário
            var indiceUsuario = $scope.usuarios.indexOf(usuario);
            $scope.usuarios.splice(indiceUsuario,1);
            $scope.mensagem = "[INFO] usuario "+usuario.nome+" foi removido com sucesso!";
        }, function(){

            //caso dê erro é informado o usuário
            console.log(error);
            $scope.mensagem = "[ERROR] Erro ao remover o usuario" + usuario.nome;
        });
    };
});