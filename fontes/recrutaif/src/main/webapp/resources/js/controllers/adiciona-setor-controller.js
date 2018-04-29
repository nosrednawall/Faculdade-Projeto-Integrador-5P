angular.module('recrutaif').controller('AdicionaSetorController',function($scope, $http){
    $scope.setor = {};
    $scope.mensagem = '';
     
    $scope.submeter = function(){
        if($scope.formulario.$valid){
            $http.post('rest/setores/', $scope.setor)
            .success(function(){
                console.log("[INFO]Setor "+ $scope.setor.nome +" Adicionado com sucesso!");
                $scope.mensagem = "[INFO]Setor "+ $scope.setor.nome +" Adicionado com sucesso!";

                $scope.setor = '';
            })
            .error(function(){
                console.log("[ERROR] Não foi possível incluir setor");
                $scope.mensagem = "[ERROR] Não foi possível incluir setor";
                
            });
        }
    };
});