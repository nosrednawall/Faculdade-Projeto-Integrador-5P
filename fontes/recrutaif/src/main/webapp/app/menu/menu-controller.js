(function () {
    'use strict';
    angular
        .module('recrutaif')
        .controller('MenuController', function ($cookieStore, $scope, recursoUsuario, $rootScope, $location, $http) {

            var usuarioLogado = $rootScope.globals.currentUser;
            console.log(usuarioLogado);
            $scope.usuarioLogado = usuarioLogado;

        }); /**Fecha o angular.module */
}); /**Fecha a function use strict */