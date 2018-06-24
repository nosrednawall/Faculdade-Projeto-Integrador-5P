    angular
        .module('recrutaif')
        .controller('VagaPreenchidaController', function ($scope, $routeParams, $rootScope, recursoVaga, cadastroDeVagaPreenchida) {

            $scope.vaga = {};
            $scope.mensagem = '';

            if ($routeParams.vagaId) {
                recursoVaga.get({
                        vagaId: $routeParams.vagaId
                    },
                    // caso dê certo o que retornar será passado para setor
                    function (vaga) {
                        $scope.vaga = vaga;
                        // $scope.setor = vaga.setor;
                        console.log(vaga);
                        // console.log($scope.setor);

                    },
                    // caso dê errado será passado mensagem de erro ao usuario
                    function (erro) {
                        console.log(error);
                        $scope.mensagem = "[ERROR] Não foi encontrar vaga de ID " + $routeParams.vagaId;
                    });
            };

            $scope.candidatar = function () {

                var vagaPreenchida = [];
                vagaPreenchida.candidato = $rootScope.globals.currentUser.id;
                vagaPreenchida.vaga = $scope.vaga.id;

                cadastroDeVagaPreenchida.cadastrarCandidatura(vagaPreenchida)
                    .then(function (dados) {
                        console.log("entrou no then " + dados);
                        $scope.mensagem = dados.mensagem;
                        if (dados.inclusao) {
                            $scope.vaga = {};
                        }
                    }).catch(function (erro) {
                        $scope.mensagem = erro.mensagem;
                    });

                // $http.post('rest/vagaspreenchidas', {
                //         vagaId: vagaPreenchida.vaga,
                //         candidatoId: vagaPreenchida.candidato
                //     })
                //     .then(function () {

                //         mensagem: '[INFO] Candidatura efetuada com sucesso com sucesso!'

                //     }, function (erro) {
                //         mensagem: '[ERRO] Não foi possível efetuar acandidatura'
                //     });
            };
        });