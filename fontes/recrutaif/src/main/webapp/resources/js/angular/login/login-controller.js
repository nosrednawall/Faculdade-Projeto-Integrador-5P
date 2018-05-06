angular.module('recrutaif').controller('LoginController', function($scope, $http, $location){

    $scope.usuario = {};
    $scope.mensagem = '';

    $scope.autenticar = function(){

        var usuario = $scope.usuario;

        $http.post('rest/login', 
            {
                email: usuario.email,
                senha: usuario.senha 
            })
            .then(function(){
                $location.path('/principal');

                console.log('Entrou em deu certo')

            }, function(erro){
                console.log(erro);
                console.log('Entrou em deu errado')

                $scope.usuario = {};
                $scope.mensagem = 'Login ou senha inválidos!';
            });
    };

});