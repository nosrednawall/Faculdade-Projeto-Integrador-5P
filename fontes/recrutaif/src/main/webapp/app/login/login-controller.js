angular.module('recrutaif').controller('LoginController',['$cookieStore',
    function ($cookieStore, $window, $q, $scope, $http, $location) {

        $scope.usuario = {};
        $scope.mensagem = '';

        delete $window.sessionStorage.token;


        $scope.autenticar = function () {

            var usuarioNaoLogado = $scope.usuario;

            console.log('email: ' + usuarioNaoLogado.email);
            console.log('senha: ' + usuarioNaoLogado.senha);


            $http.post('rest/login', { email: usuarioNaoLogado.email, senha: usuarioNaoLogado.senha })
                .then(function (usuarioLogado) {

                    console.log(usuarioLogado);

                    $cookieStore.put("nome", usuarioLogado.nome);
                    $cookieStore.put("id", usuarioLogado.id);
                    $cookieStore.put("permissao", usuarioLogado.permissao);
                    $cookieStore.put("logado", true);

                    $location.path('/principal');

                }, function (erro) {
                    console.log('Esse é o erro de login ' + erro);
                    console.log('Entrou em deu errado')

                    $scope.usuario = {};
                    $scope.mensagem = 'Login ou senha inválidos!';
                }
                );
        };

    }]);