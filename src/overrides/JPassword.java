package overrides;

import javax.swing.JPasswordField;

/**
 * Extension de la classe JPasswordField
 * Permet de récupérer les mots de passe en clair et sous forme d'objet de type String
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class JPassword extends JPasswordField {
	
	/**
	 * Surcharge du constructeur par défaut
	 */
	public JPassword() {
		super();
	}
	
	/**
	 * Surcharge du constructeur avec définition de la longueur
	 * 
	 * @param columns int longueur du mot de passe
	 */
	public JPassword(int columns) {
		super(columns);
	}
	
	/**
	 * Fonction de transformation du mot de passe en chaine de
	 * caractères claire.
	 * 
	 * @return String mot de passe clair
	 */
	public String transformString() {
		char[] charList = this.getPassword();
		return new String(charList);
	}
}
