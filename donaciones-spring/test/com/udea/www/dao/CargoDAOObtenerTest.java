package com.udea.www.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.dao.imp.CargoDAOImp;
import co.edu.udea.donaciones.dto.CargoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class CargoDAOObtenerTest {
	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	CargoDAOImp cargoDAOImp;

	@Test
	public void testObtener() {
		List<CargoDTO> resultado = null;
		try{
			resultado = cargoDAOImp.obtener();
			for(CargoDTO cargo : resultado){
				System.out.println(cargo.getNombre());
			}
			assertTrue(resultado.size()>0);
		}catch(MyException e){
			fail(e.getMessage());
		}
	}

}
