package co.edu.udea.donaciones.dao.imp;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.donaciones.dao.RHDAO;
import co.edu.udea.donaciones.dto.RHDTO;
import co.edu.udea.donaciones.exception.MyException;

public class RhDAOImp implements RHDAO {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public RHDTO obtener(String rh) throws MyException {
		RHDTO rhdto= new RHDTO();
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(RHDTO.class);
			criteria.add(Restrictions.eq("descripcion", rh));
			rhdto = (RHDTO) criteria.uniqueResult();
		}catch(HibernateException e){
			throw new MyException("Error consultando el rh", e);
		}		
		return rhdto;
	}

}
