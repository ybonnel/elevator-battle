angular.module('BattleApp', ['ui.bootstrap'], function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'partials/main.html?version=1.0.0',
            controller: MainCtrl})
        .when('/battle/:pseudo1/:pseudo2', {
            templateUrl: 'partials/battle.html?version=1.0.0',
            controller: BattleCtrl})
        .otherwise({redirectTo: '/'});
});
