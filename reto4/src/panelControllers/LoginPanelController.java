package panelControllers;

import db.management.FreeUserManager;
import db.management.PremiumUserManager;
import db.management.UserManager;
import db.pojos.FreeUser;
import db.pojos.PremiumUser;
import views.MainPanel;

public class LoginPanelController {
	private UserManager userManager = new UserManager();
	private PremiumUserManager premiumUserManager = new PremiumUserManager();
	private PremiumUser premiumUser = PremiumUser.getInstance();
	private FreeUserManager freeUserManager = new FreeUserManager();
	private FreeUser freeUser = FreeUser.getInstance();

	private MainPanelController mainController = new MainPanelController();

	public boolean checkBlockedAcount(String login) throws Exception {
		boolean ret = false;
		ret = userManager.getAcountIsBlocked(login);
		return ret;
	}

	public void checkUser(String login) throws Exception {

		// busca su id
		int id = checkIdUser(login);
		// verifica si el id se encuentra en la tabla de premium
		int premium = checkPremiumUser(id);
		// si premium es un numero distinto a 0 significa que si esta en premium
		if (premium != 0) {
			// guarda todos los datos del usuarioPremium en el pojo
			userManager.getUserPremium(premium);
			// Verifica si el usuario es ADMIN
			boolean isUser = checkAdminAcount(login);
			premiumUser.setAdmin(isUser);
			
		} else {
			int libre = checkFreeUser(id);
			// si libre es un numero distinto a 0 significa que si esta en libre
			if (libre != 0) {
				// guarda todos los datos del usuarioLibre en el pojo
				userManager.getUserFree(libre);
				// Verifica si el usuario es ADMIN
				boolean isUser = checkAdminAcount(login);
				freeUser.setAdmin(isUser);

			}
		}

	}

	public boolean checkAdminAcount(String login) throws Exception {
		boolean ret = false;
		ret = userManager.getAcountIsAdmin(login);
		return ret;
	}

	public int checkIdUser(String login) throws Exception {

		int ret = 0;
		ret = userManager.getIdAcount(login);
		return ret;
	}

	public int checkPremiumUser(int id) throws Exception {

		int ret = 0;
		ret = premiumUserManager.getIdUser(id);
		return ret;
	}

	public int checkFreeUser(int id) throws Exception {

		int ret = 0;
		ret = freeUserManager.getIdUser(id);
		return ret;
	}

	private boolean checkLogIn(String login) throws Exception {
		UserManager userManager = new UserManager();
		boolean ret = false;
		if (login.equalsIgnoreCase(userManager.getLogin(login)))
			ret = true;
		return ret;
	}

	private boolean checkPassword(String login, String password) throws Exception {
		boolean ret = false;
		if (password.equals(userManager.getPassword(login)))
			ret = true;
		return ret;
	}

	public void changeUserToBlock(String login) throws Exception {
		userManager.blockUser(login);
	}

	public void changeLastConection(String login) throws Exception {
		userManager.updateLastConection(login);
	}

	public boolean logInPasswordCorrect(String login, String password) throws Exception {
		boolean ret = false;
		if (checkLogIn(login) && checkPassword(login, password))
			ret = true;
		return ret;
	}

}