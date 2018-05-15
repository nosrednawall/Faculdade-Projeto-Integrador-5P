angular.module('recrutaif', ['minhasDiretivas','ngAnimate','ngRoute','ngResource','appServices'])
//angular = variável global do angular; .module = cria um módulo; [módulos em que a main é dependente]

//função para rotas, ex quero ver uma lista de setores, vou em /recrutaif/#/setores
.config(function($routeProvider, $locationProvider, $httpProvider){

    //Esse é o interceptador de url na lista de urls
    $httpProvider.interceptors.push('tokenInterceptor');

    //configurração de rota, sempre a rota, o seu template e o controller correspondente
    $routeProvider.when('/setores',{
        templateUrl: 'app/setor/setores.html',
        controller: 'SetoresController'
    });

    $routeProvider.when('/setor/new',{
        templateUrl: 'app/setor/setor.html',
        controller: 'SetorController'
    });
    
    $routeProvider.when('/setor/edit/:setorId',{
        templateUrl: 'app/setor/setor.html',
        controller: 'SetorController'
    });
    
    $routeProvider.when('/login', {
        templateUrl: 'app/login/login.html',
        controller: 'LoginController'
    });

    $routeProvider.when('/principal', {
        templateUrl: 'app/principal/principal.html',
    });

    $routeProvider.otherwise({ redirectTo: '/principal'});
}); //criado módulo chamado recrutaif que não tem nenhuma dependencia ainda, não depende de outros módulos
