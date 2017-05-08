package co.edu.udea.donaciones.bl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.bl.EmpleadoBL;
import co.edu.udea.donaciones.dto.EmpleadoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class EmpleadoBLValidarEmpleadoTest {

	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	private EmpleadoBL empleadoBL;
	
	@Test
	public void testValidarEmpleado() {
		EmpleadoDTO empleadoDTO;
		try {
			empleadoDTO = empleadoBL.validarEmpleado("enfermero1", "2214325");
			assertTrue(empleadoDTO!=null);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

}
