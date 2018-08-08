angular
    //      ___  ___   _____   _____   _   _   _       _____  
    //     /   |/   | /  _  \ |  _  \ | | | | | |     /  _  \ 
    //    / /|   /| | | | | | | | | | | | | | | |     | | | | 
    //   / / |__/ | | | | | | | | | | | | | | | |     | | | | 
    //  / /       | | | |_| | | |_| | | |_| | | |___  | |_| | 
    // /_/        |_| \_____/ |_____/ \_____/ |_____| \_____/ 

    .module('recrutaif')

    // _____   _____   __   _   _____   _____    _____   _       _       _____   _____   
    // /  ___| /  _  \ |  \ | | |_   _| |  _  \  /  _  \ | |     | |     | ____| |  _  \  
    // | |     | | | | |   \| |   | |   | |_| |  | | | | | |     | |     | |__   | |_| |  
    // | |     | | | | | |\   |   | |   |  _  /  | | | | | |     | |     |  __|  |  _  /  
    // | |___  | |_| | | | \  |   | |   | | \ \  | |_| | | |___  | |___  | |___  | | \ \  
    // \_____| \_____/ |_|  \_|   |_|   |_|  \_\ \_____/ |_____| |_____| |_____| |_|  \_\ 

    .controller('UsuarioController',
        // _____   _   _   __   _   _____       ___   _____  
        // |  ___| | | | | |  \ | | /  ___|     /   | /  _  \ 
        // | |__   | | | | |   \| | | |        / /| | | | | | 
        // |  __|  | | | | | |\   | | |       / / | | | | | | 
        // | |     | |_| | | | \  | | |___   / /  | | | |_| | 
        // |_|     \_____/ |_|  \_| \_____| /_/   |_| \_____/ 
        function ($scope, $routeParams, $filter, cadastroUsuario, recursoUsuario) {
            //_________________________________________________________________________________________________________________________
            /**
             * variáveis criadas quando a tela do controlador é acessada
             */

            /**Esse desgramado aqui estava zerando a variável, vai tomando nota */
            // $scope.usuario = [];
            $scope.mensagem = '';
            //_________________________________________________________________________________________________________________________

            /**
             * Verifica se na URL tem algum ID, se houver é feito a requisição via GET desse ID
             */
            if ($routeParams.usuarioId) {
                recursoUsuario.get({ usuarioId: $routeParams.usuarioId },
                    function (usuario) {
                        $scope.usuario = usuario;
                    },
                    function (erro) {
                        console.log(error);
                        $scope.mensagem =
                            "[ERROR] Não foi encontrar usuario de ID " + $routeParams.usuarioId;
                    });
            };
            //_________________________________________________________________________________________________________________________
            // _____   _   _   __   _   _____       ___   _____  
            // |  ___| | | | | |  \ | | /  ___|     /   | /  _  \ 
            // | |__   | | | | |   \| | | |        / /| | | | | | 
            // |  __|  | | | | | |\   | | |       / / | | | | | | 
            // | |     | |_| | | | \  | | |___   / /  | | | |_| | 
            // |_|     \_____/ |_|  \_| \_____| /_/   |_| \_____/ 
            // _____   _   _   _____       ___  ___   _____   _____   _____   _____   
            // /  ___/ | | | | |  _  \     /   |/   | | ____| |_   _| | ____| |  _  \  
            // | |___  | | | | | |_| |    / /|   /| | | |__     | |   | |__   | |_| |  
            // \___  \ | | | | |  _  {   / / |__/ | | |  __|    | |   |  __|  |  _  /  
            //  ___| | | |_| | | |_| |  / /       | | | |___    | |   | |___  | | \ \  
            // /_____/ \_____/ |_____/ /_/        |_| |_____|   |_|   |_____| |_|  \_\ 


            /**
             * essa função efetua a inserção ou atualização dos dados informados pelo formulario
             */
            $scope.submeter = function () {

                /**Verifica se o formulário é válido */
                if ($scope.formulario.$valid) {
                    cadastroUsuario.cadastrar($scope.usuario)
                        //se der certo a mensagem é atualizada com o sucesso
                        .then(function (dados) {
                            console.log("entrou no then " + dados);
                            $scope.mensagem = dados.mensagem;
                            //se inclusao retornar true, ele limpa o objeto setor
                            if (dados.inclusao) {
                                $scope.usuario = {};
                            }
                            //se der algum erro, o erro é capturado(catch), e atualizado a mensagem com o erro
                        }).catch(function (erro) {
                            $scope.mensagem = erro.mensagem;
                        });
                }/** Fecha o if do formulario valido*/
            }/**Fecha funcao submeter */
        }/**Fecha função principal */
    );/**fecha controller e angular */