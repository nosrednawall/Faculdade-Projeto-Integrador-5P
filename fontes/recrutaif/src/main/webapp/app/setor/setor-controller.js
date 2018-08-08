(function () {
    'use strict';
    angular
        .module('recrutaif')
        .controller('SetorController', function ($scope, $routeParams, recursoSetor, cadastroDeSetor) {

            //variáveis para interação com o scopo
            $scope.setor = {};
            $scope.mensagem = '';

            //get ou busca setor
            if ($routeParams.setorId) {
                //faz uma requisição get, passando o numero do parametro da url para o coringa, 
                recursoSetor.get({ setorId: $routeParams.setorId },
                    //caso dê certo o que retornar será passado para setor
                    function (setor) {
                        $scope.setor = setor;
                    },
                    //caso dê errado será passado mensagem de erro ao usuario
                    function (erro) {
                        console.log(error);
                        $scope.mensagem = "[ERROR] Não foi encontrar setor de ID " + $routeParams.setorId;
                    });
            };

            //função adiciona um novo setor e ou atualiza um setor existente
            $scope.submeter = function () {
                //verifica se o formulario é válido
                if ($scope.formulario.$valid) {
                    //tenta cadastrar o setor usando a funcao cadastroDeSetor, passando o setor do scope
                    cadastroDeSetor.cadastrar($scope.setor)
                        //se der certo a mensagem é atualizada com o sucesso
                        .then(function (dados) {
                            console.log("entrou no then " + dados);
                            $scope.mensagem = dados.mensagem;
                            //se inclusao retornar true, ele limpa o objeto setor
                            if (dados.inclusao) {
                                $scope.setor = {};
                                // $scope.focado = true;
                            }
                            //se der algum erro, o erro é capturado(catch), e atualizado a mensagem com o erro
                        }).catch(function (erro) {
                            $scope.mensagem = erro.mensagem;
                        });
                }
            };
        });
})();