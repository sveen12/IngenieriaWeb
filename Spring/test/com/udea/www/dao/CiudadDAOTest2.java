package com.udea.www.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.www.Exception.MyException;
import com.udea.www.dao.imp.CiudadDAOImp;
import com.udea.www.dto.CiudadDTO;

import javassist.ClassPath;

//Para decirle a la prueba que usara el Junit de spring para inyectar
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
//Para decirle la ruta del archivo de configuracion de SPRING
@ContextConfiguration(locations = "/configuration.xml")
public class CiudadDAOTest2 {

	
	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	CiudadDAOImp ciudad;
	
	@Test
	public void testObtener(){

		CiudadDTO ciudadDTO = null;	
		long id = 1;
		
		try{
			ciudadDTO = ciudad.obtener(id);
			assertTrue(ciudadDTO != null);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
