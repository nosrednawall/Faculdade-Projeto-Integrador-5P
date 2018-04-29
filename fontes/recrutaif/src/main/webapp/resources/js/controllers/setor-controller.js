angular.module('recrutaif').controller('SetorController',function($scope,$http,$resource){
    
    $scope.setores = [];
    $scope.filtro = '';
    $scope.mensagem = '';

    var recursoSetor = $resource('rest/setores/:setorId');

    recursoSetor.query(function(setores){
        $scope.setores = setores;
    }, function(erro){
        console.log(error);
        console.log("[ERROR] Erro ao listar os setores");
    });

    $scope.remover = function(setor){

        recursoSetor.delete({setorId : setor.id}, function(){
            var indiceSetor = $scope.setores.indexOf(setor);
            $scope.setores.splice(indiceSetor,1);
            $scope.mensagem = "[INFO] Setor "+setor.nome+" foi removido com sucesso!";
        }, function(){
            console.log(error);
            $scope.mensagem = "[ERROR] Erro ao remover o setor" + setor.nome;
        });
    };
});