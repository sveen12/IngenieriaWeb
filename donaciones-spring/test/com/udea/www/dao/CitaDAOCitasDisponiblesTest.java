package com.udea.www.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.dao.imp.CitaDAOImp;
import co.edu.udea.donaciones.dto.CitaDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class CitaDAOCitasDisponiblesTest {

	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	CitaDAOImp citaDAOImp;
	
	@Test
	public void test() {
		List<CitaDTO> resultado = new ArrayList<CitaDTO>();
		
		try{
			resultado = citaDAOImp.citasDisponibles("2017-04-01");
			//System.out.println(resultado.getEstadoCita());
			assertTrue(resultado.size()>0);
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
