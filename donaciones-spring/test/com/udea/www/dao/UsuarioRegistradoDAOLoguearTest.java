package com.udea.www.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.dao.imp.UsuarioRegistradoDAOImp;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class UsuarioRegistradoDAOLoguearTest {
	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	UsuarioRegistradoDAOImp usuarioRegistradoDAO;
	
	@Test
	public void testLoguear() {
		UsuarioRegistradoDTO resultado = null;
		try{
			resultado = usuarioRegistradoDAO.loguear("sveen12", "2214325");
			System.out.println(resultado.getDocumentoUsuario().getDocumento());
			assertTrue(resultado!=null);			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
