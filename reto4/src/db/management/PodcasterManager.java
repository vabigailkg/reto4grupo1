package db.management;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import db.pojos.Group;
import db.pojos.Podcaster;
import utils.dbUtils.DBUtils;

public class PodcasterManager implements GestorInterfaz {
	private Podcaster podcaster=new Podcaster();
	
	public List<Podcaster> getTop10Author(){
		ArrayList<Podcaster> ret = null;

		String sql ="SELECT id , nombre ,descripcion , numReproduccion from grupo union SELECT id , nombre , descripcion, numReproduccion  from podcaster order by numReproduccion desc limit 10;";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Podcaster>();

				Podcaster author =new Podcaster();
				
				Integer idGroup = resultSet.getInt("id");
				String name = resultSet.getString("nombre");
				String descripcion = resultSet.getString("descripcion");
				Integer numReproduccion = resultSet.getInt("numReproduccion");

				author.setIdAuthor(idGroup);
				author.setName(name);
				author.setDescription(descripcion);
				author.setNumReproduction(numReproduccion);

				ret.add(author);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return ret;
	}
	public List<Podcaster> getPodcastForName(String namePodcaster){
		ArrayList<Podcaster> ret = null;
		String sql ="select * from podcaster where nombre='"+namePodcaster+"';";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Podcaster>();
				
				podcaster.setIdAuthor(resultSet.getInt("id"));
				podcaster.setImagen(resultSet.getString("imagen"));
				podcaster.setName(resultSet.getString("nombre"));
				podcaster.setDescription(resultSet.getString("descripcion"));
				podcaster.setCreationDate( resultSet.getDate("fechaCreacion"));
				ret.add(podcaster);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return ret;
	}
	
	public void updatePodcaster(String nombre , String imagen ,String descripcion, java.util.Date fecha){

		String sql ="update podcaster set imagen ='"+imagen+"',nombre='"+nombre+"',fechaCreacion='"+fecha+"',descripcion='"+ descripcion+"' where id="+podcaster.getIdAuthor()+";";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			numeroFilas = statement.executeUpdate(sql);
			if (numeroFilas != 0) {
	            JOptionPane.showMessageDialog(null, "Podcaster Modificado con Exito");
	        } else {
	            JOptionPane.showMessageDialog(null, "No se encontra ningun podcaster con el nombre especificado");
	        }
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error generico - " + e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
	}
	public void deletePodcaster(String nombre){

		String sql ="delete from podcaster where nombre='"+nombre+"';";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			numeroFilas = statement.executeUpdate(sql);
			if (numeroFilas != 0) {
	            JOptionPane.showMessageDialog(null, "Podcaster eliminado con Exito");
	        } else {
	            JOptionPane.showMessageDialog(null, "No se encontra ningun podcaster con el nombre especificado");
	        }
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error generico - " + e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
	}
	@Override
	public List select() {
		ArrayList<Podcaster> ret = null;

		String sql ="select * from podcaster";

		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Podcaster>();

				Podcaster grupo =new Podcaster();
				
				Integer idGroup = resultSet.getInt("id");
				String imagen = resultSet.getString("imagen");
				String name = resultSet.getString("nombre");
				String descripcion = resultSet.getString("descripcion");
				Date fecha = resultSet.getDate("fechaCreacion");
				Integer numReproduccion = resultSet.getInt("numReproduccion");

				grupo.setIdAuthor(idGroup);
				grupo.setImagen(imagen);
				grupo.setName(name);
				grupo.setDescription(descripcion);
				grupo.setCreationDate(fecha);
				grupo.setNumReproduction(numReproduccion);

				ret.add(grupo);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error generico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return ret;
	}
	@Override
	public void insert(String nombre, String imagen, String descripcion, java.util.Date fecha) {

		String sql ="insert into podcaster(imagen, nombre , fechaCreacion , descripcion) values('"+imagen+"','"+nombre+"','"+fecha+"','"+descripcion+"');";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			numeroFilas = statement.executeUpdate(sql);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error generico - " + e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		if (numeroFilas != 0) {
			JOptionPane.showMessageDialog(null,"Podcaster registrado con exito");
		}
	}
	@Override
	public void update(String nombre, String imagen, String descripcion, java.util.Date fecha) {

		String sql ="update podcaster set imagen ='"+imagen+"',nombre='"+nombre+"',fechaCreacion='"+fecha+"',descripcion='"+ descripcion+"' where id="+podcaster.getIdAuthor()+";";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			numeroFilas = statement.executeUpdate(sql);
			if (numeroFilas != 0) {
	            JOptionPane.showMessageDialog(null, "Podcaster Modificado con Exito");
	        } else {
	            JOptionPane.showMessageDialog(null, "No se encontra ningun podcaster con el nombre especificado");
	        }
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error generico - " + e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
	}
	@Override
	public void delete(String nombre) {

		String sql ="delete from podcaster where nombre='"+nombre+"';";
		Connection connection = null;
		Statement statement = null;
		int numeroFilas = 0;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			numeroFilas = statement.executeUpdate(sql);
			if (numeroFilas != 0) {
	            JOptionPane.showMessageDialog(null, "Grupo eliminado con exito");
	        } else {
	            JOptionPane.showMessageDialog(null, "No se encontra ningun grupo con el nombre especificado");
	        }
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null,"Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error generico - " + e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
	}
}
