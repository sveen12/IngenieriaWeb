package co.edu.udea.donaciones.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.donaciones.dao.SedeDAO;
import co.edu.udea.donaciones.dto.EPSDTO;
import co.edu.udea.donaciones.dto.SedeDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

public class SedeDAOImp implements SedeDAO {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public SedeDTO obtener(int id) throws MyException {
		SedeDTO sedeDTO = new SedeDTO();
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(SedeDTO.class);
			criteria.add(Restrictions.eq("id", id));
			sedeDTO = (SedeDTO)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new MyException("Error consultando la sede por id", e);
		}
		
		return sedeDTO;
	}

	@Override
	public boolean guardar(SedeDTO sedeDTO) throws MyException {
		Session session=null;
		try{					
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(sedeDTO);
			return true;
		}catch(HibernateException e){
			throw new MyException("Error guardando sede en el sistema", e);
		}		
	}

	@Override
	public List<SedeDTO> obtener(EPSDTO epsdto) throws MyException {
		List<SedeDTO> sedeDTOList = new  ArrayList<SedeDTO>();
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(SedeDTO.class);
			criteria.add(Restrictions.eq("idEPS", epsdto));
			sedeDTOList = criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error consultando la sede por eps", e);
		}
		
		return sedeDTOList;
	}

}
