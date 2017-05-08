package co.edu.udea.donaciones.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.donaciones.dao.DonacionSedeDAO;
import co.edu.udea.donaciones.dto.DonacionSedeDTO;
import co.edu.udea.donaciones.exception.MyException;

public class DonacionSedeDAOImp implements DonacionSedeDAO {
	private SessionFactory sessionFactory;	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardar(DonacionSedeDTO donacionSedeDTO) throws MyException {
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(donacionSedeDTO);
		}catch(HibernateException e){
			throw new MyException("Error guardando la donacion por sede en el sistema", e);
		}

	}

	@Override
	public List<DonacionSedeDTO> obtener() throws MyException {
		List<DonacionSedeDTO> donacionSedeDTOs = new ArrayList<DonacionSedeDTO>();
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(DonacionSedeDTO.class);
			donacionSedeDTOs=criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error obteniendo donaciones por sede registradas", e);
		}
		return donacionSedeDTOs;
	}
}
