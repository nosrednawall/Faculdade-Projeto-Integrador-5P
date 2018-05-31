angular.module('recrutaif').controller('LoginController',
    function ($cookieStore, $window, $q, $scope, $http, $location) {

        $scope.usuario = {};
        $scope.mensagem = '';

        delete $window.sessionStorage.token;


        $scope.autenticar = function () {

            var usuarioNaoLogado = $scope.usuario;

            $http.post('rest/login', { email: usuarioNaoLogado.email, senha: usuarioNaoLogado.senha })
                .then(function (usuarioLogado) {


                    console.log(usuarioLogado);

                    $cookieStore.put('nome', usuarioLogado.data.nome);
                    console.log($cookieStore.get('nome'))
                    $cookieStore.put('id', usuarioLogado.data.id);
                    $cookieStore.put('permissao', usuarioLogado.data.permissao);
                    $cookieStore.put('logado', true);

                    $location.path('/principal');

                    // { "id": 3, "nome": "Ghost", "senha": "ghost", "matricula": "1011", "email": "ghost@ghost", "dataAdmissao": { "year": 2018, "month": 4, "dayOfMonth": 17, "hourOfDay": 0, "minute": 0, "second": 0 }, "permissao": "ADMINISTRADOR", "status": "ATIVO", "candidaturas": [] }


                }, function (erro) {
                    console.log('Esse é o erro de login ' + erro);
                    console.log('Entrou em deu errado')

                    $scope.usuario = {};
                    $scope.mensagem = 'Login ou senha inválidos!';
                }
                );
        };

    });