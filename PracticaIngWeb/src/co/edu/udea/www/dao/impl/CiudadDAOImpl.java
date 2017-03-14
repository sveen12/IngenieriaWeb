package co.edu.udea.www.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.www.connection.DataSourceSingleton;
import co.edu.udea.www.dao.CiudadDAO;
import co.edu.udea.www.dto.CiudadDTO;
import co.edu.udea.www.exception.MyException;

public class CiudadDAOImpl implements CiudadDAO{
	
	/**
	 * Se obtiene una instancia del datasource
	 */
	DataSourceSingleton dsSingleton = DataSourceSingleton.getInstance();
	
	@Override
	public List<CiudadDTO> obtener() throws MyException {
		
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		List<CiudadDTO> lista = new ArrayList<CiudadDTO>();
		
		
		try{
			con = dsSingleton.getConnection();
			ps = con.prepareStatement("SELECT * FROM ciudades");
			rs = ps.executeQuery();
			
			while(rs.next()){
				CiudadDTO ciudad = new CiudadDTO();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
				lista.add(ciudad);
			}
			
		}catch(SQLException e){
			throw new MyException("Error consultando", e);
		}finally{
			try{
				if(rs != null)
					rs.close();
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			}catch(SQLException e){
				throw new MyException("Error cerrando",e);				
			}
		}
		
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public CiudadDTO obtener(Long codigo) throws MyException {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		CiudadDTO ciudad = null;
		
		try{
			con = dsSingleton.getConnection();
			ps = con.prepareStatement("SELECT * FROM ciudades WHERE codigo=?");
			ps.setLong(1, codigo);
			rs = ps.executeQuery();
			
			if(rs.next()){
				ciudad = new CiudadDTO();
				ciudad.setCodigo(rs.getLong("codigo"));
				ciudad.setNombre(rs.getString("nombre"));
				ciudad.setCodigoArea(rs.getString("codigoArea"));
			}
			
		}catch(SQLException e){
			throw new MyException("Error consultando", e);
		}finally{
			try{
				if(rs != null)
					rs.close();
				if(ps != null)
					ps.close();
				if(con != null)
					con.close();
			}catch(SQLException e){
				throw new MyException("Error cerrando",e);				
			}
		}
		return ciudad;
	}
	
}
