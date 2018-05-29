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
    .factory('cadastroUsuario', function(recursoUsuario, $q){
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

                    recursoUsuario.save(usuario, function(){
                        resolve({
                            mensagem : '[INFO]usuario ' + usuario.nome + ' Adicionado com sucesso!',
                            inclusao : true
                        });
                    },function(erro){
                        console.log(erro);
                        reject({
                            mensagem :'[ERRO] Não foi possível incluir o usuario '+ usuario.nome
                        });
                    });
                }
            });
        };
        return servico;
});