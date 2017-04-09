package com.udea.www.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.udea.www.Exception.MyException;
import com.udea.www.dao.ClienteDAO;
import com.udea.www.dto.ClienteDTO;

public class ClienteDAOImp implements ClienteDAO{	
	private SessionFactory sessionFactory;
	
	/**
	 * Entrega la lista clientes ordenados por su fecha de creación 
	 * @return retorna la lista de clientes
	 * @throws MyException
	 */
	@Override
	public List<ClienteDTO> obtener() throws MyException{
		List<ClienteDTO> clientes = new ArrayList<ClienteDTO>();
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(ClienteDTO.class);
			criteria.addOrder(Order.asc("fechaCreacion"));
			clientes=criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error consultando clientes", e);
		}
		return clientes;
	}

	/**
	 * Guarda un cliente
	 * @param cliente El cliente que se quiere guardar
	 * @throws MyException
	 */
	@Override
	public void guardar(ClienteDTO cliente) throws MyException {
		
		Session session=null;
		try{
			session = session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(cliente);
		}catch(HibernateException e){
			throw new MyException("Error en la transaccion guardando el cliente", e);
		}
		
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
