package co.edu.udea.donaciones.bl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.dto.CitaDTO;
import co.edu.udea.donaciones.dto.EmpleadoDTO;
import co.edu.udea.donaciones.dto.RespuestaDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class EmpleadoBLProgramarCitaTest {

	@Autowired
	EmpleadoBL empleadoBL;
	
	@Test
	public void testProgramarCitas() {

		try{
			EmpleadoDTO enfermero = empleadoBL
					.getEmpleadoDAO()
					.loguear("enfermero1", "2214325");
			
			EmpleadoDTO administrador = empleadoBL
					.getEmpleadoDAO()
					.loguear("administrador1", "2214325");
			
			CitaDTO citaDTO = new CitaDTO();
			citaDTO.setHora("12:00");
			citaDTO.setFecha(new Date());
			
			
			assertTrue(empleadoBL.programarCitas(citaDTO, enfermero, administrador));
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
