package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test du contrôleur <code>EtatCtrl</code><br>
 * Test JUnit 4<br>
 * Les Getters et Setters ne sont pas pris en charge dans la série de tests.
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class EtatCtrlTest {

	//-- Attributs
	private EtatCtrl etat;
	
	/**
	 * Méthode setUp<br>
	 * Initialisation de l'etat de test
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.etat = new EtatCtrl("ETP", "Forfait Etape");
	}

	/**
	 * Test de l'instanciation pour le constructeur<br>
	 * <code>EtatCtrl(String id, String libelle, double montant)</code>
	 */
	@Test
	public void testEtatCtrl() {
		assertNotNull("Erreur à l'instanciation de l'objet EtatCtrl", this.etat);
	}

}
