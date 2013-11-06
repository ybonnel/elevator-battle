function BattleCtrl($scope, $http, $timeout, $routeParams) {
    $scope.pseudo1 = $routeParams.pseudo1;
    $scope.pseudo2 = $routeParams.pseudo2;
    $scope.players = [];

    function fetchLeaderboard($scope, $http, $timeout) {
        (function fetch() {
            $http.get('/battle/' + $scope.pseudo1 + '/' + $scope.pseudo2)
                .success(function (data) {
                    $scope.players = data;
                });
            $scope.nextFetchLeaderboard = $timeout(fetch, 1000);
        })();
    }

    fetchLeaderboard($scope, $http, $timeout);

    $scope.$on("$destroy", function () {
        $timeout.cancel($scope.nextFetchLeaderboard);
    });

}

function MainCtrl($scope, $http, $location) {

    $http.get('/pseudos')
        .success(function(data) {
            $scope.pseudos = data;
        });

    $scope.submitPlayers = function (pseudo1, pseudo2) {

        if ($scope.form.$invalid) {
            $scope.form.pseudo1.$dirty = true;
            $scope.form.pseudo2.$dirty = true;
        } else {
            $location.path('/battle/' + pseudo1 + '/' + pseudo2);
        }
    };

    $scope.submitPlayer = function(pseudo) {
        if ($scope.playerForm.$invalid) {
            $scope.playerForm.onepseudo.$dirty = true;
        } else {
            $location.path('/battle/' + pseudo + '/noone');
        }

    }
}