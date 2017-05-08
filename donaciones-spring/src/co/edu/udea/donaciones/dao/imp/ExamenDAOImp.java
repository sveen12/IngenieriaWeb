package co.edu.udea.donaciones.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.donaciones.dao.ExamenDAO;
import co.edu.udea.donaciones.dto.EPSDTO;
import co.edu.udea.donaciones.dto.ExamenDTO;
import co.edu.udea.donaciones.exception.MyException;

public class ExamenDAOImp implements ExamenDAO{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<ExamenDTO> obtener(EPSDTO epsDTO) throws MyException {
		List<ExamenDTO> examenes = new ArrayList<ExamenDTO>();
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(ExamenDTO.class);
			criteria.add(Restrictions.eq("idEPS", epsDTO));
			examenes=criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error obteniendo examenes de EPS", e);
		}
		return examenes;
	}

}
