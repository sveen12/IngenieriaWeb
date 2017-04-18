package com.udea.www.bl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.www.Exception.MyException;
import com.udea.www.dto.ClienteDTO;
import com.udea.www.dto.UsuarioDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class UsuarioBLTest {

	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	private UsuarioBL usuarioBL;
	
	@Test
	public void testValidarUsuario() {
		UsuarioDTO usuario;
		
		try{
			usuario = usuarioBL.validarUsuario("elver", "1g0/KkFdhrmg1DYJWFdd2A==");
			assertTrue(usuario != null);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
