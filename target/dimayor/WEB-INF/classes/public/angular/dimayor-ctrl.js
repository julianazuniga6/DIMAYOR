angular.module('dimayor', []).controller('dimayor-ctrl', function($scope, $http) {

    $http({
        method : "GET",
        url : "/api/v1/teams"
    }).then(function mySuccess(response) {
        console.log('RESPONSE ', response);
        $scope.teams = response.data;
    }, function myError(response) {
        $scope.teams = response.statusText;
    });

    $scope.addTeam= function() {
      var data = {name:$scope.name, year:$scope.year, titles: $scope.titles};
      body= JSON.stringify(data);
      $http({
          method : "POST",
          url : "/api/v1/teams",
          data : body
      });

      $scope.name="";
      $scope.year="";
      $scope.titles="";
      $scope.teams.push(data);
    }

});
