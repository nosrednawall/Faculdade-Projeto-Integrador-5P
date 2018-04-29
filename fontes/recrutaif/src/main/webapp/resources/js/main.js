angular.module('recrutaif', ['minhasDiretivas','ngAnimate','ngRoute'])
.config(function($routeProvider){
    $routeProvider.when('/setores',{
        templateUrl: 'resources/partials/principal.html',
        controller: 'SetorController'
    });
}); //criado módulo chamado recrutaif que não tem nenhuma dependencia ainda, não depende de outros módulos