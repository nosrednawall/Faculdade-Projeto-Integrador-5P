angular.module('recrutaif').controller('SetorController',function($scope,$http){
    
    // $scope.fotos = [
    //     {
    //         titulo : 'Leão',
    //         url : 'http://i.huffpost.com/gen/2841234/thumbs/o-LION-900.jpg?7'
    //     },
    //     {
    //         titulo : 'Leão 2',
    //         url : 'http://i.huffpost.com/gen/2841234/thumbs/o-LION-900.jpg?7'
    //     },
    //     {
    //         titulo : 'Leão 3',
    //         url : 'http://i.huffpost.com/gen/2841234/thumbs/o-LION-900.jpg?7'
    //     }
    // ];

    $scope.setores = [];

    var promise= $http.get('rest/setores/');

    promise.then(function(retorno){
        $scope.setores = retorno.data;
    }).catch(function(error){
        console.log("error");
    });
});