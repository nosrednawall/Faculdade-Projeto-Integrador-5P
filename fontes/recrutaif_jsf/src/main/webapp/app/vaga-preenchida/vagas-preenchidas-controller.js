// angular
//     .module('recrutaif')
//     .controller('VagaController', function ($scope, $routeParams, $rootScope, $http, recursoVaga, cadastroDeVagaPreenchida, cadastroDeVaga, recursoSetor) {

//         //variáveis de interação com o scope
//         $scope.vagas = []; //variável responsável pelo loop de setor dentro do scope
//         $scope.filtro = ''; //variável responsável pelo filtro de setores, dentro do scope
//         $scope.mensagem = ''; //variável responsável pela mensagem de interação com o usuário dentro do scope


//         $http.query('rest/vagaspreenchidas', { vagaId: vagaPreenchida.vaga, candidatoId: vagaPreenchida.candidato })
//         .then(function () {

//             mensagem: '[INFO] Candidatura efetuada com sucesso com sucesso!'

//         }, function (erro) {
//             mensagem: '[ERRO] Não foi possível efetuar acandidatura'
//         }
//         );


//     });