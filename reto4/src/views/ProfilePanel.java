   package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ProfilePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTextField textFieldName;
	private JTextField textFieldFirstSurname;
	private JTextField textFieldSecondSurname;
	private JTextField textFieldIDCard;
	private JTextField textFieldBirthday;
	private JTextField textFieldAddress;
	private JTextField textFieldPostalCode;
	private JTextField textFieldCity;
	private JTextField textFieldProvince;
	private JTextField textFieldLogin;
	private JTextField textFieldPassword;
	private JTextField textFieldPassword2;
	private JTextField textFieldCVV;
	private JTextField textFieldCreditCard;
	private JTextField textFieldExpiration;

	/**
	 * Create the panel.
	 */
	public ProfilePanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblNewLabelName = new JLabel("Nombre");
		lblNewLabelName.setBounds(56, 35, 46, 14);
		panel.add(lblNewLabelName);
		
		JLabel lblNewLabelFirstSurname = new JLabel("Apellido 1");
		lblNewLabelFirstSurname.setBounds(56, 63, 46, 14);
		panel.add(lblNewLabelFirstSurname);
		
		JLabel lblNewLabelSecondSurname = new JLabel("Apellido 2");
		lblNewLabelSecondSurname.setBounds(56, 95, 46, 14);
		panel.add(lblNewLabelSecondSurname);
		
		JLabel lblNewLabelIDCard = new JLabel("DNI");
		lblNewLabelIDCard.setBounds(56, 120, 46, 14);
		panel.add(lblNewLabelIDCard);
		
		JLabel lblNewLabelBirthday = new JLabel("Fecha de nacimiento");
		lblNewLabelBirthday.setBounds(10, 145, 92, 14);
		panel.add(lblNewLabelBirthday);
		
		JLabel lblNewLabelAddress = new JLabel("Direccion");
		lblNewLabelAddress.setBounds(56, 170, 46, 14);
		panel.add(lblNewLabelAddress);
		
		JLabel lblNewLabelPostalCode = new JLabel("Codigo Postal");
		lblNewLabelPostalCode.setBounds(56, 201, 46, 14);
		panel.add(lblNewLabelPostalCode);
		
		JLabel lblNewLabelCity = new JLabel("Ciudad");
		lblNewLabelCity.setBounds(56, 230, 46, 14);
		panel.add(lblNewLabelCity);
		
		JLabel lblNewLabelProvince = new JLabel("Provincia");
		lblNewLabelProvince.setBounds(56, 255, 46, 14);
		panel.add(lblNewLabelProvince);
		
		JLabel lblNewLabelLogin = new JLabel("Login");
		lblNewLabelLogin.setBounds(247, 35, 46, 14);
		panel.add(lblNewLabelLogin);
		
		JLabel lblNewLabelPassword = new JLabel("Password");
		lblNewLabelPassword.setBounds(247, 63, 46, 14);
		panel.add(lblNewLabelPassword);
		
		JLabel lblNewLabelPassword2 = new JLabel("Password");
		lblNewLabelPassword2.setBounds(247, 95, 46, 14);
		panel.add(lblNewLabelPassword2);
		
		JLabel lblNewLabelUserType = new JLabel("Tipo de Usuario");
		lblNewLabelUserType.setBounds(247, 120, 109, 14);
		panel.add(lblNewLabelUserType);
		
		JLabel lblNewLabelCreditCard = new JLabel("Numero de tarjeta");
		lblNewLabelCreditCard.setBounds(247, 201, 46, 14);
		panel.add(lblNewLabelCreditCard);
		
		JLabel lblNewLabelExpiration = new JLabel("Caducidad");
		lblNewLabelExpiration.setBounds(247, 230, 46, 14);
		panel.add(lblNewLabelExpiration);
		
		JLabel lblNewLabelCVV = new JLabel("CVV");
		lblNewLabelCVV.setBounds(247, 255, 46, 14);
		panel.add(lblNewLabelCVV);
		
		JRadioButton rdbtnNewRadioButtonFree = new JRadioButton("Libre");
		rdbtnNewRadioButtonFree.setBounds(247, 141, 109, 23);
		panel.add(rdbtnNewRadioButtonFree);
		
		JRadioButton rdbtnNewRadioButtonPremium = new JRadioButton("Premium");
		rdbtnNewRadioButtonPremium.setBounds(247, 166, 109, 23);
		panel.add(rdbtnNewRadioButtonPremium);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(112, 32, 86, 20);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldFirstSurname = new JTextField();
		textFieldFirstSurname.setBounds(112, 60, 86, 20);
		panel.add(textFieldFirstSurname);
		textFieldFirstSurname.setColumns(10);
		
		textFieldSecondSurname = new JTextField();
		textFieldSecondSurname.setColumns(10);
		textFieldSecondSurname.setBounds(112, 92, 86, 20);
		panel.add(textFieldSecondSurname);
		
		textFieldIDCard = new JTextField();
		textFieldIDCard.setColumns(10);
		textFieldIDCard.setBounds(112, 117, 86, 20);
		panel.add(textFieldIDCard);
		
		textFieldBirthday = new JTextField();
		textFieldBirthday.setColumns(10);
		textFieldBirthday.setBounds(112, 142, 86, 20);
		panel.add(textFieldBirthday);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(112, 167, 86, 20);
		panel.add(textFieldAddress);
		
		textFieldPostalCode = new JTextField();
		textFieldPostalCode.setColumns(10);
		textFieldPostalCode.setBounds(112, 198, 86, 20);
		panel.add(textFieldPostalCode);
		
		textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		textFieldCity.setBounds(112, 227, 86, 20);
		panel.add(textFieldCity);
		
		textFieldProvince = new JTextField();
		textFieldProvince.setColumns(10);
		textFieldProvince.setBounds(112, 252, 86, 20);
		panel.add(textFieldProvince);
		
		textFieldLogin = new JTextField();
		textFieldLogin.setColumns(10);
		textFieldLogin.setBounds(304, 32, 86, 20);
		panel.add(textFieldLogin);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(303, 60, 86, 20);
		panel.add(textFieldPassword);
		
		textFieldPassword2 = new JTextField();
		textFieldPassword2.setColumns(10);
		textFieldPassword2.setBounds(303, 92, 86, 20);
		panel.add(textFieldPassword2);
		
		textFieldCVV = new JTextField();
		textFieldCVV.setColumns(10);
		textFieldCVV.setBounds(304, 252, 86, 20);
		panel.add(textFieldCVV);
		
		textFieldCreditCard = new JTextField();
		textFieldCreditCard.setColumns(10);
		textFieldCreditCard.setBounds(303, 198, 86, 20);
		panel.add(textFieldCreditCard);
		
		textFieldExpiration = new JTextField();
		textFieldExpiration.setColumns(10);
		textFieldExpiration.setBounds(303, 227, 86, 20);
		panel.add(textFieldExpiration);
		
		JButton btnNewButtonGoBack = new JButton("Volver");
		btnNewButtonGoBack.setBounds(109, 280, 89, 23);
		btnNewButtonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(13).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(btnNewButtonGoBack);
		
		JButton btnNewButtonModifyPassword = new JButton("CambiarContrasenna");
		btnNewButtonModifyPassword.setBounds(267, 280, 89, 23);
		btnNewButtonModifyPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(13).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(btnNewButtonModifyPassword);
		
		panel.setLayout(null);

	}
	public JPanel getPanel() {
		return panel;
	}

}