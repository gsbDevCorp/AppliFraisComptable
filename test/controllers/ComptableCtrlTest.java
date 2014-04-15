package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test du contrôleur <code>ComptableCtrl</code><br>
 * Test JUnit 4<br>
 * Les Getters et Setters ne sont pas pris en charge dans la série de tests.
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class ComptableCtrlTest {

	//-- Attributs
	private ComptableCtrl comptable;
	
	//-- Méthodes de test
	
	/**
	 * Méthode setUp<br>
	 * Initialisation du comptable de test
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.comptable = new ComptableCtrl(0, "Jean", "Blanchard");
	}

	/**
	 * Test de l'instanciation pour le constructeur<br>
	 * <code>ComptableCtrl(int id, String nom, String prenom)</code>
	 */
	@Test
	public void testComptableCtrl() {
		assertNotNull("Erreur à l'instanciation de l'objet ComptableCtrl", this.comptable);
	}

}
