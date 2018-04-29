angular.module('recrutaif').controller('SetorController',function($scope,$http){
    
    $scope.setores = [];
    $scope.filtro = '';
    $scope.mensagem = '';

    $http.get('rest/setores/')
    .success(function(setores){
        
        $scope.setores = setores;
    })
    .error(function(error){
        console.log(error);
        console.log("[ERROR] Erro ao listar os setores");
    });

    $scope.remover = function(setor){
        $http.delete('rest/setores/' + setor.id)
        .success(function(){
            var indiceSetor = $scope.setores.indexOf(setor);
            $scope.setores.splice(indiceSetor,1);
            $scope.mensagem = "[INFO] Setor "+setor.nome+" foi removido com sucesso!";
        })
        .error(function(error){
            console.log(error);
            $scope.mensagem = "[ERROR] Erro ao remover o setor" + setor.nome;
        });
    };
});