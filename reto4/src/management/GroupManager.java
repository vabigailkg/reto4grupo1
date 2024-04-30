package management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import pojos.Group;
import utils.DBUtils;

public class GroupManager {
	
	public List<Group> obtenerGrupo(){
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

				Group grupo = new Group();

				int idGrupo = resultSet.getInt("id");
				String imagen = resultSet.getString("imagen");
				String name = resultSet.getString("nombre");
				String descripcion = resultSet.getString("descripcion");
				String fecha = resultSet.getString("fechaCreacion");

				grupo.setIdAuthor(idGrupo);
				grupo.setImagen(imagen);
				grupo.setName(name);
				grupo.setDescription(descripcion);
				grupo.setCreationDate(null);

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
		return null;
	}
	
	
}
