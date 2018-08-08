(function () {
    'use strict';
    angular
        .module('recrutaif')
        .controller('SetoresController', function ($scope, recursoSetor, listaSetores) {

            $scope.setores = []; //variável responsável pelo loop de setor dentro do scope
            $scope.filtro = ''; //variável responsável pelo filtro de setores, dentro do scope
            $scope.mensagem = ''; //variável responsável pela mensagem de interação com o usuário dentro do scope

            listaSetores.query({
                statusId: 2
            }, function (setores) {
                $scope.setores = setores;
            }, function (erro) {
                console.log(error);
                console.log("[ERROR] Erro ao listar os setores");
            });

            $scope.inativar = function (setor) {

                if (setor.status === "ATIVO") {
                    setor.status = "INATIVO";
                } else {
                    setor.status = "ATIVO";
                }

                recursoSetor.update({
                    setorId: setor.id
                }, setor, function () {
                    resolve({
                        mensagem: '[INFO] Setor ' + setor.nome + ' atualizado com sucesso!',
                        inclusao: false
                    });
                }, function (erro) {
                    console.log(erro);
                    reject({
                        mensagem: '[ERRO] Não foi possível alterar o setor ' + setor.nome
                    });
                });
            };
        });
})();