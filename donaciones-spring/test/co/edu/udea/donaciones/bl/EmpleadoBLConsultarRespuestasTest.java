package co.edu.udea.donaciones.bl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.dto.RespuestaDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class EmpleadoBLConsultarRespuestasTest {

	@Autowired
	EmpleadoBL empleadoBL;
	
	@Test
	public void testConsultarRespuestas() {
		try{
			UsuarioRegistradoDTO usuarioRegistradoDTO = empleadoBL
					.getUsuarioRegistradoDAO()
					.loguear("sveen12", "2214325");

			
			List<RespuestaDTO> respuestas = empleadoBL.consultarRespuestas(usuarioRegistradoDTO.getDocumentoUsuario());
			
			assertTrue(!respuestas.isEmpty());
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
