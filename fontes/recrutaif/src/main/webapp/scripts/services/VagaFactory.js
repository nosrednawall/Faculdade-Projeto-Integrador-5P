angular.module('recrutaif').factory('VagaResource', function($resource){
    var resource = $resource('rest/vagas/:VagaId',{VagaId:'@id'},{'queryAll':{method:'GET',isArray:true},'query':{method:'GET',isArray:false},'update':{method:'PUT'}});
    return resource;
});