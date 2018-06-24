    angular
        .module('recrutaif')
        .controller('VagaPreenchidaController', function ($scope, $routeParams, $rootScope, $http, recursoVaga) {

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

                $http.post('rest/vagaspreenchidas', {
                        vagaId: vagaPreenchida.vaga,
                        candidatoId: vagaPreenchida.candidato
                    })
                    .then(function () {

                        mensagem: '[INFO] Candidatura efetuada com sucesso com sucesso!'

                    }, function (erro) {
                        mensagem: '[ERRO] Não foi possível efetuar acandidatura'
                    });
            };
        });