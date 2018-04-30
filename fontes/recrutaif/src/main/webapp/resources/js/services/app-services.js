//módulo que configura o caminho para acessar os recursos rest da aplicação TODA

angular.module('appServices', ['ngResource'])
//cria uma fabrica de recursos
.factory('resursoSetor',function($resource){

    //retorna um recurso
    return $resource('rest/setores/:setorId', null,{
        update :{
            method: 'PUT'
        }
    });

});