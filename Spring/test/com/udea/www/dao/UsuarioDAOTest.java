package com.udea.www.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.www.Exception.MyException;
import com.udea.www.dao.imp.ClienteDAOImp;
import com.udea.www.dao.imp.UsuarioDAOImp;
import com.udea.www.dto.UsuarioDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class UsuarioDAOTest {
	
	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	UsuarioDAOImp usuario;
	
	@Test
	public void testObtener(){
		String login = "elver";
		UsuarioDTO user = null;
		try{
			user = usuario.obtener(login);
			assertTrue(user!=null);
			System.out.println(user.getNombres()+"-"+user.getRol().getNombre());
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
