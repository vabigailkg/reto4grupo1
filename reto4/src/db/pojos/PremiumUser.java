package db.pojos;

import java.util.Objects;

public class PremiumUser extends User {

    // Campo estático para almacenar la única instancia de PremiumUser
    private static PremiumUser instance;

    long cardNumber = 0;
    String expirationDate = null;
    int cvv = 0;

    // Constructor privado para evitar la creación de instancias fuera de la clase
    private PremiumUser() {
        // Inicializa los campos de PremiumUser
    }

    // Método público estático para obtener la instancia única de PremiumUser
    public static PremiumUser getInstance() {
        // Si la instancia no ha sido creada, crea una nueva
        if (instance == null) {
            instance = new PremiumUser();
        }
        return instance;
    }

    

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cardNumber, cvv, expirationDate);
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
		PremiumUser other = (PremiumUser) obj;
		return cardNumber == other.cardNumber && cvv == other.cvv
				&& Objects.equals(expirationDate, other.expirationDate);
	}

	@Override
	public String toString() {
		return "PremiumUser [cardNumber=" + cardNumber + ", expirationDate=" + expirationDate + ", cvv=" + cvv + "]";
	}
    
    
}