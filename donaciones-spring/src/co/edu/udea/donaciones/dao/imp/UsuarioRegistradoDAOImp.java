package co.edu.udea.donaciones.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.donaciones.dao.UsuarioRegistradoDAO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

public class UsuarioRegistradoDAOImp implements UsuarioRegistradoDAO{
	private SessionFactory sessionFactory;


	@Override
	public List<UsuarioRegistradoDTO> obtener() throws MyException {
		List<UsuarioRegistradoDTO> usuarios = new ArrayList<UsuarioRegistradoDTO>();
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(UsuarioRegistradoDTO.class);
			usuarios=criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error consultando usuarios registrados", e);
		}
		return usuarios;
	}

	@Override
	public UsuarioRegistradoDTO loguear(String usuario, String contrasena) throws MyException {
		UsuarioRegistradoDTO usuarioRegistradoDTO= new UsuarioRegistradoDTO();
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(UsuarioRegistradoDTO.class);
			criteria.add(Restrictions.eq("usuario", usuario));
			criteria.add(Restrictions.eq("contrasena", contrasena));
			usuarioRegistradoDTO = (UsuarioRegistradoDTO)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new MyException("Error consultando el usuario", e);
		}
		
		return usuarioRegistradoDTO;
	}

	@Override
	public boolean guardar(UsuarioRegistradoDTO usuarioRegistrado) throws MyException {
		Session session=null;
		
		UsuarioRegistradoDTO usuarioExiste;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria1 = session.createCriteria(UsuarioRegistradoDTO.class);
			criteria1.add(Restrictions.eq("usuario", usuarioRegistrado.getUsuario()));
			usuarioExiste = (UsuarioRegistradoDTO)criteria1.uniqueResult();
			
			if(usuarioExiste != null){
				throw new MyException("El usuario ya existe");
			}	
			
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(usuarioRegistrado);
			
		}catch(HibernateException e){
			throw new MyException("Error guardando usuario en el sistema", e);
		}		
		return true;
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
