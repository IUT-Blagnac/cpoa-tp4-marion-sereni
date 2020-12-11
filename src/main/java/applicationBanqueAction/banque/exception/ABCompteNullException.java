package applicationBanqueAction.banque.exception;

/************************************************************
 * Cette exception est lev�e par la Classe AgenceBancaire lorsque un compte avec valeur null est ajout� � l'agence.<BR>
 * 
 * @author Andr� P�ninou.
 * @version 3.0
 *****************************/

public class ABCompteNullException extends Exception {

	/**
	 * Constructeur par d�faut.<BR>
	 */
	public ABCompteNullException() {
		this("Erreur sur un objet de la classe AgenceBancaire");
	}

	/**
	 * Constructeur param�tr�.<BR>
	 * 
	 * @param message
	 *            information qui sera affich�e si l'exception est affich�e �
	 *            l'�cran
	 */
	public ABCompteNullException(String message) {
		super(message);
	}
}



