
angular.module('recrutaif').controller('NewSetorController', function ($scope, $location, locationParser, flash, SetorResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.setor = $scope.setor || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The setor was created successfully.'});
            $location.path('/Setors');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        SetorResource.save($scope.setor, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Setors");
    };
});