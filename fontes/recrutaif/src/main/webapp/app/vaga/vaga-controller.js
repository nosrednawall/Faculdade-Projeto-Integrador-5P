    angular
        .module('recrutaif')
        .controller('VagaController', function ($scope, $routeParams, recursoVaga, cadastroDeVaga, listaSetores) {

            // variáveis para interação com o scopo
            $scope.vaga = {};
            $scope.mensagem = '';


            /** get ou busca vaga */
            if ($routeParams.vagaId) {
                // faz uma requisição get, passando o numero do parametro da url
                // para o coringa,
                $scope.setor = {};
                recursoVaga.get({
                        vagaId: $routeParams.vagaId
                    },
                    // caso dê certo o que retornar será passado para setor
                    function (vaga) {
                        $scope.vaga = vaga;
                        $scope.setor = vaga.setor;
                        console.log(vaga);
                        console.log($scope.setor);

                    },
                    // caso dê errado será passado mensagem de erro ao usuario
                    function (erro) {
                        console.log(error);
                        $scope.mensagem = "[ERROR] Não foi encontrar vaga de ID " + $routeParams.vagaId;
                    });
            };

            /** Função responsável por colocar o nome e o id de setor no select */
            listaSetores.query({
                statusId: 0
            }, function (setores) {
                // salva a lista de setores dentro da variável de escope
                // $setores
                $scope.setores = setores;
            }, function (erro) {
                // caso dê erro imprime o erro para o usuário
                console.log(error);
                console.log("[ERROR] Erro ao listar os setores");
            });

            // função adiciona um novo vaga e ou atualiza um vaga existente
            $scope.submeter = function () {
                // verifica se o formulario é válido
                if ($scope.formulario.$valid) {
                    // tenta cadastrar o vaga usando a funcao cadastroDevaga,
                    // passando o vaga do scope
                    console.log($scope.vaga);
                    cadastroDeVaga.cadastrar($scope.vaga)
                        // se der certo a mensagem é atualizada com o sucesso
                        .then(function (dados) {
                            console.log("entrou no then " + dados);
                            $scope.mensagem = dados.mensagem;
                            // se inclusao retornar true, ele limpa o objeto
                            // vaga
                            if (dados.inclusao) {
                                $scope.vaga = {};
                                // $scope.focado = true;
                            }
                            // se der algum erro, o erro é capturado(catch), e
                            // atualizado a mensagem com o erro
                        }).catch(function (erro) {
                            $scope.mensagem = erro.mensagem;
                        });
                }
            };
        });