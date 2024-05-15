package panelControllers;

import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class SongPanelController {
	
	public static final String[] MUSIC_FILES = { "FF3-Victory-Fanfare.mp3", "Ruins.mp3", "OnceUponATime.mp3"
			// Agregar el nombre de las musicas aqui																		
	};
	public static final String MUSIC_FOLDER = new File("").getAbsolutePath() + "\\src\\music\\";

	private static Player player = null;
	private static int posicionCancion = 0;

	public static void play() {
		new Thread() {
			@Override
			public void run() {
				try {
					FileInputStream fileInputStream = new FileInputStream(MUSIC_FOLDER + MUSIC_FILES[posicionCancion]);
					player = new Player(fileInputStream);
					player.play();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}.start();
	}

	public static void stop() {
		if (player != null) {
			player.close();
		}
	}

	public void playPreviousSong() {
		// si la posicion es mayor a 0 le resta 1 se va a la posicion anterior
		if (posicionCancion > 0) {
			posicionCancion--;
		} else {
			posicionCancion = MUSIC_FILES.length - 1;
		}
		// se detiene la reproduccion de la cancion actual y se reproduce la anterior
		stop();
		play();
	}

	public void playNextSong() {
		// a la posicion se le suma 1
		if (posicionCancion < MUSIC_FILES.length - 1) {
			posicionCancion++;
		} else {
			posicionCancion = 0;
		}
		// se detiene la reproduccion de la cancion actual y se reproduce la siguiente
		stop();
		play();
	}
}
