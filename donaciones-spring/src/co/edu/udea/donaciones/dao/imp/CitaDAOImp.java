package co.edu.udea.donaciones.dao.imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import co.edu.udea.donaciones.dao.CitaDAO;
import co.edu.udea.donaciones.dto.CargoDTO;
import co.edu.udea.donaciones.dto.CitaDTO;
import co.edu.udea.donaciones.dto.DonanteDTO;
import co.edu.udea.donaciones.dto.UsuarioRegistradoDTO;
import co.edu.udea.donaciones.exception.MyException;

public final class CitaDAOImp implements CitaDAO{
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean asignar(CitaDTO citaDTO) throws MyException {
		// TODO Auto-generated method stub
		Session session=null;
		citaDTO.setEstadoCita("asignada");
		try{
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(citaDTO);
		}catch(HibernateException e){
			throw new MyException("Error asignando la cita", e);
		}	
		return true;
	}

	@Override
	public boolean cancelar(CitaDTO citaDTO) throws MyException {
		// TODO Auto-generated method stub
		Session session=null;
		citaDTO.setEstadoCita("cancelada");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String hoy = formatter.format(new Date());         
        Date hasta = new Date();
		try {
			hasta = formatter.parse(hoy);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        long diff = citaDTO.getFecha().getTime() - hasta.getTime();
        long dias = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        if(dias < 2){
        	throw new MyException("No se puede cancelar la cita si faltan menos de 48 horas para su realizacion");
        }
        
		try{
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(citaDTO);
		}catch(HibernateException e){
			throw new MyException("Error cancelando la cita", e);
		}	
		return true;
	}

	@Override
	public CitaDTO obtener(UsuarioRegistradoDTO usuario) throws MyException {
		CitaDTO citaDTO= new CitaDTO();
		Session session=null;
		try{
			session = sessionFactory.getCurrentSession();
			Criteria criteria = session.createCriteria(CitaDTO.class);
			criteria.add(Restrictions.eq("idUsuarioRegistrado", usuario));
			criteria.add(Restrictions.eq("estadoCita", "asignada"));
			citaDTO = (CitaDTO) criteria.uniqueResult();
		}catch(HibernateException e){
			throw new MyException("Error consultando la cita del usuario", e);
		}		
		return citaDTO;
	}

	@Override
	public List<CitaDTO> citasDisponibles(String fechaInicio) throws MyException {
		Session session=null;
		Criteria criteria;
		List<CitaDTO> citas = new ArrayList<CitaDTO>();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		 try {
			session = sessionFactory.getCurrentSession();
			criteria = session.createCriteria(CitaDTO.class);
			
			Date desde = formatter.parse(fechaInicio);		
	        String hoy = formatter.format(new Date());         
	        Date hasta = formatter.parse(hoy);
	        
			criteria.add(Restrictions.between("fecha",desde , hasta));
			criteria.add(Restrictions.eq("estadoCita", "disponible"));
			citas = criteria.list();			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new MyException("Error convirtiendo la fecha de la cita", e);
		} catch (HibernateException e){
			throw new MyException("Error consultando las citas con la fecha dada", e);
		}
		// TODO Auto-generated method stub
		return citas;
	}

	@Override
	public void programarCita(CitaDTO citaDTO) throws MyException {
		// TODO Auto-generated method stub
		Session session=null;
		citaDTO.setEstadoCita("disponible");
		try{
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(citaDTO);
		}catch(HibernateException e){
			throw new MyException("Error programando la cita", e);
		}			
	}

	@Override
	public void confirmar(CitaDTO cita) throws MyException {
		// TODO Auto-generated method stub
		Session session=null;
		cita.setEstadoCita("confirmada");
		try{
			session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(cita);
		}catch(HibernateException e){
			throw new MyException("Error confirmando la cita", e);
		}	
		
	}

}
