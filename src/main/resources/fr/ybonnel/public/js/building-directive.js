angular.module('BattleApp').directive('building', function () {
    return {
        restrict: 'E',
        scope: {
            player: '='
        },
        templateUrl: 'partials/building.html'
    };
});