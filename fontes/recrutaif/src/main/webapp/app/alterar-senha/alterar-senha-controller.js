(function () {
    'use strict';
    angular.module('recrutaif').controller('AlterarSenhaController', function ($cookieStore, $rootScope, $scope, $resource,recursoUsuario) {
        //módulos que não são mais utilizados, porque estão sendo injetados pelo recursoSetor: $http,$resource

        //módulo controller, para setor

        //variáveis de interação com o scope
        $scope.filtro = ''; //variável responsável pelo filtro de setores, dentro do scope
        $scope.mensagem = '';   //variável responsável pela mensagem de interação com o usuário dentro do scope
        $scope.usuario = [];


        var User = $resource('rest/usuarios/:usuarioId', {userId:'@id'});
        var user = User.get({userId:$cookieStore.get('id')}, function(u, getResponseHeaders) {
          
          console.log(user);
        //   user.$save(function(u, putResponseHeaders){
        //       $scope.usuario = u;
        //   });
        });

        //função busca uma lista de setores
        // recursoUsuario.query({ id: $cookieStore.get('id') }, function (usuarios) {
        // recursoUsuario.({ id: $cookieStore.get('id') }, function (usuarios) {



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
})();