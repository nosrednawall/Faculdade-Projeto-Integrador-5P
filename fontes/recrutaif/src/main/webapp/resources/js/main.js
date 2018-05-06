angular.module('recrutaif', ['minhasDiretivas','ngAnimate','ngRoute','appServices'])
//angular = variável global do angular; .module = cria um módulo; [módulos em que a main é dependente]

//função para rotas, ex quero ver uma lista de setores, vou em /recrutaif/#/setores
.config(function($routeProvider, $locationProvider, $httpProvider){

    //oculta o # dos enderecos, porém o servidor não está preparado
    // $locationProvider.html5Mode(true);

    //Esse é o interceptador de url na lista de urls
    $httpProvider.interceptors.push('tokenInterceptor');


    //configurração de rota, sempre a rota, o seu template e o controller correspondente
    $routeProvider.when('/setores',{
        templateUrl: 'resources/js/angular/setor/setores.html',
        controller: 'SetoresController'
    });

    $routeProvider.when('/setor/new',{
        templateUrl: 'resources/js/angular/setor/setor.html',
        controller: 'SetorController'
    });
    
    $routeProvider.when('/setor/edit/:setorId',{
        templateUrl: 'resources/angular/setor/setor.html',
        controller: 'SetorController'
    });
    
    $routeProvider.when('/login', {
        templateUrl: 'resources/js/angular/login/login.html',
        controller: 'LoginController'
    });

    // $routeProvider.when('/rota-segura', {
    //     templateUrl: 'resources/js/angular/principal/principal.html',
    //     controller: 'mainController',
    //     controllerAs: 'vm',
    //     authorize: true
    //   });


    $routeProvider.when('/principal', {
        templateUrl: 'resources/js/angular/login/login.html',
    });

    
    //caso o usuario digite algum caminho que não exista ele será redirecionado
    $routeProvider.otherwise({ redirectTo: '/principal'});
}); //criado módulo chamado recrutaif que não tem nenhuma dependencia ainda, não depende de outros módulos
