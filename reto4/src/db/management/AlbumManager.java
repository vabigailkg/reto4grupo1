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

import db.pojos.*;
import utils.dbUtils.*;

public class AlbumManager {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;

	public List<Album> obtenerGrupo() {
		ArrayList<Album> ret = null;

		String sql = "select * from disco";

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Album>();

				Album disco = new Album();

				disco.setIdAlbum(resultSet.getInt("id"));
				disco.setIdGroup(resultSet.getInt("idGrupo"));
				disco.setCdImage(resultSet.getString("imagenDisco"));
				disco.setTitle(resultSet.getString("titulo"));
				disco.setDescription(resultSet.getString("descripcion"));
				disco.setPublicationDate(resultSet.getDate("fechaPublicacion"));
				disco.setGenre(resultSet.getString("genero"));

				ret.add(disco);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error generico - " + e.getMessage());
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

	public int getMaxNumber() {
		int ret = 0;
		String sql = "select count(*) from disco";

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				ret = resultSet.getInt(1);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error generico - " + e.getMessage());
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

	public List<Album> getAlbum(Album album) {
		ArrayList<Album> ret = null;
		String sql = "select * from disco where id='" + album.getIdAlbum() + "';";

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);

			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				if (null == ret)
					ret = new ArrayList<Album>();

				album.setIdAlbum(resultSet.getInt("id"));
				album.setIdGroup(resultSet.getInt("idGrupo"));
				album.setCdImage(resultSet.getString("imagenDisco"));
				album.setTitle(resultSet.getString("titulo"));
				album.setDescription(resultSet.getString("descripcion"));
				album.setPublicationDate(resultSet.getDate("fechaPublicacion"));
				album.setGenre(resultSet.getString("genero"));

				ret.add(album);
			}
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error generico - " + e.getMessage());
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

	public List<Album> getAlbumsByGroupId(int groupId) {
		ArrayList<Album> ret = new ArrayList<>();
		String sql = "SELECT * FROM disco WHERE idGrupo = ?";

		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, groupId);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Album album = new Album();
				album.setIdAlbum(resultSet.getInt("id"));
				album.setTitle(resultSet.getString("titulo"));
				ret.add(album);
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

	public Album getGroupInfobyId(int albumId) {
		String sql = "SELECT * FROM disco WHERE id = ?";
		Album album = new Album();
		try {
			Class.forName(DBUtils.DRIVER);
			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, albumId);
			resultSet = preparedStatement.executeQuery();

			// Avanzar al primer registro
			if (resultSet.next()) {
				// Ahora puedes obtener los valores del conjunto de resultados
				album.setIdAlbum(resultSet.getInt("id"));
				album.setIdGroup(resultSet.getInt("idGrupo"));
				album.setCdImage(resultSet.getString("imagenDisco"));
				album.setTitle(resultSet.getString("titulo"));
				album.setDescription(resultSet.getString("descripcion"));
				album.setPublicationDate(resultSet.getDate("fechaPublicacion"));
				album.setGenre(resultSet.getString("genero"));
				album.setNumReproduccion(resultSet.getInt("numReproduccion"));
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
		return album;
	}

}