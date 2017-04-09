package com.udea.www.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.udea.www.Exception.MyException;
import com.udea.www.dto.CiudadDTO;

/**
 * 
 * @author Richard Morales
 *
 */
public class CiudadDAOImp {
	private SessionFactory sessionFactory;
	
	/**
	 * Metodo para obtener la lista de ciudades
	 * @return retorna las ciudades
	 * @throws MyException
	 */
	public List<CiudadDTO> obtener() throws MyException{
		List<CiudadDTO> lista = new ArrayList<CiudadDTO>();
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(CiudadDTO.class);
			lista=criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error consultando ciudades", e);
		}
		return lista;
	}
	
	/**
	 * Metodo para obtener una ciudad por su codigo
	 * @param codigo de la ciudad
	 * @return Retorna la ciudad con el codigo enviado
	 * @throws MyException
	 */
	public CiudadDTO obtener(long codigo) throws MyException{
		CiudadDTO ciudad= new CiudadDTO();
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(CiudadDTO.class);
			criteria.add(Restrictions.eq("codigo", codigo));
			ciudad = (CiudadDTO)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new MyException("Error consultando ciudades", e);
		}
		return ciudad;
	}
	
	/**
	 * Metodo para guardar una ciudad 
	 * @param ciudad Ciudad que se guardara
	 * @throws MyException
	 */
	public void guardar(CiudadDTO ciudad) throws MyException{
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(ciudad);
		}catch(HibernateException e){
			throw new MyException("Error en la transaccion", e);
		}
	}
	
	/**
	 * Metodo para borrar una ciudad 
	 * @param ciudad que se borrara
	 * @throws MyException
	 */
	public void borrar(CiudadDTO ciudad) throws MyException{
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			session.delete(ciudad);
		}catch(HibernateException e){
			throw new MyException("Error en la transaccion", e);
		}
	}
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
