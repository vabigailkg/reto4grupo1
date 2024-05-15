package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class PodcastPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTable tableGroups;
	private JTable tableAlbums;
	private JTable tableSongPick;

	/**
	 * Create the panel.
	 */
	public PodcastPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblNewLabelPodcasterImage = new JLabel("ImagenPodcaster");
		lblNewLabelPodcasterImage.setBounds(251, 36, 118, 14);
		panel.add(lblNewLabelPodcasterImage);
		
		JLabel lblNewLabelPodcasterName = new JLabel("NombrePodcaster");
		lblNewLabelPodcasterName.setBounds(379, 36, 118, 14);
		panel.add(lblNewLabelPodcasterName);
		
		JLabel lblNewLabelPodcasterDate = new JLabel("FechaUnion");
		lblNewLabelPodcasterDate.setBounds(379, 61, 118, 14);
		panel.add(lblNewLabelPodcasterDate);
		
		JLabel lblNewLabelPodcasterDescription = new JLabel("Descripcion");
		lblNewLabelPodcasterDescription.setBounds(379, 86, 118, 14);
		panel.add(lblNewLabelPodcasterDescription);
		
		JLabel lblNewLabelPodcasterReplayAmount = new JLabel("Numero de Reproducciones");
		lblNewLabelPodcasterReplayAmount.setBounds(379, 111, 131, 14);
		panel.add(lblNewLabelPodcasterReplayAmount);
		
		JLabel lblNewLabelSeriesList = new JLabel("ELIGE SERIE");
		lblNewLabelSeriesList.setBounds(251, 184, 83, 14);
		panel.add(lblNewLabelSeriesList);
		
		JButton buttonGoBack = new JButton("Volver");
		buttonGoBack.setBounds(44, 273, 89, 23);
		buttonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(12).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(buttonGoBack);
		
		JButton buttonProfile = new JButton("Perfil");
		buttonProfile.setBounds(44, 303, 89, 23);
		buttonProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(12).setVisible(false);
				panels.get(13).setVisible(true);
			}
		});
		panel.add(buttonProfile);
		
		panel.setLayout(null);
		
		JLabel lblNewLabelPickPodcaster = new JLabel("ELIGE PODCASTER");
		lblNewLabelPickPodcaster.setBounds(44, 26, 118, 14);
		panel.add(lblNewLabelPickPodcaster);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 60, 149, 194);
		panel.add(scrollPane);
		
		tableGroups = new JTable();
		tableGroups.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		scrollPane.setViewportView(tableGroups);
		
		JButton buttonPlay = new JButton("Reproducir");
		buttonPlay.setBounds(44, 337, 89, 23);
		panel.add(buttonPlay);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(251, 209, 118, 151);
		panel.add(scrollPane_1);
		
		tableAlbums = new JTable();
		tableAlbums.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		scrollPane_1.setViewportView(tableAlbums);
		
		JLabel lblNewLabelSeriesTitle = new JLabel("NombreSerie");
		lblNewLabelSeriesTitle.setBounds(483, 184, 83, 14);
		panel.add(lblNewLabelSeriesTitle);
		
		JLabel lblNewLabelSeriesTheme = new JLabel("Tematica");
		lblNewLabelSeriesTheme.setBounds(483, 209, 70, 14);
		panel.add(lblNewLabelSeriesTheme);
		
		JLabel lblNewLabelFirstPodcastDate = new JLabel("FechaPrimerPodcast");
		lblNewLabelFirstPodcastDate.setBounds(483, 234, 118, 14);
		panel.add(lblNewLabelFirstPodcastDate);
		
		JLabel lblNewLabelEndSeries = new JLabel("FechaFinSerie");
		lblNewLabelEndSeries.setBounds(483, 259, 83, 14);
		panel.add(lblNewLabelEndSeries);
		
		JLabel lblNewLabelPodcastPick = new JLabel("ELIGE PODCAST");
		lblNewLabelPodcastPick.setBounds(251, 405, 83, 14);
		panel.add(lblNewLabelPodcastPick);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(251, 440, 118, 125);
		panel.add(scrollPane_2);
		
		tableSongPick = new JTable();
		tableSongPick.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column"
			}
		));
		scrollPane_2.setViewportView(tableSongPick);
		
		JLabel lblNewLabelPodcastDescription = new JLabel("DescripcionPodcast");
		lblNewLabelPodcastDescription.setBounds(483, 441, 118, 14);
		panel.add(lblNewLabelPodcastDescription);
		
		JLabel lblNewLabelPodcastViews = new JLabel("ReproduccionesPodcast");
		lblNewLabelPodcastViews.setBounds(483, 475, 118, 14);
		panel.add(lblNewLabelPodcastViews);

	}
	public JPanel getPanel() {
		return panel;
	}
}