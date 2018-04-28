
angular.module('recrutaif').controller('NewUsuarioController', function ($scope, $location, locationParser, flash, UsuarioResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.usuario = $scope.usuario || {};
    
    $scope.permissaoList = [
        "RECRUTADOR",
        "CANDIDATO"
    ];
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The usuario was created successfully.'});
            $location.path('/Usuarios');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        UsuarioResource.save($scope.usuario, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Usuarios");
    };
});