package co.edu.udea.donaciones.dao.imp;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.donaciones.dao.DatosDonacionDAO;
import co.edu.udea.donaciones.dto.CargoDTO;
import co.edu.udea.donaciones.dto.DatosDonacionDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

public class DatosDonacionDAOImp implements DatosDonacionDAO {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public DatosDonacionDTO guardar(DatosDonacionDTO datosDonacionDTO) throws MyException {
		Session session=null;
		DatosDonacionDTO datosDonacionDTOInsertado;
		
		try{
			session = sessionFactory.getCurrentSession();
			session.save(datosDonacionDTO);
			
			return datosDonacionDTO;
		}catch(HibernateException e){
			throw new MyException("Error guardando datos de donacion en el sistema", e);
		}
	}

	
	@Override
	public DatosDonacionDTO obtener(int id) throws MyException {
		DatosDonacionDTO datosDonacionDTO;
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(DatosDonacionDTO.class);
			criteria.add(Restrictions.eq("id", id));
			datosDonacionDTO=(DatosDonacionDTO)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new MyException("Error consultando cargos en el sistema", e);
		}
		return datosDonacionDTO;
	}
}
