angular.module('recrutaif')
	.controller('GruposController', function($scope, $http) {
		$http.get('rest/grupos')
			.success(function(grupos) {
			$scope.grupos = grupos;
		})
		.error(function(erro) {
			console.log(erro);
		});
	});
