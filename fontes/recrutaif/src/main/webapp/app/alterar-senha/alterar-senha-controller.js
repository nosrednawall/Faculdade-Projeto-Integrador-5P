angular
    .module('recrutaif')
    .controller('AlterarSenhaController', function ($scope, $routeParams, $rootScope, recursoUsuario) {

        $scope.filtro = ''; //variável responsável pelo filtro de setores, dentro do scope
        $scope.mensagem = '';   //variável responsável pela mensagem de interação com o usuário dentro do scope

        var usuarioCookie = $rootScope.globals.currentUser;

        if (usuarioCookie != null) {
            recursoUsuario.get({ usuarioId: usuarioCookie.id },
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