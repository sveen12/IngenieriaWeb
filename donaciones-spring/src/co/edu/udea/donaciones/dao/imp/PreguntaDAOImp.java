package co.edu.udea.donaciones.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.donaciones.dao.PreguntaDAO;
import co.edu.udea.donaciones.dto.ExamenDTO;
import co.edu.udea.donaciones.dto.PreguntaDTO;
import co.edu.udea.donaciones.exception.MyException;

public class PreguntaDAOImp implements PreguntaDAO {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<PreguntaDTO> obtener(ExamenDTO examen) throws MyException {
		List<PreguntaDTO> preguntaDTOs = new ArrayList<PreguntaDTO>();
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(PreguntaDTO.class);
			criteria.add(Restrictions.eq("idExamen", examen));
			preguntaDTOs=criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error obteniendo preguntas por examen", e);
		}
		return preguntaDTOs;
	}
	


	@Override
	public void guardar(PreguntaDTO preguntaDTO) throws MyException {
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(preguntaDTO);
		}catch(HibernateException e){
			throw new MyException("Error guardando pregunta en el sistema", e);
		}
	}
	
	@Override
	public PreguntaDTO obtener(int id) throws MyException {
		PreguntaDTO preguntaDTOs =null;
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(PreguntaDTO.class);
			criteria.add(Restrictions.eq("id", id));
			preguntaDTOs= (PreguntaDTO)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new MyException("Error obteniendo preguntas por id", e);
		}
		return preguntaDTOs;
	}

}
