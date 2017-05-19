package co.edu.udea.donaciones.dao.imp;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.donaciones.dao.UnidadMovilDAO;
import co.edu.udea.donaciones.dto.UnidadMovilDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

public class UnidadMovilDAOImp implements UnidadMovilDAO {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean guardar(UnidadMovilDTO unidadMovilDTO) throws MyException {
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(unidadMovilDTO);
			return true;
		}catch(HibernateException e){
			throw new MyException("Error guardando la unidad movil en el sistema", e);
		}
	}

	@Override
	public UnidadMovilDTO obtener(int id) throws MyException {
		UnidadMovilDTO unidadMovilDTO= new UnidadMovilDTO();
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(UnidadMovilDTO.class);
			criteria.add(Restrictions.eq("id", id));
			unidadMovilDTO = (UnidadMovilDTO)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new MyException("Error consultando el la unidad movil", e);
		}
		
		return unidadMovilDTO;
	}

}
