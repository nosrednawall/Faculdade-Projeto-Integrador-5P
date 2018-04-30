angular.module('appServices', ['ngResource'])
//módulo que configura o caminho para acessar os recursos rest da aplicação TODA

//cria uma fabrica de recursos
.factory('recursoSetor',function($resource){

    //retorna um recurso
    return $resource('rest/setores/:setorId', null,{
        update :{
            method: 'PUT'
        }
    });

});