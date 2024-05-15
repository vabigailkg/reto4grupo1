package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;

import javax.swing.JButton;

public class SongPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;

	/**
	 * Create the panel.
	 */
	public SongPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnNewButtonPlay = new JButton("Reproducir");
		btnNewButtonPlay.setBounds(320, 355, 89, 23);
		panel.add(btnNewButtonPlay);
		
		JButton btnNewButtonGoBack = new JButton("Volver");
		btnNewButtonGoBack.setBounds(198, 450, 89, 23);
		panel.add(btnNewButtonGoBack);
		
		JButton btnNewButtonProfile = new JButton("Perfil");
		btnNewButtonProfile.setBounds(458, 450, 89, 23);
		panel.add(btnNewButtonProfile);
		
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Anterior");
		btnNewButton.setBounds(176, 355, 89, 23);
		panel.add(btnNewButton);

	}
	public JPanel getPanel() {
		return panel;
	}
}
