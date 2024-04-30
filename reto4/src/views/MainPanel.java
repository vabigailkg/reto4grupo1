package views;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import management.AlbumManager;
import pojos.Album;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private Album album;
	public AlbumManager albumManager=null;
	/**
	 * Create the panel.
	 */
	public MainPanel(ArrayList<JPanel> panels) {
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		album=new Album();
		albumManager=new AlbumManager();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 450, 300);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		albumManager.obtenerAlbumAleatorio();
		
		JButton btnNewButtonGroups = new JButton("Descubre Grupos");
		btnNewButtonGroups.setBounds(268, 66, 138, 23);
		btnNewButtonGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(8).setVisible(false);
				panels.get(5).setVisible(true);
			}
		});
		panel_1.add(btnNewButtonGroups);
		
		JButton btnNewButtonPodcast = new JButton("Descubre Podcast");
		btnNewButtonPodcast.setBounds(268, 100, 138, 23);
		btnNewButtonPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(8).setVisible(false);
				panels.get(10).setVisible(true);
			}
		});
		panel_1.add(btnNewButtonPodcast);
		
		JButton btnNewButtonFavorites = new JButton("Mis Favoritos");
		btnNewButtonFavorites.setBounds(268, 134, 138, 23);
		btnNewButtonFavorites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(8).setVisible(false);
				panels.get(4).setVisible(true);
			}
		});
		panel_1.add(btnNewButtonFavorites);
		
		JButton btnNewButtonProfile = new JButton("Perfil");
		btnNewButtonProfile.setBounds(268, 168, 138, 23);
		btnNewButtonProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(8).setVisible(false);
				panels.get(13).setVisible(true);
			}
		});
		panel_1.add(btnNewButtonProfile);
		
		JButton btnNewButtonExit = new JButton("Salir");
		btnNewButtonExit.setBounds(268, 202, 138, 23);
		btnNewButtonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(8).setVisible(false);
				panels.get(1).setVisible(true);
			}
		});
		panel_1.add(btnNewButtonExit);
		
		JLabel lblNewLabelGroupImage = new JLabel("image");
		lblNewLabelGroupImage.setBounds(79, 104, 100, 20);
		panel_1.add(lblNewLabelGroupImage);
		
		JLabel lblNewLabelGroupName = new JLabel("idGrupo");
		lblNewLabelGroupName.setBounds(79, 70, 100, 20);
		panel_1.add(lblNewLabelGroupName);
		
		JLabel lblNewLabelCDTitle = new JLabel();
		lblNewLabelCDTitle.setText(album.getTitle()+"");
		lblNewLabelCDTitle.setBounds(79, 138, 100, 20);
		panel_1.add(lblNewLabelCDTitle);
		
		JLabel lblNewLabelCDDate = new JLabel("getPublicationDate()");
		lblNewLabelCDDate.setBounds(81, 172, 100, 20);
		panel_1.add(lblNewLabelCDDate);
		
		JLabel lblNewLabelCDGenre = new JLabel("getGenre()");
		lblNewLabelCDGenre.setBounds(79, 206, 100, 20);
		panel_1.add(lblNewLabelCDGenre);
		
		JButton btnNewButtonGroupManagement = new JButton("Gestionar Grupos");
		btnNewButtonGroupManagement.setBounds(79, 266, 89, 23);
		btnNewButtonGroupManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(8).setVisible(false);
				panels.get(6).setVisible(true);
			}
		});
		panel_1.add(btnNewButtonGroupManagement);
		
		JButton btnNewButtonStatisticConsult = new JButton("Consultar Estadisticas");
		btnNewButtonStatisticConsult.setBounds(269, 266, 89, 23);
		btnNewButtonStatisticConsult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(8).setVisible(false);
				panels.get(18).setVisible(true);
			}
		});
		panel_1.add(btnNewButtonStatisticConsult);
		
		JLabel lblNewLabelAdministrationFunction = new JLabel("Funciones de administrador");
		lblNewLabelAdministrationFunction.setBounds(158, 241, 138, 14);
		panel_1.add(lblNewLabelAdministrationFunction);
		
		panel.setLayout(null);

	}
	public JPanel getPanel() {
		return panel;
	}
}