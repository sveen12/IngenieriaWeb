package co.edu.udea.donaciones.bl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.dto.DonanteDTO;
import co.edu.udea.donaciones.dto.EmpleadoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class EmpleadoBLRegistrarEmpleadoTest {

	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	private EmpleadoBL empleadoBL;
	
	@Test
	public void testRegistrarEmpleado() {
				
		
		try {
			EmpleadoDTO adminRegistra = empleadoBL.validarEmpleado("administrador1", "2214325");
			EmpleadoDTO empleadoDTO = new EmpleadoDTO();
			empleadoDTO.setApellidos("Jimenez");
			empleadoDTO.setContrasena("443121");
			empleadoDTO.setDireccion("Calle 23");
			empleadoDTO.setDocumento("11526127");
			empleadoDTO.setIdCargo(empleadoBL.getCargoDAO().obtener("enfermero"));
			empleadoDTO.setIdSede(adminRegistra.getIdSede());
			empleadoDTO.setNombres("Jose Repelin");
			empleadoDTO.setTelefono("2214325");
			empleadoDTO.setUsuario("enfermero2");
			
			assertTrue(empleadoBL.registrarEmpleado(empleadoDTO, adminRegistra));
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}

}
