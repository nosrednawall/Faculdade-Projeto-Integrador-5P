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
                        console.log(vaga);
                    },
                    // caso dê errado será passado mensagem de erro ao usuario
                    function (erro) {
                        console.log(error);
                        $scope.mensagem = "[ERROR] Não foi encontrar vaga de ID " + $routeParams.vagaId;
                    });
            };

            $scope.candidatar = function () {

                var vagaPreenchida = [];
                vagaPreenchida.vagaId = $scope.vaga.id;
                vagaPreenchida.candidatoId = $rootScope.globals.currentUser.id;

                console.log('entrou em candidatar');
                console.log(vagaPreenchida);
                cadastroDeVagaPreenchida.cadastrarCandidatura(vagaPreenchida)
                    .then(function (dados) {
                        console.log("entrou no then " + dados);
                        $scope.mensagem = dados.mensagem;

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