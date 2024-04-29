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

public class GroupPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTextField textFieldReplayAmount;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public GroupPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblNewLabelGroupImage = new JLabel("ImagenGrupo");
		lblNewLabelGroupImage.setBounds(44, 40, 118, 14);
		panel.add(lblNewLabelGroupImage);
		
		JLabel lblNewLabelGroupName = new JLabel("NombreGrupo");
		lblNewLabelGroupName.setBounds(44, 74, 118, 14);
		panel.add(lblNewLabelGroupName);
		
		JLabel lblNewLabelDate = new JLabel("FechaFormacion");
		lblNewLabelDate.setBounds(44, 99, 118, 14);
		panel.add(lblNewLabelDate);
		
		JLabel lblNewLabelDescription = new JLabel("Descripcion");
		lblNewLabelDescription.setBounds(44, 124, 118, 14);
		panel.add(lblNewLabelDescription);
		
		JLabel lblNewLabelReplayAmount = new JLabel("Numero de Reproducciones");
		lblNewLabelReplayAmount.setBounds(44, 212, 131, 14);
		panel.add(lblNewLabelReplayAmount);
		
		textFieldReplayAmount = new JTextField();
		textFieldReplayAmount.setBounds(54, 237, 46, 20);
		panel.add(textFieldReplayAmount);
		textFieldReplayAmount.setColumns(10);
		
		table = new JTable();
		table.setBounds(286, 80, 83, 177);
		panel.add(table);
		
		JLabel lblNewLabelCDList = new JLabel("Lista de Discos");
		lblNewLabelCDList.setBounds(286, 40, 83, 14);
		panel.add(lblNewLabelCDList);
		
		JButton btnNewButtonGoBack = new JButton("Volver");
		btnNewButtonGoBack.setBounds(36, 268, 89, 23);
		btnNewButtonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(5).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(btnNewButtonGoBack);
		
		JButton btnNewButtonProfile = new JButton("Perfil");
		btnNewButtonProfile.setBounds(161, 268, 89, 23);
		btnNewButtonProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(5).setVisible(false);
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