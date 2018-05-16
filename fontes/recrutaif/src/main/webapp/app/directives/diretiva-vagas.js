angular.module('diretivasVaga',[]).directive('tableVaga',function(){

    //direct definition object
    //é a diretiva configurada
    var ddo={};

    //Atribut Element
    ddo.restrict = "AE";

    //torno o scope dessa diretiva privado
    //é como que se fosse um construtor para getter and setter, só que não
    ddo.scope = {
        titulo : '@' 
    };

    ddo.transclude = true;
    ddo.templateUrl = 'resources/js/directives/lista-vagas.html';

    return ddo;
});