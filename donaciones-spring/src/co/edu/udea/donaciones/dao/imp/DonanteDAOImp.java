package co.edu.udea.donaciones.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.donaciones.dao.DonanteDAO;
import co.edu.udea.donaciones.dto.DonanteDTO;
import co.edu.udea.donaciones.exception.MyException;

public class DonanteDAOImp implements DonanteDAO {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<DonanteDTO> obtener() throws MyException {
		List<DonanteDTO> usuarios = new ArrayList<DonanteDTO>();
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(DonanteDTO.class);
			usuarios=criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error consultando donantes registrados", e);
		}
		return usuarios;
	}

	@Override
	public DonanteDTO obtener(String cedula) throws MyException {
		DonanteDTO donanteDTO= new DonanteDTO();
		Session session=null;
		
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(DonanteDTO.class);
			criteria.add(Restrictions.eq("documento", cedula));
			donanteDTO = (DonanteDTO) criteria.uniqueResult();
		}catch(HibernateException e){
			throw new MyException("Error consultando el donante por cedula.", e);
		}		
		return donanteDTO;
	}

	@Override
	public void guardar(DonanteDTO donanteDTO) throws MyException {
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(donanteDTO);
		}catch(HibernateException e){
			throw new MyException("Error guardando donante en el sistema", e);
		}
	}
}
