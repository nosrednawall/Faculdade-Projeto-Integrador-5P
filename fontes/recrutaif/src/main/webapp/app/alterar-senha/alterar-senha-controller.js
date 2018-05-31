angular.module('recrutaif').controller('AlterarSenhaController', function ($cookieStore, $rootScope, $scope, recursoUsuario, ) {
    //módulos que não são mais utilizados, porque estão sendo injetados pelo recursoSetor: $http,$resource

    //módulo controller, para setor

    //variáveis de interação com o scope
    $scope.filtro = ''; //variável responsável pelo filtro de setores, dentro do scope
    $scope.mensagem = '';   //variável responsável pela mensagem de interação com o usuário dentro do scope
    $scope.usuario = [];
    var User = $resource('rest/usuarios/:usuarioId', {usuarioId:'@id'});

    User.get({userId:123}, function(u, getResponseHeaders){
        u.abc = true;
        u.$save(function(u, putResponseHeaders) {
          //u => saved user object
          //putResponseHeaders => $http header getter
        });
      });

    console.log($cookieStore.get('id')); //deu certo aqui

    // essa variável não é mais utilizada porque está sendo injetada pelo recursoSetor nos módulos acima
    // var recursoSetor = $resource('rest/setores/:setorId');

    //função busca uma lista de setores
    // recursoUsuario.query({ id: $cookieStore.get('id') }, function (usuario) {
    //     console.log(usuario);
    //     //salva a lista de setores dentro da variável de escope $setores
    //     // $scope.usuario = usuario;
    // }, function (erro) {
    //     //caso dê erro imprime o erro para o usuário
    //     console.log(error);
    //     console.log("[ERROR] Erro ao listar os usuarios");
    // });

    //funcao para remover usuarios
    $scope.inativar = function (usuario) {

        //ele tenta remover um usuarios, passando o id em usuarios.id ao coringa usuarioId
        recursoSetor.update({ usuarioId: usuario.id }, function () {

            //caso dê certo é atualizado a lista e informado o usuário
            var indiceSetor = $scope.usuarios.indexOf(setor);
            $scope.usuarios.splice(indiceUsuario, 1);
            $scope.mensagem = "[INFO] usuario " + usuario.nome + " foi removido com sucesso!";
        }, function () {

            //caso dê erro é informado o usuário
            console.log(error);
            $scope.mensagem = "[ERROR] Erro ao remover o usuario" + usuario.nome;
        });
    };
});