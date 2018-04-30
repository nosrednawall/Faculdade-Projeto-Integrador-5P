angular.module('appServices', ['ngResource'])
.factory('resursoSetor',function($resource){

    return $resource('rest/setores/:setorId', null,{
        update :{
            method: 'PUT'
        }
    });

});