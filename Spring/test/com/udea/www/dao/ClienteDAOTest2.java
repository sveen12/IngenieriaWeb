package com.udea.www.dao;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.www.Exception.MyException;
import com.udea.www.dao.imp.ClienteDAOImp;
import com.udea.www.dto.ClienteDTO;
import com.udea.www.dto.UsuarioDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class ClienteDAOTest2 {
	
	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	ClienteDAOImp clienteDao;
	
	
	@Test
	public void testGuardar(){
		ClienteDTO cliente = null;
		UsuarioDTO usuario = null;
		try{
			cliente = new ClienteDTO();
			cliente.setCedula("123456789");
			cliente.setNombres("elver");
			cliente.setApellidos("ELVERAPELLIDO");
			cliente.setEmail("elver@udea.com");
			usuario = new UsuarioDTO();
			usuario.setLogin("elver");
			cliente.setUsuarioCrea(usuario);
			cliente.setFechaCreacion(new Date());
			clienteDao.guardar(cliente);
		}catch(MyException r){
			r.printStackTrace();
			fail(r.getMessage());
		}
	}
}
