angular
    .module('recrutaif')
    .controller('UsuarioController',
        function ($scope, $routeParams, cadastroUsuario, recursoUsuario) {

            $scope.usuario = [];
            $scope.mensagem = '';

            //get ou busca setor
            if ($routeParams.usuarioId) {
                //faz uma requisição get, passando o numero do parametro da url para o coringa, 
                recursoUsuario.get({ usuarioId: $routeParams.usuarioId },
                    //caso dê certo o que retornar será passado para setor
                    function (usuario) {
                        $scope.usuario = usuario;
                    },
                    //caso dê errado será passado mensagem de erro ao usuario
                    function (erro) {
                        console.log(error);
                        $scope.mensagem =
                            "[ERROR] Não foi encontrar usuario de ID " + $routeParams.usuarioId;
                    });
            };

            $scope.submeter = function () {
                //verifica se o formulario é válido
                console.log("e o usuário é " + $scope.usuario);

                console.log($scope.usuario);

                // if ($scope.formulario.$valid) {
                //     //tenta cadastrar o setor usando a funcao cadastroDeSetor, passando o setor do scope
                //     $scope.mensagem = 'entrou no primeiro if';
                //     console.log($scope.usuario);
                //     cadastroUsuario.cadastrar($scope.usuario)
                //         //se der certo a mensagem é atualizada com o sucesso
                //         .then(function (dados) {
                //             console.log("entrou no then " + dados);
                //             $scope.mensagem = dados.mensagem;
                //             //se inclusao retornar true, ele limpa o objeto setor
                //             if (dados.inclusao) {
                //                 $scope.usuario = {};
                //             }
                //             //se der algum erro, o erro é capturado(catch), e atualizado a mensagem com o erro
                //         }).catch(function (erro) {
                //             $scope.mensagem = erro.mensagem;
                //         });
                // }
                console.log($scope.usuario.dataAdmissao);

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
            }
        });