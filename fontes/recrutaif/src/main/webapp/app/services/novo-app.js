angular.module('appServices', ['ngResource'])
    //módulo que configura o caminho para acessar os recursos rest da aplicação TODA

    //cria uma fabrica de recursos
    .factory('recursoSetor', function ($resource) {

        //retorna um recurso
        return $resource('rest/setores/:setorId', null, {
            update: {
                method: 'PUT'
            }
        });
    })
    //o $q serve para trabalhar com as promessas
    .factory('cadastroDeSetor', function (recursoSetor, $q) {

        var servico = {};

        servico.cadastrar = function (setor) {
            //retornando promessa na mão
            return $q(function (resolve, reject) {

                //verifica se o setor informado possui id
                if (setor.id) {

                    recursoSetor.update({ setorId: setor.id }, setor, function () {
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

                } else {

                    recursoSetor.save(setor, function () {
                        resolve({
                            mensagem: '[INFO]Setor' + setor.nome + 'Adicionado com sucesso!',
                            inclusao: true
                        });
                    }, function (erro) {
                        reject({
                            mensagem: '[ERRO] Não foi possível incluir o setor ' + setor.nome
                        });
                    });
                }
            });
        };


        return servico;
    })

    //cria uma fabrica de recursos
    .factory('recursoVaga', function ($resource) {

        //retorna um recurso
        return $resource('rest/vagas/:vagaId', null, {
            update: {
                method: 'PUT' //Estudar 
            }
        });
    })

    .factory('cadastroDeVaga', function (recursoVaga, $q) {

        var servico = {};

        servico.cadastrar = function (vaga) {
            //retornando promessa na mão
            return $q(function (resolve, reject) {

                //verifica se o setor informado possui id
                if (vaga.id) {

                    recursoVaga.update({ vagaId: vaga.id }, vaga, function () {
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
                            mensagem: '[INFO]Setor' + vaga.titulo + 'Adicionado com sucesso!',
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
        return servico;
    })
    ;