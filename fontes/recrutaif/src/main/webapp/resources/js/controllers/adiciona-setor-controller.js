//módulo para criar e editar setor

angular.module('recrutaif').controller('AdicionaSetorController',function($scope, recursoSetor, $routeParams){
    $scope.setor = {};
    $scope.mensagem = '';
    
    if($routeParams.setorId){
        console.log($routeParams.setorId);
        $http.get('rest/setores/' + $routeParams.setorId)
        .success(function(setor){
            $scope.setor = setor;
        })
        .error(function(error){
            console.log(error);
            $scope.mensagem = "[ERROR] Não foi encontrar setor de ID " + $routeParams.setorId;
        });
    };

    $scope.submeter = function(){
        if($scope.formulario.$valid){
            if($scope.setor.id){

                recursoSetor.update({setorId : $scope.setor.id}, $scope.setor, function(){
                 
                    console.log("[INFO]Setor "+ $scope.setor.nome +" foi atualizado com sucesso!");
                    $scope.mensagem = "[INFO]Setor "+ $scope.setor.nome +" foi atualizado com sucesso!";
                    $scope.setor = '';

                }, function(erro){

                    console.log("[ERROR] Não foi possível atualizar o setor");
                    $scope.mensagem = "[ERROR] Não foi possível atualizar o setor";

                });
            }else{
                $http.post('rest/setores/', $scope.setor)
                .success(function(){
                    console.log("[INFO]Setor "+ $scope.setor.nome +" Adicionado com sucesso!");
                    $scope.mensagem = "[INFO]Setor "+ $scope.setor.nome +" Adicionado com sucesso!";

                    $scope.setor = '';
                })
                .error(function(){
                    console.log("[ERROR] Não foi possível incluir setor");
                    $scope.mensagem = "[ERROR] Não foi possível incluir setor";
                    
                });
            }
        }
    };
});