(function () {
    'use strict';

    angular.module('recrutaif').controller('LoginController',
        function ($cookieStore, $window, $q, $scope, $http, $location, $rootScope) {

            $scope.usuario = {};
            $scope.mensagem = '';
            $rootScope.globals = {};
            delete $window.sessionStorage.token;


            $scope.autenticar = function () {

                var usuarioNaoLogado = $scope.usuario;

                $http.post('rest/login', { email: usuarioNaoLogado.email, senha: usuarioNaoLogado.senha })
                    .then(function (usuarioLogado) {

                        /**Quando o login é um sucesso é salvo as informações do usuário dentro dos cookies e do rootscope */
                        $cookieStore.put('nome', usuarioLogado.data.nome);
                        $cookieStore.put('id', usuarioLogado.data.id);
                        $cookieStore.put('permissao', usuarioLogado.data.permissao);
                        $cookieStore.put('logado', true);

                        $rootScope.globals = {
                            currentUser: {
                                nome: usuarioLogado.data.nome,
                                id: usuarioLogado.data.id,
                                permissao: usuarioLogado.data.permissao,
                                logado: true
                            }
                        };
                        /**Efetuado o redirecionamento do usuário para a parte principal do sistema */
                        $location.path('/principal');

                    }, function (erro) {
                        console.log('Esse é o erro de login ' + erro);
                        console.log('Entrou em deu errado')

                        $scope.usuario = {};
                        $scope.mensagem = 'Login ou senha inválidos!';
                    }
                    );
            };

        });

})();