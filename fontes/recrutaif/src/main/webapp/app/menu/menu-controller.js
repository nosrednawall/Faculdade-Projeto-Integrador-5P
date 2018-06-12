(function () {
    'use strict';
    angular
        .module('recrutaif')
        .controller('MenuController', function ($cookieStore, $scope, recursoUsuario) {
            
            var UsuarioLogado = [];
            UsuarioLogado.id = $cookieStore.get.id;
            console.log(UsuarioLogado.id);
            $scope.UsuarioLogado = UsuarioLogado;

        }); /**Fecha o angular.module */
}); /**Fecha a function use strict */