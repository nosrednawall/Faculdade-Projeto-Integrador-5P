angular.
    module
        ('recrutaif', [
            'ngAnimate', 
            'ngRoute', 
            'ngResource',
            'minhasDiretivas', 
            'vagaServices', 
            'setorServices',
            'usuarioServices'
        ])
    //angular = variável global do angular; .module = cria um módulo; [módulos em que a main é dependente]

    //função para rotas, ex quero ver uma lista de setores, vou em /recrutaif/#/setores
    .config(function ($routeProvider, $locationProvider, $httpProvider) {


        // | |\| ¯|¯ |¯ |¯| |¯ |¯ |¯| ¯|¯ /¯\ |¯\ |¯| |¯| 
        // | | |  |  |¯ |¯\ |_ |¯ |¯   |  |¯| |_/ |_| |¯\ 
        //            ¯         ¯                         
        // $httpProvider.interceptors.push('tokenInterceptor');

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
            templateUrl: 'app/vaga/criavaga.html',
            controller: 'CriaVagaController'
        });

        $routeProvider.when('/vaga/edit/:vagaId', {
            templateUrl: 'app/vaga/criavaga.html',
            controller: 'CriaVagaController'
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
        $routeProvider.otherwise({ redirectTo: '/principal' });
    }); //criado módulo chamado recrutaif que não tem nenhuma dependencia ainda, não depende de outros módulos
