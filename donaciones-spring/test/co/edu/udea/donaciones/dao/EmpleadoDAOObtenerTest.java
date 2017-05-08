package com.udea.www.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.dao.imp.EmpleadoDAOImp;
import co.edu.udea.donaciones.dto.EmpleadoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class EmpleadoDAOObtenerTest {

	@Autowired
	EmpleadoDAOImp empleadoDAO;
	
	@Test
	public void testObtener() {
		List<EmpleadoDTO> resultado = null;
		try{
			resultado = empleadoDAO.obtener();
			for(EmpleadoDTO empleado : resultado){
				System.out.println(empleado.getUsuario() + " " + empleado.getIdSede().getNombre());
			}
			assertTrue(resultado.size()>0);
		}catch(MyException e){
			fail(e.getMessage());
		}
	}

}
