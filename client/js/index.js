var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http, $rootScope) {
    $rootScope.serverAddr = "http://localhost:5000";

    $scope.tableType = "";

    $scope.getAllToan = function () {
        $scope.tableType="toan";
        $scope.showToan = true;
        $scope.tableName = "Danh Sách Toán";
        $http.get($rootScope.serverAddr + "/api/toan")
            .then(function (respone) {
                $scope.toanList = respone.data;
            });
    }

    $scope.getAllKhoi = function () {
        $scope.tableType="khoi";
        $scope.showKhoi = true;
        $scope.tableName = "Danh Sách Khối";
        $http.get($rootScope.serverAddr + "/api/khoi")
            .then(function (respone) {
                $scope.khoiList = respone.data;
            });
    }

    $scope.getToanDetails = function (toanId) {
        $scope.tableType="toanDetail";
        $http.get($rootScope.serverAddr + "/api/toan/" + toanId)
            .then(function (respone) {
                $scope.toanInfo = respone.data;
                $scope.tableName=respone.data.ten;
            });
        $http.get($rootScope.serverAddr + "/api/toan/" + toanId + "/htdts")
            .then(function (respone) {
                $scope.toanHtdtList = respone.data.content;
            });
    }
});