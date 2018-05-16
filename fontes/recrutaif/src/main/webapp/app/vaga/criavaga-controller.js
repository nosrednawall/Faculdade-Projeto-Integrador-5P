angular.module('recrutaif').controller('CriaVagaController',function($scope, recursoVaga, $routeParams, cadastroDeVaga){
   
    //variáveis para interação com o scopo
     $scope.vaga = {};
     $scope.mensagem = '';
     
     //get ou busca setor
     if($routeParams.vagaId){
         //faz uma requisição get, passando o numero do parametro da url para o coringa, 
         recursoVaga.get({vagaId: $routeParams.vagaId},
             //caso dê certo o que retornar será passado para setor
             function(vaga){
             $scope.vaga = vaga;
         },
         //caso dê errado será passado mensagem de erro ao usuario
         function(erro){
             console.log(error);
             $scope.mensagem = "[ERROR] Não foi encontrar setor de ID " + $routeParams.vagaId;
         });
     };
 
     //função adiciona um novo setor e ou atualiza um setor existente
     $scope.submeter = function(){
         //verifica se o formulario é válido
         if($scope.formulario.$valid){
             //tenta cadastrar o setor usando a funcao cadastroDeSetor, passando o setor do scope
             cadastroDeVaga.cadastrar($scope.vaga)
             //se der certo a mensagem é atualizada com o sucesso
             .then(function(dados){
                 console.log("entrou no then " + dados);
                 $scope.mensagem = dados.mensagem;
                 //se inclusao retornar true, ele limpa o objeto setor
                 if(dados.inclusao){ 
                     $scope.vaga = {};
                     // $scope.focado = true;
                 }
                 //se der algum erro, o erro é capturado(catch), e atualizado a mensagem com o erro
             }).catch(function(erro){
                 $scope.mensagem = erro.mensagem;
             });
         }
     };
 });
