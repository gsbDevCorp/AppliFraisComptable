package views;

/**
 * Classe permettant de lancer l'interface graphique de l'application
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class Lanceur {

	/**
	 * Lancement de l'interface graphique utilisateur
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Fenetre fenetre = new Fenetre();
		fenetre.setActivePanel(new Connexion(fenetre).launchPanel());
	}
}