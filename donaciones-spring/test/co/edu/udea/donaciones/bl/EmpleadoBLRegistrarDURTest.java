package co.edu.udea.donaciones.bl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.bl.EmpleadoBL;
import co.edu.udea.donaciones.dto.DatosDonacionDTO;
import co.edu.udea.donaciones.dto.DonanteDTO;
import co.edu.udea.donaciones.dto.EmpleadoDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class EmpleadoBLRegistrarDURTest {

	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	private EmpleadoBL empleadoBL;
	
	@Test
	public void testRegistrarDUR() {
		try {
			UsuarioRegistradoDTO usuarioRegistradoDTO =
					empleadoBL.getUsuarioRegistradoDAO().loguear("sveen12", "2214325");
			
			DatosDonacionDTO datosDonacionDTO = new DatosDonacionDTO();
			datosDonacionDTO.setCantidad(80);
			datosDonacionDTO.setIdRH(usuarioRegistradoDTO.
					getDocumentoUsuario().getRh());
			
			EmpleadoDTO enfermero = empleadoBL.validarEmpleado("enfermero1", "2214325");
			
			empleadoBL.registrarDUR(usuarioRegistradoDTO, datosDonacionDTO, enfermero);
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
