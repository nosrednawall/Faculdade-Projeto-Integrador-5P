angular.module('recrutaif').controller('VagasController',function($scope,recursoSetor){
    //módulos que não são mais utilizados, porque estão sendo injetados pelo recursoSetor: $http,$resource

//módulo controller, para setor

    //variáveis de interação com o scope
    $scope.setores = [];    //variável responsável pelo loop de setor dentro do scope
    $scope.filtro = ''; //variável responsável pelo filtro de setores, dentro do scope
    $scope.mensagem = '';   //variável responsável pela mensagem de interação com o usuário dentro do scope

    // essa variável não é mais utilizada porque está sendo injetada pelo recursoSetor nos módulos acima
    // var recursoSetor = $resource('rest/setores/:setorId');

    //função busca uma lista de setores
    recursoSetor.query(function(setores){
        //salva a lista de setores dentro da variável de escope $setores
        $scope.setores = setores;
    }, function(erro){
        //caso dê erro imprime o erro para o usuário
        console.log(error);
        console.log("[ERROR] Erro ao listar os setores");
    });

    //funcao para remover setor
    $scope.remover = function(setor){

        //ele tenta remover um setor, passando o id em setor.id ao coringa setorId
        recursoSetor.delete({setorId : setor.id}, function(){

            //caso dê certo é atualizado a lista e informado o usuário
            var indiceSetor = $scope.setores.indexOf(setor);
            $scope.setores.splice(indiceSetor,1);
            $scope.mensagem = "[INFO] Setor "+setor.nome+" foi removido com sucesso!";
        }, function(){

            //caso dê erro é informado o usuário
            console.log(error);
            $scope.mensagem = "[ERROR] Erro ao remover o setor" + setor.nome;
        });
    };
});