package co.edu.udea.www.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import co.edu.udea.www.dao.CiudadDAO;
import co.edu.udea.www.dto.CiudadDTO;
import co.edu.udea.www.exception.MyException;

public class CiudadDAOImplTest {

	@Test
	public void testObtener() {
		CiudadDAO ciudadDAO = null;
		List<CiudadDTO> lista = null;
		
		try{
			ciudadDAO = new CiudadDAOImpl();
			lista = ciudadDAO.obtener();
			assertTrue(lista.size()>0);
		}catch (MyException e) {
			fail(e.getMessage());
		}
	}

}
