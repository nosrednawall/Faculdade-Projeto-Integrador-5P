angular.module('recrutaif').controller('LoginController',
    function ($window, $q, $scope, $http, $location) {

        $scope.usuario = {};
        $scope.mensagem = '';

        delete $window.sessionStorage.token;

        $scope.autenticar = function () {

            var usuario = $scope.usuario;

            console.log('email: ' + usuario.email);
            console.log('senha: ' + usuario.senha);


            $http.post('rest/login', { email: usuario.email, senha: usuario.senha })
                .then(function () {
                    $location.path('/setores');
                    console.log('Entrou em deu certo')

                }, function (erro) {
                    console.log('Esse é o erro de login ' + erro);
                    console.log('Entrou em deu errado')

                    $scope.usuario = {};
                    $scope.mensagem = 'Login ou senha inválidos!';
                }
            );
        };

    });