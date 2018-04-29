angular.module('recrutaif').controller('AdicionaSetorController',function($scope, $http){
    $scope.setor = {};
     
    $scope.submeter = function(){
        $http.post('rest/setores/', $scope.setor)
            .success(function(){
                console.log("[INFO]Setor "+ $scope.setor.nome +" Adicionado com sucesso!")
            })
            .error(function(){
                console.log("[ERROR] erro ao enviar objeto ao servidor")
            });
    };
});