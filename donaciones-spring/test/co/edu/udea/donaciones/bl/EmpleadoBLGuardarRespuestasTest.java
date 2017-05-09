package co.edu.udea.donaciones.bl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.bl.EmpleadoBL;
import co.edu.udea.donaciones.dto.CitaDTO;
import co.edu.udea.donaciones.dto.DonanteDTO;
import co.edu.udea.donaciones.dto.EmpleadoDTO;
import co.edu.udea.donaciones.dto.PreguntaDTO;
import co.edu.udea.donaciones.dto.RespuestaDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class EmpleadoBLGuardarRespuestasTest {
	@Autowired
	EmpleadoBL empleadoBL;
	
	@Test
	public void testGuardarRespuestas() {
		try{
			DonanteDTO donanteDTO = new DonanteDTO();
			donanteDTO.setDocumento("142121212");
			donanteDTO.setDireccion("Calle 23");
			donanteDTO.setEdad("18");
			donanteDTO.setEstadoCivil("Soltero");
			donanteDTO.setEstadoSalud("Normal");
			donanteDTO.setNombres("Juan");
			donanteDTO.setApellidos("Rivera");
			donanteDTO.setPeso(51);
			donanteDTO.setRh(empleadoBL.getRhDAO().obtener("O+"));
					
			EmpleadoDTO enfermero = empleadoBL.getEmpleadoDAO().loguear("enfermero1", "2214325");
			List<PreguntaDTO> preguntas = empleadoBL.obtenerPreguntas(enfermero, "1.0");
			for(PreguntaDTO pregunta : preguntas){
				System.out.println(pregunta.getDescripcion());
			}
			List<RespuestaDTO> respuestas = new ArrayList<RespuestaDTO>();
			
			for(int i=0; i<preguntas.size(); i++){
				RespuestaDTO nuevaRespuesta = new RespuestaDTO();
				
				nuevaRespuesta.setDescripcion("Si");
				nuevaRespuesta.setIdPregunta(preguntas.get(i));	
				nuevaRespuesta.setDocumentoDonante(donanteDTO);
				

				respuestas.add(nuevaRespuesta);
			}	
			for(RespuestaDTO respuesta : respuestas){
				System.out.print(respuesta.getDocumentoDonante().getNombres() +" || ");
				System.out.print(respuesta.getIdPregunta().getDescripcion()+": ");
				System.out.println(respuesta.getDescripcion());				
			}
			
			
			assertTrue(empleadoBL.guardarRespuestas(respuestas, enfermero));
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
