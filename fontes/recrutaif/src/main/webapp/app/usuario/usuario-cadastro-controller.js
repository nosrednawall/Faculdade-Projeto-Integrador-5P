angular.module('recrutaif').controller('UsuarioCadastroController',function($scope,recursoVaga){

    $scope.usuario=[];
    $scope.mensagem = '';
  
        //função adiciona um novo setor e ou atualiza um setor existente
        $scope.submeter = function(){
            //verifica se o formulario é válido
            if($scope.formulario.$valid){
                //tenta cadastrar o setor usando a funcao cadastroDeSetor, passando o setor do scope
                cadastroDeUsuario.cadastrar($scope.usuario)
                //se der certo a mensagem é atualizada com o sucesso
                .then(function(dados){
                    console.log("entrou no then " + dados);
                    $scope.mensagem = dados.mensagem;
                    //se inclusao retornar true, ele limpa o objeto setor
                    if(dados.inclusao){ 
                        $scope.usaurio = {};
                    }
                    //se der algum erro, o erro é capturado(catch), e atualizado a mensagem com o erro
                }).catch(function(erro){
                    $scope.mensagem = erro.mensagem;
                });
            }
        };
});