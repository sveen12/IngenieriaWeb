/**
 * 
 */

/**
 * 
 */
 var appcliente = angular.module('clientes', ['ngRoute']);
 
 appcliente.service('clientes', function($http){	 
	 this.listaClientes = function(){
		 return $http({
			 url: 'http://localhost:8080/donaciones-serviciosweb/bbm/usuario/citas/disponibles?fecha=2017-05-01',
			 method: 'GET'
		 });
	 }	 
 });
 
 appcliente.controller('listaClientes', function($scope, clientes){
	 clientes.listaClientes().then(
			 
			 function success(data){
		 $scope.listaClientes = data.data;
		 console.log($scope.listaClientes);
	 });
 });
 
 appcliente.config(['$routeProvider', function($routeProvider){
	 $routeProvider.when('/', {
		 templateUrl : 'listaclientes.html',
		 controller: 'listaClientes'
	 }); 
 }]);