package views;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class GroupsManagementPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTextField textFieldName;

	/**
	 * Create the panel.
	 */
	public GroupsManagementPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JButton btnNewButtonCreate = new JButton("Crear");
		btnNewButtonCreate.setBounds(68, 72, 89, 23);
		panel.add(btnNewButtonCreate);
		
		JButton btnNewButtonModify = new JButton("Modificar");
		btnNewButtonModify.setBounds(68, 127, 89, 23);
		panel.add(btnNewButtonModify);
		
		JButton btnNewButtonRemove = new JButton("Borrar");
		btnNewButtonRemove.setBounds(68, 188, 89, 23);
		panel.add(btnNewButtonRemove);
		
		panel.setLayout(null);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(203, 128, 86, 20);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabelName = new JLabel("Nombre");
		lblNewLabelName.setBounds(222, 103, 46, 14);
		panel.add(lblNewLabelName);

	}
	public JPanel getPanel() {
		return panel;
	}
}