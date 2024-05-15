package views;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import db.pojos.Group;
import db.pojos.Podcaster;
import panelControllers.GroupsManagementPanelController;
import utils.functionalities.Functionalities;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class GroupsManagementPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private GroupsManagementPanelController managementController = null;
	private Functionalities funciones = null;
	private Group group = null;
	private Podcaster podcaster=new Podcaster();
	private JLabel lblImage = new JLabel("imagen");
	private String base64Image = null;

	/**
	 * Create the panel.
	 */
	public GroupsManagementPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		managementController = new GroupsManagementPanelController();
		panel.setLayout(null);
		funciones = new Functionalities();
		group=new Group();
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuthor.setBounds(357, 41, 150, 25);
		panel.add(lblAuthor);

		JRadioButton RadioButtonGroup = new JRadioButton("Grupo");
		RadioButtonGroup.setBounds(390, 72, 100, 25);
		panel.add(RadioButtonGroup);

		JRadioButton RadioButtonPodcaster = new JRadioButton("Podcaster");
		RadioButtonPodcaster.setBounds(390, 100, 100, 25);
		panel.add(RadioButtonPodcaster);

		ButtonGroup butonGroup = new ButtonGroup();
		butonGroup.add(RadioButtonPodcaster);
		butonGroup.add(RadioButtonGroup);

		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(583, 72, 200, 200);
		panel.add(lblImage);

		JLabel lblName = new JLabel("nombre");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(604, 325, 150, 25);
		panel.add(lblName);

		JLabel lblDate = new JLabel("fechaCreacion");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(604, 397, 150, 25);
		panel.add(lblDate);

		JLabel lblDescription = new JLabel("Descripcion");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setBounds(604, 469, 150, 25);
		panel.add(lblDescription);

		JTextField textFieldNameAuthor = new JTextField();
		textFieldNameAuthor.setColumns(10);
		textFieldNameAuthor.setBounds(604, 361, 150, 25);
		panel.add(textFieldNameAuthor);

		JTextField textFieldDescription = new JTextField();
		textFieldDescription.setColumns(10);
		textFieldDescription.setBounds(604, 505, 150, 25);
		panel.add(textFieldDescription);

		JTextField textFieldDate = new JTextField("");
		textFieldDate.setToolTipText("YY-MM-DD");
		textFieldDate.setBounds(604, 433, 150, 25);
		panel.add(textFieldDate);
		textFieldDate.setColumns(10);

		JLabel lblNewLabelName = new JLabel("Escriba el nombre:");
		lblNewLabelName.setBounds(80, 143, 200, 25);
		panel.add(lblNewLabelName);

		JTextField textFieldName = new JTextField();
		textFieldName.setBounds(80, 172, 200, 25);
		panel.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblNewLabelSeleccion = new JLabel("Seleccione :");
		lblNewLabelSeleccion.setBounds(80, 41, 100, 25);
		panel.add(lblNewLabelSeleccion);

		JRadioButton rdbtnGroupSelection = new JRadioButton("Grupo");
		rdbtnGroupSelection.setBounds(80, 72, 100, 25);
		panel.add(rdbtnGroupSelection);

		JRadioButton rdbtnPodcastSelection = new JRadioButton("Podcaster");
		rdbtnPodcastSelection.setBounds(80, 112, 100, 25);
		panel.add(rdbtnPodcastSelection);

		ButtonGroup butonLook = new ButtonGroup();
		butonGroup.add(rdbtnGroupSelection);
		butonGroup.add(rdbtnPodcastSelection);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(180, 541, 150, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(8).setVisible(true);
				panels.get(6).setVisible(false);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnImagen = new JButton("Buscar Imagen");
		btnImagen.setBounds(604, 289, 150, 25);
		btnImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnImagenActionPerformed(e);
			}
		});

		panel.add(btnImagen);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(614, 541, 125, 25);
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managementController.updateAuthor(textFieldNameAuthor.getText().trim(), base64Image,
						textFieldDescription.getText().trim(), textFieldDate.getText().trim(),
						rdbtnPodcastSelection.isSelected(), rdbtnGroupSelection.isSelected());
			}
		});
		panel.add(btnActualizar);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(121, 207, 100, 25);
		panel.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean groups=managementController.getAuthor(rdbtnPodcastSelection.isSelected(),
						rdbtnGroupSelection.isSelected(), textFieldName.getText());
				if (groups) {
					lblImage.setVisible(true);
					lblName.setVisible(true);
					lblDate.setVisible(true);
					lblDescription.setVisible(true);
					btnImagen.setVisible(true);
					textFieldNameAuthor.setVisible(true);
					textFieldDescription.setVisible(true);
					textFieldDate.setVisible(true);
					btnActualizar.setVisible(true);
					lblImage.setIcon(null);
					textFieldNameAuthor.setText(null);
					textFieldDescription.setText(null);
					textFieldDate.setText(null);
					if(podcaster.getIdAuthor()!=0) {
						textFieldNameAuthor.setText(podcaster.getName());
						textFieldDescription.setText(podcaster.getDescription());
						textFieldDate.setText(managementController.datePodcast(podcaster));
						lblImage.setIcon(new ImageIcon((managementController.imageConverterPodcast(podcaster))));
					}else if(group.getIdAuthor()!=0) {
						
						textFieldNameAuthor.setText(group.getName());
						textFieldDescription.setText(group.getDescription());
						textFieldDate.setText(managementController.date(group));
						lblImage.setIcon(new ImageIcon((managementController.imageConverter(group))));
					}
				}else {
					lblImage.setIcon(null);
					textFieldNameAuthor.setText(null);
					textFieldDescription.setText(null);
					textFieldDate.setText(null);
						JOptionPane.showMessageDialog(panel ,"No Hay grupos con ese nombre");
						
					}
				}
			
		});
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(121, 207, 100, 25);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managementController.deleteAuthor(rdbtnPodcastSelection.isSelected(), rdbtnGroupSelection.isSelected(),
						textFieldName.getText());

			}
		});
		panel.add(btnEliminar);

		JButton btnNewButtonInsertar = new JButton("Insertar");
		btnNewButtonInsertar.setBounds(614, 541, 125, 25);
		panel.add(btnNewButtonInsertar);
		btnNewButtonInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managementController.createNewAuthor(textFieldNameAuthor.getText().trim(), base64Image,
						textFieldDescription.getText().trim(), textFieldDate.getText().trim(),
						RadioButtonGroup.isSelected(), RadioButtonPodcaster.isSelected());

			}
		});
		JButton btnNewButtonRemove = new JButton("Borrar");
		btnNewButtonRemove.setBounds(340, 505, 150, 25);
		btnNewButtonRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscar.setVisible(false);
				textFieldName.setVisible(true);
				lblNewLabelName.setVisible(true);
				lblNewLabelSeleccion.setVisible(true);
				rdbtnGroupSelection.setVisible(true);
				rdbtnPodcastSelection.setVisible(true);
				btnNewButtonInsertar.setVisible(false);
				lblAuthor.setVisible(false);
				RadioButtonGroup.setVisible(false);
				RadioButtonPodcaster.setVisible(false);
				lblImage.setVisible(false);
				lblName.setVisible(false);
				lblDate.setVisible(false);
				lblDescription.setVisible(false);
				btnImagen.setVisible(false);
				textFieldNameAuthor.setVisible(false);
				textFieldDescription.setVisible(false);
				textFieldDescription.setVisible(false);
				textFieldDate.setVisible(false);
				lblNewLabelName.setVisible(false);
				btnEliminar.setVisible(true);
				lblNewLabelName.setVisible(true);
				textFieldDate.setVisible(false);
				btnActualizar.setVisible(false);

			}
		});
		panel.add(btnNewButtonRemove);
		JButton btnNewButtonCreate = new JButton("Crear");
		btnNewButtonCreate.setBounds(20, 505, 150, 25);
		panel.add(btnNewButtonCreate);
		btnNewButtonCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAuthor.setVisible(true);
				RadioButtonGroup.setVisible(true);
				RadioButtonPodcaster.setVisible(true);
				lblImage.setVisible(true);
				lblName.setVisible(true);
				lblDate.setVisible(true);
				lblDescription.setVisible(true);
				btnImagen.setVisible(true);
				textFieldNameAuthor.setVisible(true);
				textFieldDescription.setVisible(true);
				btnNewButtonInsertar.setVisible(true);
				textFieldDate.setVisible(true);
				textFieldName.setVisible(false);
				btnBuscar.setVisible(false);
				lblNewLabelSeleccion.setVisible(false);
				rdbtnGroupSelection.setVisible(false);
				rdbtnPodcastSelection.setVisible(false);
				btnEliminar.setVisible(false);
				lblNewLabelName.setVisible(false);
				btnActualizar.setVisible(false);

			}
		});

		JButton btnNewButtonModify = new JButton("Modificar");
		btnNewButtonModify.setBounds(180, 505, 150, 25);
		btnNewButtonModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBuscar.setVisible(true);
				textFieldName.setVisible(true);
				lblNewLabelName.setVisible(true);
				lblNewLabelSeleccion.setVisible(true);
				rdbtnGroupSelection.setVisible(true);
				rdbtnPodcastSelection.setVisible(true);
				lblNewLabelName.setVisible(true);
				btnNewButtonInsertar.setVisible(false);
				lblAuthor.setVisible(false);
				RadioButtonGroup.setVisible(false);
				RadioButtonPodcaster.setVisible(false);
				lblImage.setVisible(false);
				lblName.setVisible(false);
				lblDate.setVisible(false);
				lblDescription.setVisible(false);
				btnImagen.setVisible(false);
				textFieldNameAuthor.setVisible(false);
				textFieldDescription.setVisible(false);
				textFieldDescription.setVisible(false);
				textFieldDate.setVisible(false);
				lblNewLabelName.setVisible(false);
				btnEliminar.setVisible(false);
				textFieldDate.setVisible(false);
				btnActualizar.setVisible(false);
			}
		});
		panel.add(btnNewButtonModify);
		


		btnImagen.setVisible(false);
		textFieldDate.setVisible(false);
		btnNewButtonInsertar.setVisible(false);
		lblAuthor.setVisible(false);
		RadioButtonGroup.setVisible(false);
		RadioButtonPodcaster.setVisible(false);
		lblImage.setVisible(false);
		lblName.setVisible(false);
		lblDate.setVisible(false);
		lblDescription.setVisible(false);
		textFieldNameAuthor.setVisible(false);
		textFieldDescription.setVisible(false);
		textFieldDescription.setVisible(false);
		textFieldDate.setVisible(false);
		lblNewLabelName.setVisible(false);
		btnEliminar.setVisible(false);
		textFieldName.setVisible(false);
		btnBuscar.setVisible(false);
		lblNewLabelSeleccion.setVisible(false);
		rdbtnGroupSelection.setVisible(false);
		rdbtnPodcastSelection.setVisible(false);
		lblNewLabelName.setVisible(false);
		btnActualizar.setVisible(false);

	}

	public void btnImagenActionPerformed(ActionEvent evt) {
	    String ruta = "";
	    JFileChooser jFile = new JFileChooser();
	    FileNameExtensionFilter filtrado = new FileNameExtensionFilter("JPG , PNG", "jpg", "png");
	    jFile.setFileFilter(filtrado);

	    int respuesta = jFile.showOpenDialog(this);
	    if (respuesta == jFile.APPROVE_OPTION) {
	        ruta = jFile.getSelectedFile().getPath();
	        Image imagen = new ImageIcon(ruta).getImage();
	        base64Image = managementController.convertirImagenABase64(ruta);
	        if (imagen != null) {
	            ImageIcon icono = new ImageIcon(imagen.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), imagen.SCALE_SMOOTH));
	            lblImage.setIcon(icono);
	        } else {
	            lblImage.setText("imagen");
	        }
	    }
	}


	public JPanel getPanel() {
		return panel;
	}
}