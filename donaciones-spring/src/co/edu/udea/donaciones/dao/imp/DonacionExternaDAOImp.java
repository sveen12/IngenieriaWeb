package co.edu.udea.donaciones.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.donaciones.dao.DonacionExternaDAO;
import co.edu.udea.donaciones.dto.DonacionExternaDTO;
import co.edu.udea.donaciones.exception.MyException;

public class DonacionExternaDAOImp implements DonacionExternaDAO{
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void guardar(DonacionExternaDTO donacionExternaDTO) throws MyException {
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(donacionExternaDTO);
		}catch(HibernateException e){
			throw new MyException("Error guardando la donacion externa en el sistema", e);
		}		
	}

	@Override
	public List<DonacionExternaDTO> obtener() throws MyException {
		List<DonacionExternaDTO> donacionExternaDTOs = new ArrayList<DonacionExternaDTO>();
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(DonacionExternaDTO.class);
			donacionExternaDTOs=criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error obteniendo donaciones externas registradas", e);
		}
		return donacionExternaDTOs;
	}

}
