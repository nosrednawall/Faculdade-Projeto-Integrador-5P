angular.module('recrutaif', ['minhasDiretivas','ngAnimate','ngRoute','appServices'])
//angular = variável global do angular; .module = cria um módulo; [módulos em que a main é dependente]

//função para rotas, ex quero ver uma lista de setores, vou em /recrutaif/#/setores
.config(function($routeProvider){

    //oculta o # dos enderecos, porém o servidor não está preparado
    // $locationProvider.html5Mode(true);

    //configurração de rota, sempre a rota, o seu template e o controller correspondente
    $routeProvider.when('/setores',{
        templateUrl: 'resources/partials/principal.html',
        controller: 'SetoresController'
    });

    $routeProvider.when('/setores/new',{
        templateUrl: 'resources/partials/adiciona-setor.html',
        controller: 'SetorController'
    });
    
    $routeProvider.when('/setores/edit/:setorId',{
        templateUrl: 'resources/partials/adiciona-setor.html',
        controller: 'SetorController'
    });
    
    $routeProvider.when('/login', {
        templateUrl: 'resources/partials/login.html',
        controller: 'LoginController'
    });

    
    //caso o usuario digite algum caminho que não exista ele será redirecionado
    $routeProvider.otherwise({ redirectTo: '/setores'});
}); //criado módulo chamado recrutaif que não tem nenhuma dependencia ainda, não depende de outros módulos
