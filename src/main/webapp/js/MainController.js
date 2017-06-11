app.controller('MainController', ['$scope', '$http', '$window', function($scope,  $http, $window) {

  $scope.submitForm = function() {

      if ($scope.firstName === " " || $scope.lastName === " " || $scope.username === " " || $scope.password === " ") {
        alert("Please fill all fields!")
      }
      else if ($scope.dateOfBirth > new Date()) {
        alert("Whooa, are you from the future? Didn't think so, please select correct date");
      }
      else {
      $http.post('createRegistration',
        {
                "firstName": $scope.firstName,
                "lastName": $scope.lastName,
                "dateOfBirth": $scope.dateOfBirth,
                "username": $scope.username,
                "password": $scope.password
        }).then(function (response) {
            $scope.firstName = "";
            $scope.lastName = "";
            $scope.dateOfBirth ="";
            $scope.username ="";
            $scope.password ="";
            $scope.inputType = 'text'
      })}
      $scope.getRegistrations();

  };

  $scope.allRegistrations = {};

  $scope.getRegistrations = function() {
     setTimeout(function(){
        $scope.$apply(function() {
             $http.get('registrations')
                .success(function(data) {
                    console.log(data)
                    $scope.allRegistrations = data;

                })
                .error(function(data) {

                });
        })
     }, 1000)
  };

  $scope.getRegistrations();

  $scope.timeConverter = function(unixTimestamp){
    var d = new Date(unixTimestamp);
    return d.getDate() + '.' + (d.getMonth()+1) + '.' + d.getFullYear();

  };
   $scope.removeRegistration = function(element) {
       $scope.registrationId = element.currentTarget.value;
       console.log($scope.registrationId)
       $http.post('delete',
                   {
                   "id": $scope.registrationId
                   })
                   $scope.getRegistrations();
   };

   $scope.id;
   $scope.updateRegistration = function() {
         $scope.registrationId = $scope.id;
         //console.log($scope.registrationId)
         $http.post('update',
                    {
                       "id": $scope.registrationId,
                       "firstName": $scope.newFirstName,
                       "lastName": $scope.newLastName,
                       "dateOfBirth": $scope.newDateOfBirth,
                       "username": $scope.newUsername,
                       "password": $scope.newPassword
                    });
    };

  $scope.open = function(element) {
    $scope.showModal = true;
    $scope.id = element.currentTarget.value;
    $scope.newFirstName = document.getElementById($scope.id + "FN").innerHTML;
    $scope.newLastName = document.getElementById($scope.id + "LN").innerHTML;
    $scope.newUsername = document.getElementById($scope.id + "UN").innerHTML;
    $scope.newPassword = document.getElementById($scope.id + "PW").innerHTML;
    //console.log($scope.id)


  };
  $scope.ok = function() {
    $scope.updateRegistration();
    $scope.getRegistrations();
    $scope.showModal = false;
  };

  $scope.cancel = function() {
    $scope.showModal = false;
  };

}]);