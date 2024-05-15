package panelControllers;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db.management.AlbumManager;
import db.management.ContentManager;
import db.management.GroupManager;
import db.pojos.Album;
import db.pojos.Group;
import db.pojos.Song;

public class GroupPanelController {

	/**
	 * Llena la tabla del panel con las grupos
	 * 
	 * @param panels panel en el que esta la tabla
	 * @param tabla  que queremos llenar
	 * @return tabla rellena
	 */
	public DefaultTableModel llenarTablagrupos(ArrayList<JPanel> panels, JTable tabla) {
		DefaultTableModel ret = null;
		GroupManager groupManager = new GroupManager();
		ArrayList<Group> listaGrupos = (ArrayList<Group>) groupManager.getGroup();

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idGroup");
		tableModel.addColumn("Nombre");

		// Iterar sobre la lista de grupos y agregarlos a la tabla
		for (Group grupo : listaGrupos) {
			Object[] fila = { grupo.getIdGroup(), // Añadir el id del grupo al modelo interno
					grupo.getName(), };
			tableModel.addRow(fila);
		}

		tabla.setModel(tableModel);
		tabla.repaint();

		// Ocultar la primera columna (idGroup) en la tabla visual
		tabla.getColumnModel().getColumn(0).setMinWidth(0);
		tabla.getColumnModel().getColumn(0).setMaxWidth(0);
		tabla.getColumnModel().getColumn(0).setWidth(0);

		ret = tableModel;
		return ret;
	}

	public Group obtenerInformacionGrupo(String groupName) {
		Group grupo =new Group();
		GroupManager groupManager = new GroupManager();
		grupo = groupManager.getGroupInfo(groupName);
		return grupo;
	}

	public DefaultTableModel llenarTablaDiscos(ArrayList<JPanel> panels, JTable tableAlbums, int idGroup) {
		DefaultTableModel ret = null;
		AlbumManager albumManager = new AlbumManager();
		ArrayList<Album> listaAlbums = (ArrayList<Album>) albumManager.getAlbumsByGroupId(idGroup);

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idGroup");
		tableModel.addColumn("Nombre");

		// Iterar sobre la lista de grupos y agregarlos a la tabla
		for (Album album : listaAlbums) {
			Object[] fila = { album.getIdAlbum(), // Añadir el id del grupo al modelo interno
					album.getTitle(), };
			tableModel.addRow(fila);
		}

		tableAlbums.setModel(tableModel);
		tableAlbums.repaint();

		// Ocultar la primera columna (idGroup) en la tabla visual
		tableAlbums.getColumnModel().getColumn(0).setMinWidth(0);
		tableAlbums.getColumnModel().getColumn(0).setMaxWidth(0);
		tableAlbums.getColumnModel().getColumn(0).setWidth(0);

		ret = tableModel;
		return ret;
	}

	public Album obtenerDiscoPorTitulo(int albumId) {
		Album album = new Album();
		AlbumManager albumManager = new AlbumManager();
		album = albumManager.getGroupInfobyId(albumId);
		return album;
	}

	public DefaultTableModel llenarTablaCanciones(ArrayList<JPanel> panels, JTable tableSongPick, int albumId) {
		DefaultTableModel ret = null;
		ContentManager contentManager = new ContentManager();
		ArrayList<Song> listaCanciones = (ArrayList<Song>) contentManager.getContentByAlbunId(albumId);

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idGroup");
		tableModel.addColumn("Nombre");

		// Iterar sobre la lista de grupos y agregarlos a la tabla
		for (Song cancion : listaCanciones) {
			Object[] fila = { cancion.getIdContent(), // Añadir el id del grupo al modelo interno
					cancion.getTitle(), };
			tableModel.addRow(fila);
		}

		tableSongPick.setModel(tableModel);
		tableSongPick.repaint();

		// Ocultar la primera columna (idGroup) en la tabla visual
		tableSongPick.getColumnModel().getColumn(0).setMinWidth(0);
		tableSongPick.getColumnModel().getColumn(0).setMaxWidth(0);
		tableSongPick.getColumnModel().getColumn(0).setWidth(0);

		ret = tableModel;
		return ret;
	}

	public Song obtenerCancionPorId(int songId) {
		Song cancion = new Song();
		ContentManager groupSong = new ContentManager();
		cancion = groupSong.getContentBySonId(songId);
		return cancion;
	}

}