package panelControllers;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.JOptionPane;

import db.management.GroupManager;
import db.management.PodcasterManager;
import db.pojos.Album;
import db.pojos.Group;
import db.pojos.Podcaster;

public class GroupsManagementPanelController {
	GroupManager groupManager = new GroupManager();
	PodcasterManager podcastManager = new PodcasterManager();
	Group group = new Group();

	public void createNewAuthor(String nombreAuthor, String imagen, String descripcion, String año, boolean group,
			boolean podcaster) {

		Date fecha = convertDate(año);
		System.out.println(fecha);
		if (group) {
			groupManager.insert(nombreAuthor, imagen, descripcion, fecha);
		} else if (podcaster) {
			podcastManager.insert(nombreAuthor, imagen, descripcion, fecha);
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione Grupo o Podcaster");
		}

	}

	public Date convertDate(String fecha) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date fechaConvertida = null;

		try {
			Date parsed = dateFormat.parse(fecha);
			fechaConvertida = new java.sql.Date(parsed.getTime());
		} catch (Exception e) {
			System.out.println("Error occurred" + e.getMessage());
			JOptionPane.showMessageDialog(null, "Escriba con el formato YY-MM-DD");
		}
		return fechaConvertida;

	}

	public boolean getAuthor(boolean podcaster, boolean group, String name) {
		boolean author = false;
		if (group) {
			groupManager.getGroupForName(name);
			author=true;
		} else if (podcaster) {
			podcastManager.getPodcastForName(name);
			author=true;
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione Grupo o Podcaster");
			author=false;
		}
		return author;
	}

	public void updateAuthor(String nombreAuthor, String imagen, String descripcion, String año, boolean podcaster,
			boolean group) {
		Date fecha = convertDate(año);
		if (group) {
			groupManager.update(nombreAuthor, imagen, descripcion, fecha);
		} else if (podcaster) {
			podcastManager.update(nombreAuthor, imagen, descripcion, fecha);
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione Grupo o Podcaster");
		}
	}

	public boolean deleteAuthor(boolean podcaster, boolean group, String name) {
		boolean author = false;
		if (group) {
			groupManager.delete(name);
			author = true;
		} else if (podcaster) {
			podcastManager.delete(name);
			author = true;
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione Grupo o Podcaster");
			author = false;
		}
		return author;
	}

	public String convertirImagenABase64(String ruta) {
		String base64Image = "";
		try {

			File file = new File(ruta);
			FileInputStream fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
			fileInputStreamReader.close();

			// Codifica los bytes en base64
			base64Image = Base64.getEncoder().encodeToString(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return base64Image;
	}

	public Image imageConverter(Group grupo) {
		Image image = null;

		if (grupo != null && grupo.getImagen() != null && !grupo.getImagen().isEmpty()) {
			try {
				byte[] imageData = Base64.getDecoder().decode(grupo.getImagen());
				image = ImageIO.read(new ByteArrayInputStream(imageData));
			} catch (IllegalArgumentException e) {
				System.err.println(
						"La cadena almacenada en la base de datos no es una representación válida de una imagen en base64.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "La cadena base64 de la imagen es nula o vacía.");
		}

		return image;
	}
	public Image imageConverterPodcast(Podcaster podcast) {
		Image image = null;

		if (podcast != null && podcast.getImagen() != null && !podcast.getImagen().isEmpty()) {
			try {
				byte[] imageData = Base64.getDecoder().decode(podcast.getImagen());
				image = ImageIO.read(new ByteArrayInputStream(imageData));
			} catch (IllegalArgumentException e) {
				System.err.println(
						"La cadena almacenada en la base de datos no es una representación válida de una imagen en base64.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "La cadena base64 de la imagen es nula o vacía.");
		}

		return image;
	}
	public String date(Group grupo) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(grupo.getCreationDate());
		return formattedDate;
	}
	public String datePodcast(Podcaster podcast) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(podcast.getCreationDate());
		return formattedDate;
	}

}
