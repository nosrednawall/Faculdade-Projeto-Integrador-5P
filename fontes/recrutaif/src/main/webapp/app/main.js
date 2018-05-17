<<<<<<< HEAD
angular.module('recrutaif', ['minhasDiretivas','ngAnimate','ngRoute','ngResource','vagaServices','setorServices'])
//angular = variável global do angular; .module = cria um módulo; [módulos em que a main é dependente]

//função para rotas, ex quero ver uma lista de setores, vou em /recrutaif/#/setores
.config(function($routeProvider, $locationProvider, $httpProvider){

    //Esse é o interceptador de url na lista de urls
    //$httpProvider.interceptors.push('tokenInterceptor');

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

    //vaga

    $routeProvider.when('/vagas',{
        templateUrl: 'app/vaga/vagas.html',
        controller: 'VagasController'
    });
    
    $routeProvider.when('/criavaga',{
        templateUrl: 'app/vaga/criavaga.html',
        controller: 'CriaVagaController'
    });
    
    $routeProvider.when('/criavaga/edit/:vagaId',{
        templateUrl: 'app/vaga/criavaga.html',
        controller: 'CriaVagaController'
    });
    $routeProvider.otherwise({ redirectTo: '/principal'});
}); //criado módulo chamado recrutaif que não tem nenhuma dependencia ainda, não depende de outros módulos
=======
angular.module('recrutaif', ['minhasDiretivas', 'ngAnimate', 'ngRoute', 'ngResource', 'appServices'])
    //angular = variável global do angular; .module = cria um módulo; [módulos em que a main é dependente]

    //função para rotas, ex quero ver uma lista de setores, vou em /recrutaif/#/setores
    .config(function ($routeProvider, $locationProvider, $httpProvider) {

        //Esse é o interceptador de url na lista de urls
        $httpProvider.interceptors.push('tokenInterceptor');

        //configurração de rota, sempre a rota, o seu template e o controller correspondente
        $routeProvider.when('/setores', {
            templateUrl: 'app/setor/setores.html',
            controller: 'SetoresController'
        });

        $routeProvider.when('/setor/new', {
            templateUrl: 'app/setor/setor.html',
            controller: 'SetorController'
        });

        $routeProvider.when('/setor/edit/:setorId', {
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
        
        //vaga

        $routeProvider.when('/vagas',{
            templateUrl: 'app/vaga/vagas.html',
            controller: 'VagasController'
        });
        
        $routeProvider.when('/criavaga',{
            templateUrl: 'app/vaga/criavaga.html',
            controller: 'CriaVagaController'
        });
        
        $routeProvider.when('/criavaga/edit/:vagaId',{
            templateUrl: 'app/vaga/criavaga.html',
            controller: 'CriaVagaController'
        });
        
        $routeProvider.otherwise({ redirectTo: '/principal' });
    });
>>>>>>> d7b193ab7a99104ea376ea2580fcec3cb32e3e9f
