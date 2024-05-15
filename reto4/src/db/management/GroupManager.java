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

import db.pojos.Album;
import db.pojos.Group;
import utils.dbUtils.*;

public class GroupManager implements GestorInterfaz {
	
	private	Group group =new Group();
	
	public List<Group> getGroup(){
		ArrayList<Group> ret = null;

		String sql ="select * from grupo";

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
					ret = new ArrayList<Group>();

				Group grupo =new Group();
				
				Integer idGroup = resultSet.getInt("id");
				String imagen = resultSet.getString("imagen");
				String name = resultSet.getString("nombre");
				String descripcion = resultSet.getString("descripcion");
				Date fecha = resultSet.getDate("fechaCreacion");
				Integer numReproduccion = resultSet.getInt("numReproduccion");

				grupo.setIdGroup(idGroup);
				grupo.setImagen(imagen);
				grupo.setName(name);
				grupo.setDescription(descripcion);
				grupo.setCreationDate(fecha);
				grupo.setNumReproduccion(numReproduccion);

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
	public List<Group> obtenerNombreDeGrupo(Album album, Group grupo){
		ArrayList<Group> ret = null;
		String sql ="select nombre from grupo where id='"+album.getIdGroup()+"';";
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
				ret = new ArrayList<Group>();
				grupo.setName(resultSet.getString("nombre"));

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
	public List<Group> getGroupForName(String nameGroup){
		ArrayList<Group> ret = null;
		String sql ="select * from grupo where nombre='"+nameGroup+"';";
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
					ret = new ArrayList<Group>();

				Group grupo =new Group();
				grupo.setIdAuthor(resultSet.getInt("id"));
				grupo.setImagen(resultSet.getString("imagen"));
				grupo.setName(resultSet.getString("nombre"));
				grupo.setDescription(resultSet.getString("descripcion"));
				grupo.setCreationDate( resultSet.getDate("fechaCreacion"));
			
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
	public Group getGroupInfo(String groupName) {
		Group grupo = null;
        String sql = "SELECT * FROM grupo WHERE nombre = '" + groupName + "';";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(DBUtils.DRIVER);
            connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                grupo =new Group();
                grupo.setName(resultSet.getString("nombre"));
                grupo.setImagen(resultSet.getString("imagen"));
                grupo.setCreationDate(resultSet.getDate("fechaCreacion"));
                grupo.setDescription(resultSet.getString("descripcion"));
                grupo.setNumReproduccion(resultSet.getInt("numReproduccion"));
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error generico - " + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception e) {
                // Manejo de errores
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                // Manejo de errores
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // Manejo de errores
            }
        }
        return grupo;
    }
	@Override
	public List select() {
		ArrayList<Group> ret = null;

		String sql ="select * from grupo";

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
					ret = new ArrayList<Group>();

				Group grupo =new Group();
				
				Integer idGroup = resultSet.getInt("id");
				String imagen = resultSet.getString("imagen");
				String name = resultSet.getString("nombre");
				String descripcion = resultSet.getString("descripcion");
				Date fecha = resultSet.getDate("fechaCreacion");
				Integer numReproduccion = resultSet.getInt("numReproduccion");

				grupo.setIdGroup(idGroup);
				grupo.setImagen(imagen);
				grupo.setName(name);
				grupo.setDescription(descripcion);
				grupo.setCreationDate(fecha);
				grupo.setNumReproduccion(numReproduccion);

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

		String sql ="insert into grupo(imagen, nombre , fechaCreacion , descripcion) values('"+imagen+"','"+nombre+"','"+fecha+"','"+descripcion+"');";
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
			JOptionPane.showMessageDialog(null,"Grupo registrado con exito");
		}
	}
	@Override
	public void update(String nombre, String imagen, String descripcion, java.util.Date fecha) {

		String sql ="update grupo set imagen ='"+imagen+"',nombre='"+nombre+"',fechaCreacion='"+fecha+"',descripcion='"+ descripcion+"' where id="+group.getIdAuthor()+";";
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
			JOptionPane.showMessageDialog(null,"Grupo Actualizado");
		}
	}
	@Override
	public void delete(String nombre) {

		String sql ="delete from grupo where nombre='"+nombre+"';";
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
