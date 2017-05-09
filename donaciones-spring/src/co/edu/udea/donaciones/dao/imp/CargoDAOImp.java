package co.edu.udea.donaciones.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.donaciones.dao.CargoDAO;
import co.edu.udea.donaciones.dto.CargoDTO;
import co.edu.udea.donaciones.exception.MyException;

public class CargoDAOImp implements CargoDAO {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<CargoDTO> obtener() throws MyException {
		List<CargoDTO> cargos = new ArrayList<CargoDTO>();
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(CargoDTO.class);
			cargos=criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error consultando cargos en el sistema", e);
		}
		return cargos;
	}

	@Override
	public CargoDTO obtener(String cargo) throws MyException {
		CargoDTO cargoDTO;
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(CargoDTO.class);
			criteria.add(Restrictions.eq("nombre", cargo));
			cargoDTO=(CargoDTO)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new MyException("Error consultando cargos en el sistema", e);
		}
		return cargoDTO;
	}

}
