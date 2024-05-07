package db.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

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

}
