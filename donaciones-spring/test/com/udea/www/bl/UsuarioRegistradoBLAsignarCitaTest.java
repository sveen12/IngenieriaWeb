package com.udea.www.bl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.bl.UsuarioRegistradoBL;
import co.edu.udea.donaciones.dto.CitaDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class UsuarioRegistradoBLAsignarCitaTest {
	@Autowired
	UsuarioRegistradoBL usuarioRegistradoBL;
	
	@Test
	public void testAsignarCita() {
		try {
			UsuarioRegistradoDTO usuarioRegistradoDTO = usuarioRegistradoBL.
					getUsuarioRegistradoDAO().loguear("sveen12", "2214325");
			
			List<CitaDTO> citasDisponibles = usuarioRegistradoBL.
					getCitaDAO().citasDisponibles("2017-04-01");
			
			CitaDTO citaDTO = citasDisponibles.get(0);
			System.out.println(citaDTO.getHora());
			assertTrue(usuarioRegistradoBL.asignarCita(citaDTO, usuarioRegistradoDTO));
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
