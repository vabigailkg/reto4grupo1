package db.management;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import db.pojos.FreeUser;
import db.pojos.PremiumUser;
import utils.dbUtils.DBUtils;

public class UserManager {

	public boolean getAcountIsBlocked(String login) throws Exception {
		boolean ret = false;
		String sql = "select bloqueado from usuario where login = '" + login + "';";
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {

			ret = resultSet.getBoolean("bloqueado");

			if (resultSet != null)
				resultSet.close();

			if (statement != null)
				statement.close();

			if (connection != null)
				connection.close();

		}
		return ret;
	}
	public int getIdAcount(String login) throws Exception {
		int ret = 0;
		String sql = "select id from usuario where login = '" + login + "';";
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {

			ret = resultSet.getInt("id");

			if (resultSet != null)
				resultSet.close();

			if (statement != null)
				statement.close();

			if (connection != null)
				connection.close();

		}
		return ret;
	}
	public boolean getAcountIsAdmin(String login) throws Exception {
		boolean ret = false;
		String sql = "select esAdministrador from usuario where login = '" + login + "';";
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {

			ret = resultSet.getBoolean("esAdministrador");

			if (resultSet != null)
				resultSet.close();

			if (statement != null)
				statement.close();

			if (connection != null)
				connection.close();

		}
		return ret;
	}

	public String getPassword(String login) throws Exception {
		String ret = null;
		String sql = "select password1 from usuario where login = '" + login + "';";
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {

			ret = resultSet.getString("password1");

			if (resultSet != null)
				resultSet.close();

			if (statement != null)
				statement.close();

			if (connection != null)
				connection.close();

		}
		return ret;
	}

	public String getLogin(String login) throws Exception {
		String ret = null;
		String sql = "select login from usuario where login = '" + login + "';";
		Connection connection = null;

		Statement statement = null;
		ResultSet resultSet = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);

		if (resultSet.next()) {

			ret = resultSet.getString("login");
		}
		if (resultSet != null)
			resultSet.close();
		if (statement != null)
			statement.close();
		if (connection != null)
			connection.close();
		return ret;
	}

	public void blockUser(String login) throws Exception {
		String sql = "update usuario set bloqueado = '1' where login = '" + login + "';";
		Connection connection = null;

		Statement statement = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		statement.executeUpdate(sql);

		if (statement != null)
			statement.close();

		if (connection != null)
			connection.close();

	}
	
	private String getTodayDate() {
		String ret = null;
		Date todayDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		ret = sdf.format(todayDate);
		return ret;
	}
	
	public void updateLastConection(String login) throws Exception {
		String todayDate = getTodayDate();
		String sql = "update usuario set fechaAcceso = '"+ todayDate +"' where login = '" + login + "';";
		Connection connection = null;

		Statement statement = null;

		Class.forName(DBUtils.DRIVER);

		connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

		statement = connection.createStatement();
		statement.executeUpdate(sql);

		if (statement != null)
			statement.close();

		if (connection != null)
			connection.close();

	}
	
	public List<PremiumUser> getUserPremium(int id) throws Exception{
		ArrayList<PremiumUser> ret = null;
		String sql ="select * from usuario join premium on usuario.id=premium.id where usuario.id="+id+";";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<PremiumUser>();
				PremiumUser premium =PremiumUser.getInstance();
				premium.setName(resultSet.getString("nombre"));
				premium.setFirstSurname(resultSet.getString("apellido1"));
				premium.setSecondSurname(resultSet.getString("apellido2"));
				premium.setBlocked(resultSet.getBoolean("bloqueado"));
				premium.setAdmin(resultSet.getBoolean("esAdministrador"));
				premium.setCardNumber(resultSet.getLong("numTarjeta"));
				premium.setCity(resultSet.getString("ciudad"));
				premium.setExpirationDate(resultSet.getString("caduca"));
				premium.setIdCard(resultSet.getString("dni"));
				premium.setLastAccess(resultSet.getDate("fechaAcceso"));
				premium.setLogin(resultSet.getString("login"));
				premium.setPassword(resultSet.getString("password1"));
				premium.setPostalCode(resultSet.getString("codPostal"));
				premium.setProvince(resultSet.getString("provincia"));
				premium.setRegisterDate(resultSet.getDate("fechaRegistro"));
				premium.setDirection(resultSet.getString("direccion"));
				premium.setUserType(resultSet.getString("tipoUsuario"));
				premium.setCvv(resultSet.getInt("cvv"));
				premium.setBirthday(resultSet.getDate("fechaNacimiento"));				
				ret.add(premium);
			}
				if (resultSet != null)
					resultSet.close();

				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();
			
			return ret;
	
		}
	public List<FreeUser> getUserFree(int id) throws Exception{
		ArrayList<FreeUser> ret = null;
		String sql ="select * from usuario join libre on usuario.id=libre.id where usuario.id="+id+";";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<FreeUser>();
				FreeUser free =FreeUser.getInstance();
			
				free.setName(resultSet.getString("nombre"));
				free.setFirstSurname(resultSet.getString("apellido1"));
				free.setSecondSurname(resultSet.getString("apellido2"));
				free.setBlocked(resultSet.getBoolean("bloqueado"));
				free.setAdmin(resultSet.getBoolean("esAdministrador"));
				free.setLastPlay(resultSet.getDate("ultimaReproduccion"));
				free.setCity(resultSet.getString("ciudad"));
				free.setIdCard(resultSet.getString("dni"));
				free.setLastAccess(resultSet.getDate("fechaAcceso"));
				free.setLogin(resultSet.getString("login"));
				free.setPassword(resultSet.getString("password1"));
				free.setPostalCode(resultSet.getString("codPostal"));
				free.setProvince(resultSet.getString("provincia"));
				free.setRegisterDate(resultSet.getDate("fechaRegistro"));
				free.setDirection(resultSet.getString("direccion"));
				free.setUserType(resultSet.getString("tipoUsuario"));
				free.setBirthday(resultSet.getDate("fechaNacimiento"));				
				ret.add(free);
			}
				if (resultSet != null)
					resultSet.close();

				if (statement != null)
					statement.close();

				if (connection != null)
					connection.close();
			
			return ret;
	
		}

}
