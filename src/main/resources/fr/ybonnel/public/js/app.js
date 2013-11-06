angular.module('BattleApp', ['ui.bootstrap'], function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'partials/main.html',
            controller: MainCtrl})
        .when('/battle/:pseudo1/:pseudo2', {
            templateUrl: 'partials/battle.html',
            controller: BattleCtrl})
        .otherwise({redirectTo: '/'});
});
