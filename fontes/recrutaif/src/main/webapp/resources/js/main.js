angular.module('recrutaif', ['minhasDiretivas','ngAnimate','ngRoute','ngResource'])
.config(function($routeProvider){

    //oculta o # dos enderecos, porém o servidor não está preparado
    // $locationProvider.html5Mode(true);

    $routeProvider.when('/setores',{
        templateUrl: 'resources/partials/principal.html',
        controller: 'SetorController'
    });

    $routeProvider.when('/setores/new',{
        templateUrl: 'resources/partials/adiciona-setor.html',
        controller: 'AdicionaSetorController'
    });
    
    $routeProvider.when('/setores/edit/:setorId',{
        templateUrl: 'resources/partials/adiciona-setor.html',
        controller: 'AdicionaSetorController'
    });
    //caso o usuario digite algum caminho que não exista ele será redirecionado
    $routeProvider.otherwise({ redirectTo: '/setores'});
}); //criado módulo chamado recrutaif que não tem nenhuma dependencia ainda, não depende de outros módulos