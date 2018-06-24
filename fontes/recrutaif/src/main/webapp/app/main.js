(function () {
    'use strict';
    angular.
    module('recrutaif', [
        'ngAnimate',
        'ngRoute',
        'ngResource',
        'ngCookies',
        'vagaServices',
        'setorServices',
        'usuarioServices',
        '720kb.datepicker',
        'vagaPreenchidaServices'
    ]).config(config).run(run);

    config.$inject = ['$routeProvider', '$locationProvider'];

    function config($routeProvider, $locationProvider, $httpProvider) {


        //     ___   _       _____   _____   _____        ___   _____   
        //     /   | | |     |_   _| | ____| |  _  \      /   | |  _  \  
        //    / /| | | |       | |   | |__   | |_| |     / /| | | |_| |  
        //   / / | | | |       | |   |  __|  |  _  /    / / | | |  _  /  
        //  / /  | | | |___    | |   | |___  | | \ \   / /  | | | | \ \  
        // /_/   |_| |_____|   |_|   |_____| |_|  \_\ /_/   |_| |_|  \_\ 
        // _____   _____   __   _   _   _       ___  
        // /  ___/ | ____| |  \ | | | | | |     /   | 
        // | |___  | |__   |   \| | | |_| |    / /| | 
        // \___  \ |  __|  | |\   | |  _  |   / / | | 
        //  ___| | | |___  | | \  | | | | |  / /  | | 
        // /_____/ |_____| |_|  \_| |_| |_| /_/   |_| 

        $routeProvider.when('/alterar-senha', {
            templateUrl: 'app/alterar-senha/alterar-senha.html',
            controller: 'AlterarSenhaController'
        });


        // _______________________________________________________________________

        // _       _____   _____   _   __   _  
        // | |     /  _  \ /  ___| | | |  \ | | 
        // | |     | | | | | |     | | |   \| | 
        // | |     | | | | | |  _  | | | |\   | 
        // | |___  | |_| | | |_| | | | | | \  | 
        // |_____| \_____/ \_____/ |_| |_|  \_| 


        $routeProvider.when('/login', {
            templateUrl: 'app/login/login.html',
            controller: 'LoginController'
        });

        // __________________________________________________________________________

        // _____    _____   _____   _   _____   _____   _____   _____   
        // |  _  \  | ____| /  ___| | | /  ___/ |_   _| | ____| |  _  \  
        // | |_| |  | |__   | |     | | | |___    | |   | |__   | |_| |  
        // |  _  /  |  __|  | |  _  | | \___  \   | |   |  __|  |  _  /  
        // | | \ \  | |___  | |_| | | |  ___| |   | |   | |___  | | \ \  
        // |_|  \_\ |_____| \_____/ |_| /_____/   |_|   |_____| |_|  \_\ 

        $routeProvider.when('/register', {
            templateUrl: 'app/usuario/usuario.html',
            controller: 'UsuarioController'
        });

        // __________________________________________________________________________

        // _____   _____   _____   _____   _____   
        // /  ___/ | ____| |_   _| /  _  \ |  _  \  
        // | |___  | |__     | |   | | | | | |_| |  
        // \___  \ |  __|    | |   | | | | |  _  /  
        //  ___| | | |___    | |   | |_| | | | \ \  
        // /_____/ |_____|   |_|   \_____/ |_|  \_\ 


        $routeProvider.when('/setores', {
            templateUrl: 'app/setor/setores.html',
            controller: 'SetoresController'
        });

        $routeProvider.when('/setor/new', {
            templateUrl: 'app/setor/setor.html',
            controller: 'SetorController'
        });

        $routeProvider.when('/setor/edit/:setorId', {
            templateUrl: 'app/setor/setor.html',
            controller: 'SetorController'
        });

        // __________________________________________________________________________

        // _   _   _____   _   _       ___   _____    _   _____  
        // | | | | /  ___/ | | | |     /   | |  _  \  | | /  _  \ 
        // | | | | | |___  | | | |    / /| | | |_| |  | | | | | | 
        // | | | | \___  \ | | | |   / / | | |  _  /  | | | | | | 
        // | |_| |  ___| | | |_| |  / /  | | | | \ \  | | | |_| | 
        // \_____/ /_____/ \_____/ /_/   |_| |_|  \_\ |_| \_____/ 

        $routeProvider.when('/usuario/new', {
            templateUrl: 'app/usuario/usuario.html',
            controller: 'UsuarioController'
        });

        $routeProvider.when('/usuario/edit/:usuarioId', {
            templateUrl: 'app/usuario/usuario.html',
            controller: 'UsuarioController'
        });

        $routeProvider.when('/usuarios', {
            templateUrl: 'app/usuario/usuarios.html',
            controller: 'UsuariosController'
        });
        // __________________________________________________________________________

        // _     _       ___   _____       ___  
        // | |   / /     /   | /  ___|     /   | 
        // | |  / /     / /| | | |        / /| | 
        // | | / /     / / | | | |  _    / / | | 
        // | |/ /     / /  | | | |_| |  / /  | | 
        // |___/     /_/   |_| \_____/ /_/   |_| 


        $routeProvider.when('/vagas', {
            templateUrl: 'app/vaga/vagas.html',
            controller: 'VagasController'
        });

        $routeProvider.when('/vaga/new', {
            templateUrl: 'app/vaga/vaga.html',
            controller: 'VagaController'
        });

        $routeProvider.when('/vaga/edit/:vagaId', {
            templateUrl: 'app/vaga/vaga.html',
            controller: 'VagaController'
        });



        // __________________________________________________________________________

        // _     _       ___   _____       ___   _____  
        // | |   / /     /   | /  ___|     /   | /  ___/ 
        // | |  / /     / /| | | |        / /| | | |___  
        // | | / /     / / | | | |  _    / / | | \___  \ 
        // | |/ /     / /  | | | |_| |  / /  | |  ___| | 
        // |___/     /_/   |_| \_____/ /_/   |_| /_____/ 

        // _____   _____    _____   _____   __   _   _____   _   _   _   _____       ___   _____  
        // |  _  \ |  _  \  | ____| | ____| |  \ | | /  ___| | | | | | | |  _  \     /   | /  ___/ 
        // | |_| | | |_| |  | |__   | |__   |   \| | | |     | |_| | | | | | | |    / /| | | |___  
        // |  ___/ |  _  /  |  __|  |  __|  | |\   | | |     |  _  | | | | | | |   / / | | \___  \ 
        // | |     | | \ \  | |___  | |___  | | \  | | |___  | | | | | | | |_| |  / /  | |  ___| | 
        // |_|     |_|  \_\ |_____| |_____| |_|  \_| \_____| |_| |_| |_| |_____/ /_/   |_| /_____/ 

        // $routeProvider.when('/vagas-preenchidas/view/:vagasPreenchidasId', {
        //     templateUrl: 'app/vaga-preenchida/vagas-preenchidas.html',
        //     controller: 'VagasPreenchidasController'
        // });

        $routeProvider.when('/vaga-preenchida/view/:vagaId', {
            templateUrl: 'app/vaga-preenchida/vaga-preenchida.html',
            controller: 'VagaPreenchidaController'
        });

        // __________________________________________________________________________

        // _____       ___   _____   _____        ___   _____  
        // |  _  \     /   | |  _  \ |  _  \      /   | /  _  \ 
        // | |_| |    / /| | | | | | | |_| |     / /| | | | | | 
        // |  ___/   / / | | | | | | |  _  /    / / | | | | | | 
        // | |      / /  | | | |_| | | | \ \   / /  | | | |_| | 
        // |_|     /_/   |_| |_____/ |_|  \_\ /_/   |_| \_____/ 


        $routeProvider.when('/principal', {
            templateUrl: 'app/principal/principal.html',
        });
        $routeProvider.otherwise({
            redirectTo: '/setores'
        });
    } //criado módulo chamado recrutaif que não tem nenhuma dependencia ainda, não depende de outros módulos




    run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];

    function run($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        // if ($rootScope.globals.currentUser) {
        //     $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
        // }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
            var restrictedPage = $.inArray($location.path(), ['/login', '/register']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }

})();