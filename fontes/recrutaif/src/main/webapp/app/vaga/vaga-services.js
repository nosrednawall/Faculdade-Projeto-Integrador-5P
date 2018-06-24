angular.module('vagaServices', ['ngResource'])
    //módulo que configura o caminho para acessar os recursos rest da aplicação TODA

    //cria uma fabrica de recursos
    .factory('recursoVaga', function ($resource) {

        //retorna um recurso
        return $resource('rest/vagas/:vagaId', null, {
            update: {
                method: 'PUT' //Estudar 
            }
        });
    })

    //cria uma fabrica de recursos
    .factory('listaVagas', function ($resource) {

        //retorna um recurso
        return $resource('rest/vagas/listar/:statusId', null);
    })

    .factory('cadastroDeVaga', function (recursoVaga, $q) {

        var servico = {};

        servico.cadastrar = function (vaga) {
            //retornando promessa na mão
            return $q(function (resolve, reject) {

                //verifica se o setor informado possui id
                if (vaga.id) {

                    recursoVaga.update({
                        vagaId: vaga.id
                    }, vaga, function () {
                        resolve({
                            mensagem: '[INFO] Vaga ' + vaga.titulo + ' atualizado com sucesso!',
                            inclusao: false
                        });
                    }, function (erro) {
                        console.log(erro);
                        reject({
                            mensagem: '[ERRO] Não foi possível altera ' + vaga.titulo
                        });
                    });

                } else {

                    recursoVaga.save(vaga, function () {
                        resolve({
                            mensagem: '[INFO]Vaga' + vaga.titulo + 'Adicionado com sucesso!',
                            inclusao: true
                        });
                    }, function (erro) {
                        reject({
                            mensagem: '[ERRO] Não foi possível incluir  ' + vaga.titulo
                        });
                    });
                }
            });
        };

        servico.cadastrarCandidatura = function (vagaPreenchida) {
            //retornando promessa na mão
            return $q(function (resolve, reject) {
                console.log(vagaPreenchida);

                recursoVagaPreenchida.save(vagaPreenchida, function () {
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