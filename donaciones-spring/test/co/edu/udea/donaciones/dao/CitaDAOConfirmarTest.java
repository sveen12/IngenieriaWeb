package co.edu.udea.donaciones.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.dao.UsuarioRegistradoDAO;
import co.edu.udea.donaciones.dao.imp.CargoDAOImp;
import co.edu.udea.donaciones.dao.imp.CitaDAOImp;
import co.edu.udea.donaciones.dao.imp.UsuarioRegistradoDAOImp;
import co.edu.udea.donaciones.dto.CitaDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class CitaDAOConfirmarTest {
	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	CitaDAOImp citaDAOImp;
	
	@Autowired
	UsuarioRegistradoDAO usuarioRegistradoDAOImp;
	
	@Test
	public void testConfirmar() {
		CitaDTO resultado = null;
		UsuarioRegistradoDTO usuario;
		
		try{
			usuario = usuarioRegistradoDAOImp.loguear("sveen12", "2214325");
			System.out.println(usuario.getDocumentoUsuario().getDocumento());
			
			resultado = citaDAOImp.obtener(usuario);
			citaDAOImp.confirmar(resultado);
			
			System.out.println(resultado.getEstadoCita());
			assertTrue(resultado!=null);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
