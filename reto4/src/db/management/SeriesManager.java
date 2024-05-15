package db.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import db.pojos.Series;
import utils.dbUtils.DBUtils;

public class SeriesManager {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public List<Series> getTop10() {
		ArrayList<Series> ret = new ArrayList<>();

		String sql = "SELECT id , titulo ,descripcion , numReproduccion from disco union SELECT id , titulo , descripcion, numReproduccion  from serie order by numReproduccion desc limit 10;";

		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Series disco = new Series();
				disco.setIdSeries(resultSet.getInt("id"));
				disco.setTitle(resultSet.getString("titulo"));
				disco.setDescription(resultSet.getString("descripcion"));
				disco.setNumReproduction(resultSet.getInt("numReproduccion"));
				ret.add((Series) disco);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + e.getMessage());
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// Manejar el cierre de recursos
			}
		}
		return ret;
	}
}
