angular.module('recrutaif').controller('VagasController', function ($scope, recursoVaga, listaVagas) {
    //módulos que não são mais utilizados, porque estão sendo injetados pelo recursoSetor: $http,$resource

    //módulo controller, para setor

    //variáveis de interação com o scope
    $scope.vagas = []; //variável responsável pelo loop de setor dentro do scope
    $scope.filtro = ''; //variável responsável pelo filtro de setores, dentro do scope
    $scope.mensagem = ''; //variável responsável pela mensagem de interação com o usuário dentro do scope

    // essa variável não é mais utilizada porque está sendo injetada pelo recursoSetor nos módulos acima
    // var recursoSetor = $resource('rest/setores/:setorId');

    //função busca uma lista de setores
    listaVagas.query({
        statusId: 0
    }, function (vagas) {
        //salva a lista de setores dentro da variável de escope $setores
        $scope.vagas = vagas;
    }, function (erro) {
        //caso dê erro imprime o erro para o usuário
        console.log(error);
        console.log("[ERROR] Erro ao listar as vagas");
    });

    //funcao para remover setor
    $scope.inativar = function (vaga) {

        vaga.status = 'INATIVO';

        //ele tenta remover um setor, passando o id em setor.id ao coringa setorId
        recursoVaga.update({
            vagaId: vaga.id
        }, vaga, function () {

            //caso dê certo é atualizado a lista e informado o usuário
            var indiceVagas = $scope.vagas.indexOf(vaga);
            $scope.vagas.splice(indiceVagas, 1);
            $scope.mensagem = "[INFO] Vaga " + vaga.titulo + " foi removido com sucesso!";
        }, function () {

            //caso dê erro é informado o usuário
            console.log(error);
            $scope.mensagem = "[ERROR] Erro ao remover a vaga" + vaga.titulo;
        });
    };
});