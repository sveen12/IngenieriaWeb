package co.edu.udea.donaciones.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.donaciones.dao.RespuestaDAO;
import co.edu.udea.donaciones.dto.RespuestaDTO;
import co.edu.udea.donaciones.exception.MyException;

public class RespuestaDAOImp implements RespuestaDAO {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<RespuestaDTO> obtener(String cedula) throws MyException {
		List<RespuestaDTO> respuestaDTOs = new ArrayList<RespuestaDTO>();
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(RespuestaDTO.class);
			criteria.add(Restrictions.eq("documentoDonante", cedula));
			respuestaDTOs=criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error obteniendo respuestas por usuario", e);
		}
		return respuestaDTOs;
	}

	@Override
	public void guardar(RespuestaDTO respuestaDTOs) throws MyException {
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(respuestaDTOs);
		}catch(HibernateException e){
			throw new MyException("Error guardando respuesta en el sistema", e);
		}
	}

}
