package co.edu.udea.donaciones.bl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.dto.EmpleadoDTO;
import co.edu.udea.donaciones.dto.UnidadMovilDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class EmpleadoBLRegistrarUnidadMovilTest {

	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	private EmpleadoBL empleadoBL;
	
	
	@Test
	public void testRegistrarUnidadMovil() {
		
		
		try {
			EmpleadoDTO adminRegistra = empleadoBL.validarEmpleado("administrador1", "2214325");
			UnidadMovilDTO unidadMovilDTO = new UnidadMovilDTO();
			
			unidadMovilDTO.setIdSede(adminRegistra.getIdSede());
			unidadMovilDTO.setNombre("Corazon abierto");
			unidadMovilDTO.setUbicacion("Minorista");
			
			assertTrue(empleadoBL.registrarUnidadMovil(unidadMovilDTO, adminRegistra));
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
