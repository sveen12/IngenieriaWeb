package co.edu.udea.donaciones.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.donaciones.dao.EmpleadoDAO;
import co.edu.udea.donaciones.dto.EmpleadoDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

public class EmpleadoDAOImp implements EmpleadoDAO {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<EmpleadoDTO> obtener() throws MyException {
		List<EmpleadoDTO> empleadoDTOs = new ArrayList<EmpleadoDTO>();
		Session session=null;
		Criteria criteria = null;
		try{
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(EmpleadoDTO.class);
			empleadoDTOs=criteria.list();
		}catch(HibernateException e){
			throw new MyException("Error consultando empleados registrados", e);
		}
		return empleadoDTOs;
	}

	@Override
	public EmpleadoDTO loguear(String usuario, String contrasena) throws MyException {
		EmpleadoDTO empleadoDTO= new EmpleadoDTO();
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(EmpleadoDTO.class);
			criteria.add(Restrictions.eq("usuario", usuario));
			criteria.add(Restrictions.eq("contrasena", contrasena));
			empleadoDTO = (EmpleadoDTO)criteria.uniqueResult();
		}catch(HibernateException e){
			throw new MyException("Error consultando el empleado", e);
		}
		
		return empleadoDTO;
	}

	@Override
	public boolean registrarEmpleado(EmpleadoDTO empleado) throws MyException {
		Session session=null;
		EmpleadoDTO enfermeroExiste;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria1 = session.createCriteria(EmpleadoDTO.class);
			criteria1.add(Restrictions.eq("usuario", empleado.getUsuario()));
			enfermeroExiste = (EmpleadoDTO)criteria1.uniqueResult();
			
			if(enfermeroExiste != null){
				throw new MyException("El usuario ya existe");
			}	
			
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(empleado);
			return true;
		}catch(HibernateException e){
			throw new MyException("Error guardando enfermero en el sistema", e);
		}
	}

}
