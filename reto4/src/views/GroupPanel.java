package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import db.pojos.Album;
import db.pojos.Group;
import db.pojos.Song;
import panelControllers.GroupPanelController;

public class GroupPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTable tableGroups;
	private JTable tableAlbums;
	private JTable tableSongPick;
	private DefaultTableModel tableModelGroups = null;
	private JLabel lblNewLabelGroupImage;
	private JLabel lblNewLabelGroupName;
	private JLabel lblNewLabelDate;
	private JLabel lblNewLabelDescription;
	private JLabel lblNewLabelReplayAmount;
	private JLabel lblNewLabelCDList;
	private JLabel lblNewLabelAlbum;
	private JLabel lblNewLabelAlbumTitle;
	private JLabel lblNewLabelAlbumDate;
	private JLabel lblNewLabelAlbumGender;
	private JLabel lblNewLabelAlbumDescription;
	private JLabel lblNewLabelAlbumViews;
	private JLabel lblNewLabelSongName;
	private JLabel lblNewLabelSongLength;
	private JLabel lblNewLabelSongViews;

	/**
	 * Create the panel.
	 */
	public GroupPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		lblNewLabelGroupImage = new JLabel("ImagenGrupo");
		lblNewLabelGroupImage.setBounds(251, 36, 118, 14);
		panel.add(lblNewLabelGroupImage);

		lblNewLabelGroupName = new JLabel("NombreGrupo");
		lblNewLabelGroupName.setBounds(379, 36, 118, 14);
		panel.add(lblNewLabelGroupName);

		lblNewLabelDate = new JLabel("FechaFormacion");
		lblNewLabelDate.setBounds(379, 61, 118, 14);
		panel.add(lblNewLabelDate);

		lblNewLabelDescription = new JLabel("Descripcion");
		lblNewLabelDescription.setBounds(379, 86, 118, 14);
		panel.add(lblNewLabelDescription);

		lblNewLabelReplayAmount = new JLabel("Numero de Reproducciones");
		lblNewLabelReplayAmount.setBounds(379, 111, 131, 14);
		panel.add(lblNewLabelReplayAmount);

		lblNewLabelCDList = new JLabel("ELIGE DISCO");
		lblNewLabelCDList.setBounds(251, 184, 83, 14);
		panel.add(lblNewLabelCDList);

		JButton buttonGoBack = new JButton("Volver");
		buttonGoBack.setBounds(44, 273, 89, 23);
		buttonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(5).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(buttonGoBack);

		JButton buttonProfile = new JButton("Perfil");
		buttonProfile.setBounds(44, 303, 89, 23);
		buttonProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(5).setVisible(false);
				panels.get(13).setVisible(true);
			}
		});
		panel.add(buttonProfile);

		panel.setLayout(null);

		JLabel lblNewLabelPickGroup = new JLabel("ELIGE GRUPO");
		lblNewLabelPickGroup.setBounds(44, 26, 89, 14);
		panel.add(lblNewLabelPickGroup);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 60, 149, 194);
		panel.add(scrollPane);

		// Creamos la tabla de grupos y la asignamos a tableGroups
		tableGroups = new JTable();
		tableGroups.setCellSelectionEnabled(true);
		scrollPane.setViewportView(tableGroups);

		// Recuperamos y pintamos los datos de los grupos en la tabla
		llenarTablaGrupos(panels);
		scrollPane.setViewportView(tableGroups);

		JButton buttonPlay = new JButton("Reproducir");
		buttonPlay.setBounds(44, 337, 89, 23);
		buttonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panels.get(5).setVisible(false);
				panels.get(10).setVisible(true);
			}
		});
		panel.add(buttonPlay);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(251, 209, 118, 151);
		panel.add(scrollPane_1);

		tableAlbums = new JTable();
		tableAlbums.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column" }));
		scrollPane_1.setViewportView(tableAlbums);

		lblNewLabelAlbum = new JLabel("ImagenDisco");
		lblNewLabelAlbum.setBounds(379, 184, 83, 14);
		panel.add(lblNewLabelAlbum);

		lblNewLabelAlbumTitle = new JLabel("NombreDisco");
		lblNewLabelAlbumTitle.setBounds(483, 184, 83, 14);
		panel.add(lblNewLabelAlbumTitle);

		lblNewLabelAlbumDate = new JLabel("FechaDisco");
		lblNewLabelAlbumDate.setBounds(483, 209, 70, 14);
		panel.add(lblNewLabelAlbumDate);

		lblNewLabelAlbumGender = new JLabel("GeneroDisco");
		lblNewLabelAlbumGender.setBounds(483, 234, 70, 14);
		panel.add(lblNewLabelAlbumGender);

		lblNewLabelAlbumDescription = new JLabel("DescripcionDisco");
		lblNewLabelAlbumDescription.setBounds(483, 259, 83, 14);
		panel.add(lblNewLabelAlbumDescription);

		lblNewLabelAlbumViews = new JLabel("ReproduccionesDisco");
		lblNewLabelAlbumViews.setBounds(483, 284, 101, 14);
		panel.add(lblNewLabelAlbumViews);

		JLabel lblNewLabelSongPick = new JLabel("ELIGE CANCION");
		lblNewLabelSongPick.setBounds(251, 405, 83, 14);
		panel.add(lblNewLabelSongPick);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(251, 440, 118, 125);
		panel.add(scrollPane_2);

		tableSongPick = new JTable();
		tableSongPick.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column" }));
		scrollPane_2.setViewportView(tableSongPick);

		lblNewLabelSongName = new JLabel("NombreCancion");
		lblNewLabelSongName.setBounds(483, 405, 83, 14);
		panel.add(lblNewLabelSongName);

		lblNewLabelSongLength = new JLabel("DuracionCancion");
		lblNewLabelSongLength.setBounds(483, 441, 83, 14);
		panel.add(lblNewLabelSongLength);

		lblNewLabelSongViews = new JLabel("ReproduccionesCancion");
		lblNewLabelSongViews.setBounds(483, 475, 118, 14);
		panel.add(lblNewLabelSongViews);

		// Agregar ListSelectionListener a la tabla de grupos
		tableGroups.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = tableGroups.getSelectedRow();
					if (selectedRow != -1) { // Verificar si se seleccionó una fila válida
						Integer groupId = Integer.parseInt(tableGroups.getValueAt(selectedRow, 0).toString());
						String groupName = (String) tableGroups.getValueAt(selectedRow, 1);
						// Limpiar los datos de la información de discos
						lblNewLabelAlbum.setText("");
						lblNewLabelAlbumTitle.setText("");
						lblNewLabelAlbumDate.setText("");
						lblNewLabelAlbumGender.setText("");
						lblNewLabelAlbumDescription.setText("");
						lblNewLabelAlbumViews.setText("");

						// Limpiar los datos de la tabla de canciones
						DefaultTableModel emptySongTableModel = new DefaultTableModel();
						tableSongPick.setModel(emptySongTableModel);

						// Limpiar los datos de la información de canciones
						lblNewLabelSongName.setText("");
						lblNewLabelSongLength.setText("");
						lblNewLabelSongViews.setText("");

						// Desactivar el boton reproducir
						buttonPlay.setEnabled(false);

						// Llamamos al método para cargar la información del grupo seleccionado
						cargarInformacionGrupo(groupName);

						// Llamamos al método para cargar la tabla de discos del grupo seleccionado
						cargarTablaDiscos(panels, groupId);
					}
				}
			}
		});

		// Agregar ListSelectionListener a la tabla de discos
		tableAlbums.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = tableAlbums.getSelectedRow();
					if (selectedRow != -1) { // Verificar si se seleccionó una fila válida
						int albumId = (int) tableAlbums.getValueAt(selectedRow, 0);
						// Limpiar los datos de la tabla de canciones
						DefaultTableModel emptySongTableModel = new DefaultTableModel();
						tableSongPick.setModel(emptySongTableModel);

						// Limpiar los datos de la información de canciones
						lblNewLabelSongName.setText("");
						lblNewLabelSongLength.setText("");
						lblNewLabelSongViews.setText("");
						// Llamamos al método para cargar la información del disco seleccionado
						cargarInformacionDisco(albumId);
						// Desactivar el boton reproducir
						buttonPlay.setEnabled(false);

						// Llamamos al método para cargar la tabla de canciones del grupo seleccionado
						cargarTablaCanciones(panels, albumId);
					}
				}
			}
		});

		// Agregar ListSelectionListener a la tabla de canciones
		tableSongPick.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = tableSongPick.getSelectedRow();
					if (selectedRow != -1) { // Verificar si se seleccionó una fila válida
						// Obtener los datos de la canción seleccionada
						int songId = (int) tableSongPick.getValueAt(selectedRow, 0);

						// Llamar al método para cargar la información de la canción seleccionada
						cargarInformacionCancion(songId);
						// Desactivar el boton reproducir
						buttonPlay.setEnabled(true);
					}
				}
			}
		});

	}

	// Método para llenar la tabla de grupos
	private void llenarTablaGrupos(ArrayList<JPanel> panels) {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idGrupo");
		tableModel.addColumn("Nombre");

		// Llenar la tabla con los datos de los grupos
		GroupPanelController funcionalidades = new GroupPanelController();
		tableModel = funcionalidades.llenarTablagrupos(panels, tableGroups);

		// Asignar el modelo de la tabla
		tableGroups.setModel(tableModel);
		tableGroups.repaint();
	}

	// Método para llenar la informacion sobre la tabla Grupos
	private void cargarInformacionGrupo(String groupName) {

		GroupPanelController funcionalidades = new GroupPanelController();
		Group grupo = funcionalidades.obtenerInformacionGrupo(groupName);

		try {
			// Verificar si se recuperó la información del grupo
			if (grupo != null) {
				// Convertir el Date a una cadena de texto usando un formato SimpleDateFormat
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				String fechaFormacionStr = dateFormat.format(grupo.getCreationDate());

				// Actualizar los JLabels con la información del grupo seleccionado
				lblNewLabelGroupImage.setText(grupo.getImagen() != null ? grupo.getImagen() : "");
				lblNewLabelGroupName.setText(grupo.getName() != null ? grupo.getName() : "");
				lblNewLabelDate.setText(fechaFormacionStr != null ? fechaFormacionStr : "");
				lblNewLabelDescription.setText(grupo.getDescription() != null ? grupo.getDescription() : "");
				lblNewLabelReplayAmount.setText(Integer.toString(grupo.getNumReproduccion()));
			}
		} catch (Exception e) {
			// Manejar el error mostrando un mensaje al usuario
			JOptionPane.showMessageDialog(null, "Error al cargar la información del grupo: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cargarTablaDiscos(ArrayList<JPanel> panels, int idGroup) {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idDisco");
		tableModel.addColumn("titulo");

		// Llenar la tabla con los datos de los Discos
		GroupPanelController funcionalidades = new GroupPanelController();
		tableModel = funcionalidades.llenarTablaDiscos(panels, tableAlbums, idGroup);

		// Asignar el modelo de la tabla
		tableAlbums.setModel(tableModel);
		tableAlbums.repaint();
	}

	// Método para llenar la informacion sobre la tabla Grupos
	protected void cargarInformacionDisco(int albumId) {
		// Llamar al método para obtener la información del disco con el título dado
		GroupPanelController funcionalidades = new GroupPanelController();
		Album disco = funcionalidades.obtenerDiscoPorTitulo(albumId);
		try {
			if (disco != null) {
				// Actualizar los JLabels con la información del disco seleccionado
				lblNewLabelAlbum.setText(disco.getCdImage() != null ? disco.getCdImage() : "");
				lblNewLabelAlbumTitle.setText(disco.getTitle() != null ? disco.getTitle() : "");
				lblNewLabelAlbumDate
						.setText(disco.getPublicationDate() != null ? disco.getPublicationDate().toString() : "");
				lblNewLabelAlbumGender.setText(disco.getGenre() != null ? disco.getGenre() : "");
				lblNewLabelAlbumDescription.setText(disco.getDescription() != null ? disco.getDescription() : "");
				lblNewLabelAlbumViews.setText(Integer.toString(disco.getNumReproduccion()));
			}
		} catch (Exception e) {
			// Manejar el error mostrando un mensaje al usuario
			JOptionPane.showMessageDialog(null, "Error al cargar la información del disco: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void cargarTablaCanciones(ArrayList<JPanel> panels, int albumId) {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("id");
		tableModel.addColumn("titulo");

		// Llenar la tabla con los datos de los Discos
		GroupPanelController funcionalidades = new GroupPanelController();
		tableModel = funcionalidades.llenarTablaCanciones(panels, tableSongPick, albumId);

		// Asignar el modelo de la tabla
		tableSongPick.setModel(tableModel);
		tableSongPick.repaint();

	}

	// Método para cargar la información de la canción seleccionada
	private void cargarInformacionCancion(int songId) {
		// Llamar al método para obtener la información del disco con el título dado
		GroupPanelController funcionalidades = new GroupPanelController();
		Song cancion = funcionalidades.obtenerCancionPorId(songId);
		try {
			// Verificar si se recuperó la información de la canción
			if (cancion != null) {
				// Actualizar los JLabels con la información de la canción seleccionada
				lblNewLabelSongName.setText(cancion.getTitle() != null ? cancion.getTitle() : "");
				lblNewLabelSongLength.setText(cancion.getDuration() != null ? cancion.getDuration() : "");
				lblNewLabelSongViews.setText(Integer.toString(cancion.getPlayAmount()));
			}
		} catch (Exception e) {
			// Manejar el error mostrando un mensaje al usuario
			JOptionPane.showMessageDialog(null, "Error al cargar la información de la canción: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public JPanel getPanel() {
		return panel;
	}
}