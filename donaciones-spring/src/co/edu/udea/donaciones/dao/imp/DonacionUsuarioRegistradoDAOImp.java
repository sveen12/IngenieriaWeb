package co.edu.udea.donaciones.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.donaciones.dao.DonacionUsuarioRegistradoDAO;
import co.edu.udea.donaciones.dto.DonacionUsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

public class DonacionUsuarioRegistradoDAOImp implements DonacionUsuarioRegistradoDAO {
	private SessionFactory sessionFactory;	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean guardar(DonacionUsuarioRegistradoDTO donacionUsuarioRegistradoDTO) throws MyException {
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(donacionUsuarioRegistradoDTO);
			
			return true;
		}catch(HibernateException e){
			throw new MyException("Error guardando la donacion de usuario registrado en el sistema", e);
		}
		
	}

	@Override
	public List<DonacionUsuarioRegistradoDTO> obtener() throws MyException {
		List<DonacionUsuarioRegistradoDTO> donacionSedeDTOs = new ArrayList<DonacionUsuarioRegistradoDTO>();
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(DonacionUsuarioRegistradoDTO.class);
			donacionSedeDTOs=criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error obteniendo donaciones de usuario registradas", e);
		}
		return donacionSedeDTOs;
	}

	@Override
	public List<DonacionUsuarioRegistradoDTO> obtener(String cedula) throws MyException {
		List<DonacionUsuarioRegistradoDTO> donacionSedeDTOs = new ArrayList<DonacionUsuarioRegistradoDTO>();
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(DonacionUsuarioRegistradoDTO.class);
			criteria.add(Restrictions.eq("cedula", cedula));
			donacionSedeDTOs=criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error obteniendo donaciones de usuario por cedula registradas", e);
		}
		return donacionSedeDTOs;
	}

}
