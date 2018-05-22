//app.module('calendarioDiretiva'[]).directive('meuCalendario', function () {
//    return {
//        restrict: 'A',
//        require: 'ngModel',
//        link: function (scope, element, attrs, ctrl) {
//            element.datepicker({
//                changeYear: true,
//                changeMonth: true,
//                dateFormat: 'dd/M/yy',
//                onSelect: function (date) {
//                    ctrl.$setViewValue(date);
//                    if (attrs.hasOwnAttribute('futureDate')) {
//                        var dateToCompare = scope.$eval(attrs.futureDate);
//                        if (!dateToCompare) dateToCompare = new Date();
//                        (date > dateToCompare) ? ctrl.$setValidity('future', true) : ctrl.$setValidity('future', false);
//                    }
//                    scope.$apply();
//                }
//            });
//        }
//    };
//});