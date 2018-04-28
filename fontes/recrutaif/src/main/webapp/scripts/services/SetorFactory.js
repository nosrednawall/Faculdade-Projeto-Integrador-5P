angular.module('recrutaif').factory('SetorResource', function($resource){
    var resource = $resource('rest/setores/:SetorId',{SetorId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});