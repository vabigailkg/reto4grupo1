package views;

import db.management.*;
import panelControllers.SongPanelController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PlayPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	public static final String THE_IMAGE_FILE = new File("").getAbsolutePath() + "\\src\\img\\choco.jpg";
    private SongPanelController controlador=null;
	
	/**
	 * Create the panel.
	 */
	public PlayPanel(ArrayList<JPanel> panels) {
		
		controlador=new SongPanelController();
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JButton btnNewButtonPlay = new JButton("PLAY");
		btnNewButtonPlay.setBounds(214, 197, 60, 30);
		btnNewButtonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.play();
			}
		});
		panel.add(btnNewButtonPlay);

		JButton btnNewButtonPrevious = new JButton("PREV");
		btnNewButtonPrevious.setBounds(40, 200, 100, 25);
		btnNewButtonPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.playPreviousSong();
			}
		});
		panel.add(btnNewButtonPrevious);

		JButton btnNewButtonNext = new JButton("NEXT");
		btnNewButtonNext.setBounds(420, 200, 100, 25);
		btnNewButtonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.playNextSong();
			}
		});
		panel.add(btnNewButtonNext);

		JButton btnNewButtonFavorites = new JButton("Favorito");
		btnNewButtonFavorites.setBounds(230, 246, 100, 25);
		panel.add(btnNewButtonFavorites);

		JButton btnNewButtonGoBack = new JButton("Volver");
		btnNewButtonGoBack.setBounds(40, 250, 100, 25);
		btnNewButtonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(10).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(btnNewButtonGoBack);

		JButton btnNewButtonProfile = new JButton("Perfil");
		btnNewButtonProfile.setBounds(420, 250, 100, 25);
		btnNewButtonProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(10).setVisible(false);
				panels.get(13).setVisible(true);
			}
		});
		panel.add(btnNewButtonProfile);

		panel.setLayout(null);

		JButton btnNewButtonStop = new JButton("STOP");
		btnNewButtonStop.setBounds(285, 197, 60, 30);
		btnNewButtonStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.stop();
			}
		});
		panel.add(btnNewButtonStop);

		JLabel lblNewLabel = new JLabel("image");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(215, 60, 130, 100);
		panel.add(lblNewLabel);

		lblNewLabel.setIcon(new ImageIcon(THE_IMAGE_FILE));

	}

	public JPanel getPanel() {
		return panel;
	}
	
}