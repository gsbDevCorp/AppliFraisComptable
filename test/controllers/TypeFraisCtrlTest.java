package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test du contrôleur <code>TypeFraisCtrl</code><br>
 * Test JUnit 4<br>
 * Les Getters et Setters ne sont pas pris en charge dans la série de tests.
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class TypeFraisCtrlTest {

	//-- Attributs
	private TypeFraisCtrl typeFrais;
	
	//-- Méthodes de test
	
	/**
	 * Méthode setUp<br>
	 * Initialisation du type frais de test
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.typeFrais = new TypeFraisCtrl("ETP", "Forfait Etape", 110.0);
	}

	/**
	 * Test de l'instanciation pour le constructeur<br>
	 * <code>TypeFraisCtrl(String id, String libelle, double montant)</code>
	 */
	@Test
	public void testTypeFraisCtrl() {
		assertNotNull("Erreur à l'instanciation de l'objet TypeFraisCtrl", this.typeFrais);
	}

}
