package co.edu.udea.donaciones.bl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.bl.EmpleadoBL;
import co.edu.udea.donaciones.dto.CitaDTO;
import co.edu.udea.donaciones.dto.EmpleadoDTO;
import co.edu.udea.donaciones.dto.PreguntaDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class EmpleadoBLDiligenciarFormularioTest {
	@Autowired
	EmpleadoBL empleadoBL;
	
	@Test
	public void testObtenerPreguntas() {
		try{
			EmpleadoDTO enfermero = empleadoBL.getEmpleadoDAO().loguear("enfermero1", "2214325");
			List<PreguntaDTO> preguntas = empleadoBL.obtenerPreguntas(enfermero);
			assertTrue(!preguntas.isEmpty());
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testGuardarRespuestas() {
		fail("Not yet implemented");
	}

}
