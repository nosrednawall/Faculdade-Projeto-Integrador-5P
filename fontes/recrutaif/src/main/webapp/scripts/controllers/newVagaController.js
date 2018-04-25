
angular.module('recrutaif').controller('NewVagaController', function ($scope, $location, locationParser, flash, VagaResource , SetorResource) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.vaga = $scope.vaga || {};
    
    $scope.setoresList = SetorResource.queryAll(function(items){
        $scope.setoresSelectionList = $.map(items, function(item) {
            return ( {
                value : item.id,
                text : item.id
            });
        });
    });
    $scope.$watch("setoresSelection", function(selection) {
        if (typeof selection != 'undefined') {
            $scope.vaga.setores = [];
            $.each(selection, function(idx,selectedItem) {
                var collectionItem = {};
                collectionItem.id = selectedItem.value;
                $scope.vaga.setores.push(collectionItem);
            });
        }
    });

    $scope.statusList = [
        "ATIVA",
        "INATIVA"
    ];
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The vaga was created successfully.'});
            $location.path('/Vagas');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        VagaResource.save($scope.vaga, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Vagas");
    };
});