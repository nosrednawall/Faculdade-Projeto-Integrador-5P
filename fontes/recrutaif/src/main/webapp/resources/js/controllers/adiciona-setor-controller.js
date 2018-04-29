angular.module('recrutaif').controller('AdicionaSetorController',function($scope){
    $scope.setor = {};
     
    $scope.submeter = function(){
        console.log($scope.setor);
    };
});