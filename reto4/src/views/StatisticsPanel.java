package views;

import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class StatisticsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTable tableCDSeriesMostListened;
	private JTable tableFavSongsPodcast;
	private JTable tableSongsPodcastMostListened;
	private JTable tableGroupsPodcastersMostListened;

	/**
	 * Create the panel.
	 */
	public StatisticsPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblNewLabelFavSongsPodcast = new JLabel("10 canciones/podcast favoritos");
		lblNewLabelFavSongsPodcast.setBounds(33, 11, 161, 34);
		panel.add(lblNewLabelFavSongsPodcast);
		
		JLabel lblNewLabelSongsPodcastMostListened = new JLabel("10 canciones/podcast mas oidos");
		lblNewLabelSongsPodcastMostListened.setBounds(234, 11, 161, 34);
		panel.add(lblNewLabelSongsPodcastMostListened);
		
		JLabel lblNewLabelCDSeriesMostListened = new JLabel("10 discos/series mas oidos");
		lblNewLabelCDSeriesMostListened.setBounds(33, 155, 161, 34);
		panel.add(lblNewLabelCDSeriesMostListened);
		
		JLabel lblNewLabelGroupsPodcastersMostListened = new JLabel("10 grupos/podcasters mas oidos");
		lblNewLabelGroupsPodcastersMostListened.setBounds(234, 155, 161, 34);
		panel.add(lblNewLabelGroupsPodcastersMostListened);
		
		tableCDSeriesMostListened = new JTable();
		tableCDSeriesMostListened.setBounds(33, 189, 126, 100);
		panel.add(tableCDSeriesMostListened);
		
		tableFavSongsPodcast = new JTable();
		tableFavSongsPodcast.setBounds(33, 45, 126, 100);
		panel.add(tableFavSongsPodcast);
		
		tableSongsPodcastMostListened = new JTable();
		tableSongsPodcastMostListened.setBounds(244, 45, 126, 100);
		panel.add(tableSongsPodcastMostListened);
		
		tableGroupsPodcastersMostListened = new JTable();
		tableGroupsPodcastersMostListened.setBounds(244, 189, 126, 100);
		panel.add(tableGroupsPodcastersMostListened);
		
		JButton btnNewButtonGoBack = new JButton("Volver");
		btnNewButtonGoBack.setBounds(36, 368, 89, 23);
		btnNewButtonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(18).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(btnNewButtonGoBack);
		
		JButton btnNewButtonProfile = new JButton("Perfil");
		btnNewButtonProfile.setBounds(161, 368, 89, 23);
		btnNewButtonProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(18).setVisible(false);
				panels.get(13).setVisible(true);
			}
		});
		panel.add(btnNewButtonProfile);
		
		panel.setLayout(null);

	}
	public JPanel getPanel() {
		return panel;
	}

}
