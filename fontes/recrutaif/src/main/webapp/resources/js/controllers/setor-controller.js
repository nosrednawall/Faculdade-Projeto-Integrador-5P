angular.module('recrutaif').controller('SetorController',function($scope, recursoSetor, $routeParams, cadastroDeSetor){
   
   //variáveis para interação com o scopo
    $scope.setor = {};
    $scope.mensagem = '';
    
    //get ou busca setor
    if($routeParams.setorId){
        //faz uma requisição get, passando o numero do parametro da url para o coringa, 
        recursoSetor.get({setorId: $routeParams.setorId},
            //caso dê certo o que retornar será passado para setor
            function(setor){
            $scope.setor = setor;
        },
        //caso dê errado será passado mensagem de erro ao usuario
        function(erro){
            console.log(error);
            $scope.mensagem = "[ERROR] Não foi encontrar setor de ID " + $routeParams.setorId;
        });
    };

    //função adiciona um novo setor e ou atualiza um setor existente
    $scope.submeter = function(){
        //verifica se o formulario é válido
        if($scope.formulario.$valid){
            //tenta cadastrar o setor usando a funcao cadastroDeSetor, passando o setor do scope
            cadastroDeSetor.cadastrar($scope.setor)
            //se der certo a mensagem é atualizada com o sucesso
            .then(function(dados){
                console.log("entrou no then " + dados);
                $scope.mensagem = dados.mensagem;
                //se inclusao retornar true, ele limpa o objeto setor
                if(dados.inclusao) $scope.setor = {};

                //se der algum erro, o erro é capturado(catch), e atualizado a mensagem com o erro
            }).catch(function(erro){
                $scope.mensagem = erro.mensagem;
            });
        }
    };
});

// antes de refatorar denovo :(
    // //função adiciona um novo setor e ou atualiza um setor existente
    // $scope.submeter = function(){
    //     //só será acessado seo scopo de formulario for válido
    //     if($scope.formulario.$valid){
    //         //verifica se o setor passado possui ID, se sim atualiza
    //         if($scope.setor.id){
    //             //tenta atuzalizar, caso dê certo informa ao usuário
    //             recursoSetor.update({setorId : $scope.setor.id}, $scope.setor, function(){
                 
    //                 console.log("[INFO]Setor "+ $scope.setor.nome +" foi atualizado com sucesso!");
    //                 $scope.mensagem = "[INFO]Setor "+ $scope.setor.nome +" foi atualizado com sucesso!";
    //                 $scope.setor = '';

    //                 //caso dê erro informa ao usuário
    //             }, function(erro){

    //                 console.log("[ERROR] Não foi possível atualizar o setor");
    //                 $scope.mensagem = "[ERROR] Não foi possível atualizar o setor";

    //             });
    //         }else{
    //             //se não insere
    //             recursoSetor.save($scope.setor,function(){
    //                 console.log("[INFO]Setor "+ $scope.setor.nome +" Adicionado com sucesso!");
    //                 $scope.mensagem = "[INFO]Setor "+ $scope.setor.nome +" Adicionado com sucesso!";

    //                 //para apagar os campos do html, é informado um objeto vazio
    //                 $scope.setor = '';
    //             }, function(erro){
    //                 console.log("[ERROR] Não foi possível incluir setor");
    //                 $scope.mensagem = "[ERROR] Não foi possível incluir setor";
                    
    //             });
    //         }
    //     }
    // };








//antes de refatorar

// angular.module('recrutaif').controller('AdicionaSetorController',function($scope, recursoSetor, $routeParams){
//     $scope.setor = {};
//     $scope.mensagem = '';
    
//     if($routeParams.setorId){
//         $http.get('rest/setores/' + $routeParams.setorId)
//         .success(function(setor){
//             $scope.setor = setor;
//         })
//         .error(function(error){
//             console.log(error);
//             $scope.mensagem = "[ERROR] Não foi encontrar setor de ID " + $routeParams.setorId;
//         });
//     };

//     $scope.submeter = function(){
//         if($scope.formulario.$valid){
//             if($scope.setor.id){

//                 recursoSetor.update({setorId : $scope.setor.id}, $scope.setor, function(){
                 
//                     console.log("[INFO]Setor "+ $scope.setor.nome +" foi atualizado com sucesso!");
//                     $scope.mensagem = "[INFO]Setor "+ $scope.setor.nome +" foi atualizado com sucesso!";
//                     $scope.setor = '';

//                 }, function(erro){

//                     console.log("[ERROR] Não foi possível atualizar o setor");
//                     $scope.mensagem = "[ERROR] Não foi possível atualizar o setor";

//                 });
//             }else{
//                 $http.post('rest/setores/', $scope.setor)
//                 .success(function(){
//                     console.log("[INFO]Setor "+ $scope.setor.nome +" Adicionado com sucesso!");
//                     $scope.mensagem = "[INFO]Setor "+ $scope.setor.nome +" Adicionado com sucesso!";

//                     $scope.setor = '';
//                 })
//                 .error(function(){
//                     console.log("[ERROR] Não foi possível incluir setor");
//                     $scope.mensagem = "[ERROR] Não foi possível incluir setor";
                    
//                 });
//             }
//         }
//     };
// });


