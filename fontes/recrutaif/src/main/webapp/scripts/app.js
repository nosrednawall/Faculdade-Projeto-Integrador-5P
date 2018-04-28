'use strict';

angular.module('recrutaif',['ngRoute','ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/Setors',{templateUrl:'views/Setor/search.html',controller:'SearchSetorController'})
      .when('/Setors/new',{templateUrl:'views/Setor/detail.html',controller:'NewSetorController'})
      .when('/Setors/edit/:SetorId',{templateUrl:'views/Setor/detail.html',controller:'EditSetorController'})
      .when('/Usuarios',{templateUrl:'views/Usuario/search.html',controller:'SearchUsuarioController'})
      .when('/Usuarios/new',{templateUrl:'views/Usuario/detail.html',controller:'NewUsuarioController'})
      .when('/Usuarios/edit/:UsuarioId',{templateUrl:'views/Usuario/detail.html',controller:'EditUsuarioController'})
      .when('/Vagas',{templateUrl:'views/Vaga/search.html',controller:'SearchVagaController'})
      .when('/Vagas/new',{templateUrl:'views/Vaga/detail.html',controller:'NewVagaController'})
      .when('/Vagas/edit/:VagaId',{templateUrl:'views/Vaga/detail.html',controller:'EditVagaController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
