package com.udea.www.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.udea.www.Exception.MyException;
import com.udea.www.dto.UsuarioDTO;

public class UsuarioDAOImp {
	SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Para obtener la lista de usuarios
	 * @return retorna la lista de usuarios
	 * @throws MyException
	 */
	public List<UsuarioDTO> obtener() throws MyException{
		List<UsuarioDTO> lista = new ArrayList<UsuarioDTO>();
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(UsuarioDTO.class);
			lista=criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error consultando ciudades", e);
		}finally{
			if(session!=null){
				session.close();
			}
		}
		return lista;
	}


	/**
	 * Obtener un usuario logueado
	 * @param login Usuario que se logueara
	 * @return Retorna un usuario
	 * @throws MyException
	 */
		public UsuarioDTO obtener(String login) throws MyException{
			UsuarioDTO usuario= new UsuarioDTO();
			Session session=null;
			try{
				session = sessionFactory.getCurrentSession();
				Criteria criteria = session.createCriteria(UsuarioDTO.class);
				criteria.add(Restrictions.eq("login", login));
				usuario = (UsuarioDTO)criteria.uniqueResult();
			}catch(HibernateException e){
				throw new MyException("Error consultando ciudades", e);
			}
			
			return usuario;
		}
		
		/**
		 * Este metodo valida que un usuario exista en el sistema dado su login y contraseña
		 * @param login es el nombre de usuario
		 * @param contrasena contraseña para ingresar al sistema
		 * @return	Retorna una instancia del usuario
		 * @throws MyException
		 */
		public UsuarioDTO validarUsuario(String login, String contrasena) throws MyException{
			UsuarioDTO usuario= new UsuarioDTO();
			Session session=null;
			try{
				session = sessionFactory.getCurrentSession();
				Criteria criteria = session.createCriteria(UsuarioDTO.class);
				criteria.add(Restrictions.eq("login", login));
				criteria.add(Restrictions.eq("contrasena", contrasena));
				usuario = (UsuarioDTO)criteria.uniqueResult();
			}catch(HibernateException e){
				throw new MyException("Error consultando el usuario", e);
			}
			
			return usuario;
		}
}
