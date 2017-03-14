package co.edu.udea.www.dao.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import co.edu.udea.www.dto.CiudadDTO;
import co.edu.udea.www.exception.MyException;
import co.edu.udea.www.dao.CiudadDAO;

public class CiudadDAOImplLongTest {

	/**
	 * Testea el metodo obtener enviandole un codigo de ciudad y recibiendo una
	 */
	@Test 
	public void testObtenerLong() {
		CiudadDAO ciudadDAO = null;
		CiudadDTO ciudad = null;
		
		try{
			ciudadDAO = new CiudadDAOImpl();
			ciudad = ciudadDAO.obtener(539211L);
			assertTrue(ciudad!=null);
		}catch (MyException e) {
			fail(e.getMessage());
		}
		
	}

}
