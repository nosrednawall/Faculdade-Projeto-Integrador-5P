angular
    //      ___  ___   _____   _____   _   _   _       _____  
    //     /   |/   | /  _  \ |  _  \ | | | | | |     /  _  \ 
    //    / /|   /| | | | | | | | | | | | | | | |     | | | | 
    //   / / |__/ | | | | | | | | | | | | | | | |     | | | | 
    //  / /       | | | |_| | | |_| | | |_| | | |___  | |_| | 
    // /_/        |_| \_____/ |_____/ \_____/ |_____| \_____/ 
    .module('usuarioServices', ['ngResource'])
    // _____       ___   _____   _____   _____   _____   __    __       ___  
    // |  ___|     /   | /  ___| |_   _| /  _  \ |  _  \  \ \  / /      |_  | 
    // | |__      / /| | | |       | |   | | | | | |_| |   \ \/ /         | | 
    // |  __|    / / | | | |       | |   | | | | |  _  /    \  /          | | 
    // | |      / /  | | | |___    | |   | |_| | | | \ \    / /           | | 
    // |_|     /_/   |_| \_____|   |_|   \_____/ |_|  \_\  /_/            |_|   
    .factory('recursoUsuario',
        // _____   _   _   __   _   _____       ___   _____  
        // |  ___| | | | | |  \ | | /  ___|     /   | /  _  \ 
        // | |__   | | | | |   \| | | |        / /| | | | | | 
        // |  __|  | | | | | |\   | | |       / / | | | | | | 
        // | |     | |_| | | | \  | | |___   / /  | | | |_| | 
        // |_|     \_____/ |_|  \_| \_____| /_/   |_| \_____/ 
        function ($resource) {

            /**Toda vez que solicitar esse service, será dado o caminho rest, para quase todos os verbos http */
            return $resource('rest/usuarios/:usuarioId', null, {
                update: {
                    method: 'PUT'
                }
            });
        } /**Fecha funcão */
    ) /**Fecha Factory 1 */

    .factory('listaUsuarios', function ($resource) {

        //retorna um recurso
        return $resource('rest/usuarios/listar/:statusId', null);
    })

    // ________________________________________________________________________________________________________
    // _____       ___   _____   _____   _____   _____   __    __       _____  
    // |  ___|     /   | /  ___| |_   _| /  _  \ |  _  \  \ \  / /      /___  \ 
    // | |__      / /| | | |       | |   | | | | | |_| |   \ \/ /        ___| | 
    // |  __|    / / | | | |       | |   | | | | |  _  /    \  /        /  ___/ 
    // | |      / /  | | | |___    | |   | |_| | | | \ \    / /         | |___  
    // |_|     /_/   |_| \_____|   |_|   \_____/ |_|  \_\  /_/          |_____| 

    .factory('cadastroUsuario',

        // _____   _   _   __   _   _____       ___   _____  
        // |  ___| | | | | |  \ | | /  ___|     /   | /  _  \ 
        // | |__   | | | | |   \| | | |        / /| | | | | | 
        // |  __|  | | | | | |\   | | |       / / | | | | | | 
        // | |     | |_| | | | \  | | |___   / /  | | | |_| | 
        // |_|     \_____/ |_|  \_| \_____| /_/   |_| \_____/ 

        /** Nessa função será efetuado a inserção ou atualizacao do objeto no servidor backend*/
        function (recursoUsuario, $q, $http) {

            /**É retornado um objeto chamado serviço */
            var servico = {};

            /** Servico possui apenas o metodo salvar, passando o objeto como argumento */
            servico.cadastrar = function (usuario) {

                /** Como o servidor pode demorar para enviar a resposta, se enviar, é necessário trabalhar com promessas $q*/
                return $q(function (resolve, reject) {
                    /**Uma promessa tem dois destino, a de resolve que deu tudo certo, foi resolvido, e a reject, que deu tudo errado, foi rejeitado */

                    /**Verifica se o usuário possui ID, se sim é atualizado, se não é inserido um novo usuário */
                    if (usuario.id != null) {
                        console.log(usuario.dataAdmissao);
                        /**Pega a funcao da factory1, ali em cima, e adiciona o verbete update mais o usuário */
                        recursoUsuario.update({ usuarioId: usuario.id }, usuario, function () {
                            /**Caso dê certo */
                            resolve({
                                mensagem: '[INFO] usuario ' + usuario.nome + ' atualizado com sucesso!',
                                inclusao: false
                            });
                            /**Caso dê errado */
                        }, function (erro) {
                            console.log(erro);
                            reject({
                                mensagem: '[ERRO] Não foi possível alterar o usuario ' + usuario.nome
                            });
                        }); /**Fecha o resursoUsuario.update */

                    }/**Fecha o if usuario.id */
                    // ________________________________________________________________________________________________________

                    else {
                        /**Esses parâmetros são apenas para teste, irão sair daqui com o crescimento da aplicação*/
                        usuario.permissao = 'ADMINISTRADOR';
                        usuario.status = 'ATIVO';

                        console.log(usuario.dataAdmissao);
                        recursoUsuario.save(usuario, function () {
                            resolve({
                                mensagem: '[INFO]usuario ' + usuario.nome + ' Adicionado com sucesso!',
                                inclusao: true
                            });
                        } /**Fecha o function sucess */
                            , function (erro) {
                                console.log(erro);
                                reject({
                                    mensagem: '[ERRO] Não foi possível incluir o usuario ' + usuario.nome
                                });
                            } /**Fecha o function erro */
                        ); /**Fecha o recursoUsuario.save */
                    }/**Fecha o else */
                }); /**Fecha o return da promessa $q */
            }; /**Fecha o servico cadastrar */
            /**Retorna o servico executado */
            return servico;
        } /**Fecha a funcao */
    );/**Fecha a factory2 e o angular*/