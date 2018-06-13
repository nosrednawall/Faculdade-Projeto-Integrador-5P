(function () {
    'use strict';
    angular.module('recrutaif').controller('AlterarSenhaController', function ($scope, $routeParams, $rootScope, recursoUsuario) {
        //módulos que não são mais utilizados, porque estão sendo injetados pelo recursoSetor: $http,$resource

        //módulo controller, para setor

        //variáveis de interação com o scope
        $scope.filtro = ''; //variável responsável pelo filtro de setores, dentro do scope
        $scope.mensagem = '';   //variável responsável pela mensagem de interação com o usuário dentro do scope
        $scope.usuario = [];
        
        var usuarioCookie = $rootScope.globals.currentUser;
        console.log(usuarioCookie);

        if ($routeParams.usuarioId) {
            recursoUsuario.get({ usuarioId: $routeParams.usuarioId },
                function (usuario) {
                    $scope.usuario = usuario;
                },
                function (erro) {
                    console.log(error);
                    $scope.mensagem =
                        "[ERROR] Não foi encontrar usuario de ID " + $routeParams.usuarioId;
                });
        };
    });
})();