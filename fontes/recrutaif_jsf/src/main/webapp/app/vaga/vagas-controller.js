angular
    .module('recrutaif')
    .controller('VagasController', function ($scope, recursoVaga, listaVagas) {

        /**
         * Declaração de variáveis
         */
        $scope.vagas = []; //variável responsável pelo loop de setor dentro do scope
        $scope.filtro = ''; //variável responsável pelo filtro de setores, dentro do scope
        $scope.mensagem = ''; //variável responsável pela mensagem de interação com o usuário dentro do scope

        /**
         * Método que carrega vagas do bd e mostra na tela
         */
        listaVagas.query({
            statusId: 0
        }, function (vagas) {
            $scope.vagas = vagas;
        }, function (erro) {
            console.log(error);
            console.log("[ERROR] Erro ao listar as vagas");
        });

        /**
         * Metodo que altera um vaga, inativa ou ativa
         */
        $scope.alterar = function (vaga) {

            if (vaga.status === 'ATIVO') {
                vaga.status = 'INATIVO';
            } else {
                vaga.status = 'ATIVO';
            }

            recursoVaga.update({
                vagaId: vaga.id
            }, vaga, function () {

                var indiceVagas = $scope.vagas.indexOf(vaga);
                $scope.vagas.splice(indiceVagas, 1);
                if (vaga.status === 'ATIVO') {
                    $scope.mensagem = "[INFO] Vaga " + vaga.titulo + " foi ativada com sucesso!";
                } else {
                    $scope.mensagem = "[INFO] Vaga " + vaga.titulo + " foi inativada com sucesso!";
                }

            }, function () {
                console.log(error);
                $scope.mensagem = "[ERROR] Erro ao alterar a vaga" + vaga.titulo;
            });
        };
    });