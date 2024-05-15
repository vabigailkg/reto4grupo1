package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import db.pojos.Group;
import panelControllers.GroupPanelController;
import panelControllers.StatisticsPanelController;

public class StatisticsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTable tableAuthor;
	private JTable tableContent;
	private JTable tableAgrupation;

	/**
	 * Create the panel.
	 */
	public StatisticsPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblNewLabelSongsPodcastMostListened = new JLabel("10 canciones/podcast mas oidos");
		lblNewLabelSongsPodcastMostListened.setBounds(60, 19, 170, 30);
		panel.add(lblNewLabelSongsPodcastMostListened);
		
		JLabel lblNewLabelCDSeriesMostListened = new JLabel("10 discos/series mas oidos");
		lblNewLabelCDSeriesMostListened.setBounds(451, 19, 170, 30);
		panel.add(lblNewLabelCDSeriesMostListened);
		
		JLabel lblNewLabelGroupsPodcastersMostListened = new JLabel("10 grupos/podcasters mas oidos");
		lblNewLabelGroupsPodcastersMostListened.setBounds(255, 19, 170, 30);
		panel.add(lblNewLabelGroupsPodcastersMostListened);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 60, 150, 200);
		panel.add(scrollPane);

		// Creamos la tabla de grupos y la asignamos a tableGroups
		tableContent = new JTable();
		tableContent.setCellSelectionEnabled(true);
		scrollPane.setViewportView(tableContent);
		
		// Recuperamos y pintamos los datos de los grupos en la tabla
		llenarTablacontent(panels);
		scrollPane.setViewportView(tableContent);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(270, 60, 150, 200);
		panel.add(scrollPane2);
		
		tableAgrupation = new JTable();
		tableAgrupation.setCellSelectionEnabled(true);
		scrollPane2.setViewportView(tableAgrupation);
		
		llenarTablaAgrupation(panels);
		scrollPane2.setViewportView(tableAgrupation);
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(460, 60, 150, 200);
		panel.add(scrollPane3);
		
		tableAuthor = new JTable();
		tableAuthor.setCellSelectionEnabled(true);
		scrollPane3.setViewportView(tableAuthor);
		llenarTablaAuthor(panels);
		scrollPane3.setViewportView(tableAuthor);


		
		JButton btnNewButtonGoBack = new JButton("Volver");
		btnNewButtonGoBack.setBounds(191, 331, 89, 23);
		btnNewButtonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(18).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(btnNewButtonGoBack);
		
		JButton btnNewButtonProfile = new JButton("Perfil");
		btnNewButtonProfile.setBounds(388, 331, 89, 23);
		btnNewButtonProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(18).setVisible(false);
				panels.get(13).setVisible(true);
			}
		});
		panel.add(btnNewButtonProfile);
		
		panel.setLayout(null);
		
		tableContent.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = tableContent.getSelectedRow();
					if (selectedRow != -1) { // Verificar si se seleccionó una fila válida
						Integer groupId = Integer.parseInt(tableContent.getValueAt(selectedRow, 0).toString());
						String groupName = (String) tableContent.getValueAt(selectedRow, 1);
						

					}
				}
			}
		});
	}
	// Método para llenar la tabla de grupos
		private void llenarTablacontent(ArrayList<JPanel> panels) {
			DefaultTableModel tableModel = new DefaultTableModel();
			tableModel.addColumn("titulo");
			tableModel.addColumn("Reproducciones");

			// Llenar la tabla con los datos de los grupos
			StatisticsPanelController funcionalidades = new StatisticsPanelController();
			tableModel = funcionalidades.llenarTablaContent(panels, tableContent);

			// Asignar el modelo de la tabla
			tableContent.setModel(tableModel);
			tableContent.repaint();
		}
		private void llenarTablaAgrupation(ArrayList<JPanel> panels) {
			DefaultTableModel tableModel = new DefaultTableModel();
			tableModel.addColumn("Titulo");
			tableModel.addColumn("Reproducciones");

			// Llenar la tabla con los datos de los grupos
			StatisticsPanelController funcionalidades = new StatisticsPanelController();
			tableModel = funcionalidades.llenarTablaagrupation(panels, tableAgrupation);

			// Asignar el modelo de la tabla
			tableContent.setModel(tableModel);
			tableContent.repaint();
		}
		private void llenarTablaAuthor(ArrayList<JPanel> panels) {
			DefaultTableModel tableModel = new DefaultTableModel();
			tableModel.addColumn("Titulo");
			tableModel.addColumn("Reproducciones");

			// Llenar la tabla con los datos de los grupos
			StatisticsPanelController funcionalidades = new StatisticsPanelController();
			tableModel = funcionalidades.llenarTablaAutores(panels, tableAuthor);

			// Asignar el modelo de la tabla
			tableContent.setModel(tableModel);
			tableContent.repaint();
		}
	
	public JPanel getPanel() {
		return panel;
	}

}
