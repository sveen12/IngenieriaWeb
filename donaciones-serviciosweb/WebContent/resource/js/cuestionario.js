var cuestionario = angular.module('moduloCuestionario', []);

cuestionario.controller('controladorCuestionario', function($scope){

	$scope.estadoUsuario = '';
	$scope.respuestasCorrectas = 0;
	$scope.preguntasRespondidas = 0;

	$scope.preguntas = [
		{
			id: 1,
			texto: 'Pregunta 1',
			respuestaValida: 1,
			estado: '',
			respuestaSeleccionada: null,
			respuestas: [{
							id: 1, 
							texto: 'Respuesta 1.1'
						},
						{
							id: 2, 
							texto: 'Respuesta 1.2'
						},
						{
							id: 3, 
							texto: 'Respuesta 1.3'
						}],
		},
		{
			id: 2,
			texto: 'Pregunta 2',
			respuestaValida: 2,
			estado: '',
			respuestaSeleccionada: null,
			respuestas: [{
							id: 1, 
							texto: 'Respuesta 2.1'
						},
						{
							id: 2, 
							texto: 'Respuesta 2.2'
						},
						{
							id: 3, 
							texto: 'Respuesta 2.3'
						}],
		},		
		{
			id: 3,
			texto: 'Pregunta 3',
			respuestaValida: 3,
			estado: '',
			respuestaSeleccionada: null,
			respuestas: [{
							id: 1, 
							texto: 'Respuesta 3.1'
						},
						{
							id: 2, 
							texto: 'Respuesta 3.2'
						},
						{
							id: 3, 
							texto: 'Respuesta 3.3'
						}],
		},
	];

	$scope.validar =  function(pregunta){

		angular.forEach($scope.preguntas, function(pregunta) {
		  // aquí pones todo el código que quieras para esta única materia.
		  //console.log(pregunta.respuestaSeleccionada);
		  if(pregunta.respuestaSeleccionada!=null){
		  		$scope.preguntasRespondidas++;
		  }
		}); 
		if($scope.preguntasRespondidas < $scope.preguntas.length ){

			console.log($scope.preguntasRespondidas);
			alert("Debe responder todas las preguntas");
			return;
		}
		console.log($scope.preguntasRespondidas);
			// if((pregunta.respuestaSeleccionada == pregunta.respuestaValida) && 
			// 	($scope.respuestasCorrectas < $scope.preguntas.length) ){
			// 	//alert("Correcto");
			// 	$scope.respuestasCorrectas++;
			// 	pregunta.estado = 'ok';
			// }
			// else
			// {
			// 	//alert("Incorrecto");
			// 	if(pregunta.estado == 'ok' && $scope.respuestasCorrectas>0)
			// 	{
			// 		$scope.respuestasCorrectas--;	
			// 		pregunta.estado = 'error';				
			// 	}
				
			// }
			estadoUsuario();
	};


	function estadoUsuario(){
		var total = $scope.respuestasCorrectas/$scope.preguntas.length;

		if(total == 0){
			$scope.estadoUsuario = 'looser';
		}else if(total == 1){
			$scope.estadoUsuario = 'guru';
		}else{
			$scope.estadoUsuario = 'poor';
		}
	}

	$scope.sumarRespuesta = function(){
		if($scope.preguntasRespondidas < $scope.preguntas.length ){
			$scope.preguntasRespondidas++;
		}
	}

});