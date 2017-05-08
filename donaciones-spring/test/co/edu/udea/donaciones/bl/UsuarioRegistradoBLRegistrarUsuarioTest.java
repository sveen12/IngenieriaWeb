package com.udea.www.bl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.bl.UsuarioRegistradoBL;
import co.edu.udea.donaciones.dto.DonanteDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class UsuarioRegistradoBLRegistrarUsuarioTest {

	@Autowired
	UsuarioRegistradoBL usuarioRegistradoBL;
	
	@Test
	public void testRegistrarUsuario() {
		try {
			DonanteDTO donanteDTO = new DonanteDTO();
			donanteDTO.setDocumento("142121212");
			donanteDTO.setDireccion("Calle 23");
			donanteDTO.setEdad("18");
			donanteDTO.setEstadoCivil("Soltero");
			donanteDTO.setEstadoSalud("Normal");
			donanteDTO.setNombres("Juan");
			donanteDTO.setApellidos("Rivera");
			donanteDTO.setPeso(51);
			donanteDTO.setRh(usuarioRegistradoBL.getRhDAO().obtener("O+"));
			
			
			assertTrue(usuarioRegistradoBL.registrarUsuario(donanteDTO, "juan12", "2214325"));
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
