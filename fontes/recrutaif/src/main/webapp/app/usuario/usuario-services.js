angular.module('usuarioServices', ['ngResource'])
//módulo que configura o caminho para acessar os recursos rest da aplicação TODA


    //cria uma fabrica de recursos
    .factory('recursoUsuario',function($resource){
        console.log("Entrou no usuario services em recurso usuario");

        //retorna um recurso
        return $resource('rest/usuarios/:usuarioId', null,{
            update :{
                method: 'PUT'
            }
        });
    })
    
    //o $q serve para trabalhar com as promessas
    .factory('cadastroUsuario', function(recursoUsuario, $q, $http){
        console.log("Entrou no usuario services em cadastro usuario");

        var servico = {};
        
        servico.cadastrar = function(usuario){
            //retornando promessa na mão
            return $q(function(resolve, reject){

                //verifica se o setor informado possui id
                if(usuario.id){


                    recursoUsuario.update({usuarioId : usuario.id}, usuario, function(){
                        resolve({
                            mensagem : '[INFO] usuario ' + usuario.nome + ' atualizado com sucesso!',
                            inclusao : false
                        });
                    }, function(erro){
                        console.log(erro);
                        reject({
                        mensagem : '[ERRO] Não foi possível alterar o usuario '+usuario.nome
                        });
                    });

                }else{
                    $http.post('rest/usuarios', { 
                        email: usuario.email,
                        senha: usuario.senha,
                        nome: usuario.nome,
                        dataAdmissao: usuario.dataAdmissao,
                        matricula: usuario.matricula,
                        permissao: usuario.permissao,
                        status: usuario.status
                    })
                    .then(function () {
                        $scope.mensagem = 'Usuário '+usuario.nome+' cadastrado com sucesso!';
    
                    }, function (erro) {
                        console.log('Esse é o erro de login ' + erro);
                        console.log('Entrou em deu errado')
    
                        $scope.usuario = {};
                        $scope.mensagem = 'Login ou senha inválidos!';
                    }
                );
                }
            });
        };
        return servico;
});