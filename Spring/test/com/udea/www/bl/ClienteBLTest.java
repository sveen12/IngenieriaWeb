package com.udea.www.bl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.www.Exception.MyException;
import com.udea.www.bl.ClienteBL;
import com.udea.www.dto.ClienteDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class ClienteBLTest {

	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	private ClienteBL clienteBL;
	
	@Test
	public void testObtener() {
		List<ClienteDTO> lista = null;		
		
		try{
			lista = clienteBL.obtener();
			assertTrue(lista.size()>0);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}


	}

}
