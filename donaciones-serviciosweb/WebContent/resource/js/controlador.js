/**
 * 
 */
 var modulo = angular.module('primerModulo', []);
 
 modulo.controller('primerControlador',['$scope',function($scope){	 
	 $scope.lista =[{texto: 'Prueba1', checked: true},
		 			{texto: 'Prueba2', checked: false}]; 
 
	 $scope.texto = '';
	 $scope.agregar = function(){
		 if($scope.texto == ''){
			 alert('No puede ingresar algo vacio');
			 return;
		 }
		 $scope.lista.push({texto: $scope.texto, checked: false });

		 $scope.texto = '';
	 }
	 
	 $scope.eliminar = function(){
		 var lista = $scope.lista;
		 
		 $scope.lista = {};
		 
		 angular.forEach(lista, function(item){
			 if(item.checked){
				 $scope.lista.push(item);
			 }
		 });
		 
		 
	 }
 
 
 
 }]);