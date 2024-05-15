package db.pojos;

import java.util.Date;
import java.util.Objects;

public class FreeUser extends User {

	private static FreeUser instance;

	Date lastPlay = null;

	private FreeUser() {

	}

	public static FreeUser getInstance() {
		// Si la instancia no ha sido creada, crea una nueva
		if (instance == null) {
			instance = new FreeUser();
		}
		return instance;
	}

	public Date getLastPlay() {
		return lastPlay;
	}

	public void setLastPlay(Date lastPlay) {
		this.lastPlay = lastPlay;
	}

	public static void setInstance(FreeUser instance) {
		FreeUser.instance = instance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(lastPlay);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FreeUser other = (FreeUser) obj;
		return Objects.equals(lastPlay, other.lastPlay);
	}

	@Override
	public String toString() {
		return "FreeUser [lastPlay=" + lastPlay + "]";
	}

}
