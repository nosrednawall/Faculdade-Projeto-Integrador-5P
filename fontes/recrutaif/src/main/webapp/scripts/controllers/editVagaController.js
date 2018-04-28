

angular.module('recrutaif').controller('EditVagaController', function($scope, $routeParams, $location, flash, VagaResource , SetorResource) {
    var self = this;
    $scope.disabled = false;
    $scope.$location = $location;
    
    $scope.get = function() {
        var successCallback = function(data){
            self.original = data;
            $scope.vaga = new VagaResource(self.original);
            SetorResource.queryAll(function(items) {
                $scope.setoresSelectionList = $.map(items, function(item) {
                    var wrappedObject = {
                        id : item.id
                    };
                    var labelObject = {
                        value : item.id,
                        text : item.id
                    };
                    if($scope.vaga.setores){
                        $.each($scope.vaga.setores, function(idx, element) {
                            if(item.id == element.id) {
                                $scope.setoresSelection.push(labelObject);
                                $scope.vaga.setores.push(wrappedObject);
                            }
                        });
                        self.original.setores = $scope.vaga.setores;
                    }
                    return labelObject;
                });
            });
        };
        var errorCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The vaga could not be found.'});
            $location.path("/Vagas");
        };
        VagaResource.get({VagaId:$routeParams.VagaId}, successCallback, errorCallback);
    };

    $scope.isClean = function() {
        return angular.equals(self.original, $scope.vaga);
    };

    $scope.save = function() {
        var successCallback = function(){
            flash.setMessage({'type':'success','text':'The vaga was updated successfully.'}, true);
            $scope.get();
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        $scope.vaga.$update(successCallback, errorCallback);
    };

    $scope.cancel = function() {
        $location.path("/Vagas");
    };

    $scope.remove = function() {
        var successCallback = function() {
            flash.setMessage({'type': 'error', 'text': 'The vaga was deleted.'});
            $location.path("/Vagas");
        };
        var errorCallback = function(response) {
            if(response && response.data && response.data.message) {
                flash.setMessage({'type': 'error', 'text': response.data.message}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        }; 
        $scope.vaga.$remove(successCallback, errorCallback);
    };
    
    $scope.setoresSelection = $scope.setoresSelection || [];
    $scope.$watch("setoresSelection", function(selection) {
        if (typeof selection != 'undefined' && $scope.vaga) {
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
    
    $scope.get();
});