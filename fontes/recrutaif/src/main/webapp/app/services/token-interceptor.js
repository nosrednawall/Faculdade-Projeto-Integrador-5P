(function () {
    'use strict';
angular.module('recrutaif')     //faz parte do módulo recrutaif
    .factory('tokenInterceptor', function ($q, $window, $location, $cookies) {     //o factory é quem cria o servico
        //$window 

        //é o objeto configurado que será retornado no final
        var interceptor = {};

        //         //funcão responsável por colocar o token recebido em cada requisicao ao servidor
        //         //o config é o proprio token
        //         // interceptor.request = function(config) {

        //         //     // ele vai receber ele mesmo, caso não exista vai receber um objeto em branco
        //         //     config.headers = config.headers || {};

        //         //     //Se o token guardado existe           
        //         //     if ($window.sessionStorage.token) {

        //         //         //se existir ele é colocado no header   
        //         //         console.log(token);
        //         //         console.log('Enviando token já obtido em cada requisição');
        //         //         config.headers['Bearer'] = $window.sessionStorage.token;
        //         //     }
        //         //     return config;
        //         // },

        //essa chamada response é chamada toda vez que o servidor manda algo para a aplicacao
        interceptor.response = function (response) {
            //var token recebida via header
            // var token = response.headers('Bearer');



            console.log(token);

            //verificar se o token não é null
            if (token != null) {
                //se não for é adicionado o token na sessão da aba do navegador, fechou a aba perdeu o token
                $window.sessionStorage.token = token;
                console.log('Token no session storage: ', token);
            }
            return response;
        },

            //funcão responsável por redirecionar o usuário a tela de login, quando houver erro
            interceptor.responseError = function (rejection) {
                //verifica se há rejeição ou código 401
                if (rejection != null && rejection.status === 401) {
                    //se sim remove o token e mandar para tela de autenticação
                    console.log('Removendo token da sessão')
                    delete $window.sessionStorage.token;
                    $location.path("/login");
                }
                //retorna a promessa
                return $q.reject(rejection);
            }

        //objeto retornado
        return interceptor;

    });
})();