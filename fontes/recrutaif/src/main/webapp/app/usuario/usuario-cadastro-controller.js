angular.module('recrutaif').controller('UsuarioCadastroController', function ($scope, $routeParams, cadastroUsuario,recursoUsuario) {

    $scope.usuario = [];
    $scope.mensagem = '';

    $scope.submeter = function () {
        //verifica se o formulario é válido
        $scope.mensagem = 'enttrou na function uhull';

        if ($scope.cadastro.$valid) {
            //tenta cadastrar o setor usando a funcao cadastroDeSetor, passando o setor do scope
            $scope.mensagem = 'enttrou no primeiro if';
            cadastroUsuario.cadastrar($scope.usuario)
                //se der certo a mensagem é atualizada com o sucesso
                .then(function (dados) {
                    console.log("entrou no then " + dados);
                    $scope.mensagem = dados.mensagem;
                    //se inclusao retornar true, ele limpa o objeto setor
                    if (dados.inclusao) {
                        $scope.usaurio = {};
                    }
                    //se der algum erro, o erro é capturado(catch), e atualizado a mensagem com o erro
                }).catch(function (erro) {
                    $scope.mensagem = erro.mensagem;
                });
        }
    };
});