angular.module('recrutaif').controller('LoginController', function($scope, $http, $location){

    $scope.usuario = {};
    $scope.mensagem = '';

    $scope.autenticar = function(){

        var usuario = $scope.usuario;

        $http.post('rest/autenticar', 
            {login: usuario.login, senha: usuario.senha })
            .then(function(){
                $location.path('/');
            }, function(erro){
                console.log(erro);
                $scope.mensagem = 'Login ou senha inválidos!';
            });
    };

});