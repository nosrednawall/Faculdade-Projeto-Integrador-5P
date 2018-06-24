angular.module('vagaPreenchidaServices', ['ngResource'])
    //módulo que configura o caminho para acessar os recursos rest da aplicação TODA

    //cria uma fabrica de recursos
    .factory('recursoVagaPreenchida', function ($resource) {

        //retorna um recurso
        return $resource('rest/vagaspreenchidas/:vagaPreenchidaId', null, {
            update: {
                method: 'PUT' //Estudar 
            }
        });
    })

    .factory('cadastroDeVagaPreenchida', function (recursoVagaPreenchida, $q) {

        var servico = {};

        servico.cadastrarCandidatura = function (vagaPreenchida) {
            //retornando promessa na mão
            return $q(function (resolve, reject) {
                console.log(vagaPreenchida);

                recursoVagaPreenchida.save({
                    vagaId: vagaPreenchida.vagaId,
                    candidatoId: vagaPreenchida.candidatoId
                }, function () {
                    resolve({
                        mensagem: '[INFO] Candidatura efetuada com sucesso com sucesso!',
                        inclusao: false
                    });
                }, function (erro) {
                    console.log(erro);
                    reject({
                        mensagem: '[ERRO] Não foi possível efetuar acandidatura'
                    });
                });
            });
        };
        return servico;
    });