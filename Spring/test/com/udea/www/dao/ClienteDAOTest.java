package com.udea.www.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.www.Exception.MyException;
import com.udea.www.dao.imp.CiudadDAOImp;
import com.udea.www.dao.imp.ClienteDAOImp;
import com.udea.www.dto.ClienteDTO;
import com.udea.www.dto.UsuarioDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class ClienteDAOTest {
	
	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	ClienteDAOImp clienteDao;
	
	
	@Test
	public void testObtener(){
		List<ClienteDTO> resultado = null;
		try{
			resultado = clienteDao.obtener();
			for(ClienteDTO cliente : resultado){
				System.out.println(cliente.getNombres() + " " + cliente.getApellidos());
			}
			assertTrue(resultado.size()>0);
		}catch(MyException e){
			fail(e.getMessage());
		}
	}
}
