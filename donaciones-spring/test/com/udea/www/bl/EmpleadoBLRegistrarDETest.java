package com.udea.www.bl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.donaciones.bl.EmpleadoBL;
import co.edu.udea.donaciones.dto.DatosDonacionDTO;
import co.edu.udea.donaciones.dto.DonanteDTO;
import co.edu.udea.donaciones.dto.EmpleadoDTO;
import co.edu.udea.donaciones.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "/configuration.xml")
public class EmpleadoBLRegistrarDETest {

	@Autowired
	//PARA INYECTAR EL BEAN QUE SE DEFINIO EN EL ARHCIVO DE CONFIGURACION
	private EmpleadoBL empleadoBL;
	
	
	@Test
	public void testRegistrarDE() {
		try {
			DonanteDTO donanteDTO = new DonanteDTO();
			donanteDTO.setDocumento("142121212");
			donanteDTO.setDireccion("Calle 23");
			donanteDTO.setEdad("18");
			donanteDTO.setEstadoCivil("Soltero");
			donanteDTO.setEstadoSalud("Normal");
			donanteDTO.setNombres("Juan");
			donanteDTO.setApellidos("Rivera");
			donanteDTO.setPeso(51);
			donanteDTO.setRh(empleadoBL.getRhDAO().obtener("O+"));
			
			DatosDonacionDTO datosDonacionDTO = new DatosDonacionDTO();
			datosDonacionDTO.setCantidad(80);
			datosDonacionDTO.setIdRH(donanteDTO.getRh());
			
			EmpleadoDTO enfermero = empleadoBL.validarEmpleado("enfermero1", "2214325");
			
			empleadoBL.registrarDE(donanteDTO, datosDonacionDTO, enfermero);
			
		}catch(MyException e){
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
