package views;
import java.util.ArrayList;

import models.*;
import controllers.*;
import views.*;

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