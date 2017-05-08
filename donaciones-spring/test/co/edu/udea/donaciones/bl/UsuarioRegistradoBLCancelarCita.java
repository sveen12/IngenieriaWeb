package co.edu.udea.donaciones.bl;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.bl.UsuarioRegistradoBL;
import co.edu.udea.donaciones.dto.CitaDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class UsuarioRegistradoBLCancelarCita {
	@Autowired
	UsuarioRegistradoBL usuarioRegistradoBL;
	
	@Test
	public void test() {
		try {
			UsuarioRegistradoDTO usuarioRegistradoDTO = usuarioRegistradoBL.
					getUsuarioRegistradoDAO().loguear("sveen12", "2214325");
						
			CitaDTO citaDTO = usuarioRegistradoBL.getCitaDAO().
					obtener(usuarioRegistradoDTO);
			
			assertTrue(usuarioRegistradoBL.cancelarCita(citaDTO));
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
