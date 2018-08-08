angular
    .module('recrutaif')
    .controller('AlterarSenhaController', function ($scope, $routeParams, $rootScope, recursoUsuario, cadastroUsuario) {

        $scope.filtro = ''; //variável responsável pelo filtro de setores, dentro do scope
        $scope.mensagem = '';   //variável responsável pela mensagem de interação com o usuário dentro do scope
        $scope.usuario = [];
                                                                    
        var usuarioCookie = $rootScope.globals.currentUser;

        if (usuarioCookie != null) {
            recursoUsuario.get({ usuarioId: usuarioCookie.id },
                function (usuario) {
                    $scope.usuario = usuario;
                },
                function (erro) {
                    console.log(error);
                    $scope.mensagem =
                        "[ERROR] Não foi encontrar usuario de ID " + $routeParams.usuarioId;
                });
        };

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
    });