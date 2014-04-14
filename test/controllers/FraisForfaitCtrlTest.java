package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test du contrôleur <code>FraisForfaitCtrl</code><br>
 * Test JUnit 4<br>
 * Les Getters et Setters ne sont pas pris en charge dans la série de tests.
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class FraisForfaitCtrlTest {

	//-- Attributs
	private FraisForfaitCtrl fraisForfait;
	
	/**
	 * Méthode setUp<br>
	 * Initialisation du frais forfait de test
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.fraisForfait = new FraisForfaitCtrl(new TypeFraisCtrl("ETP", "Forfait Etape", 110), 5);
	}

	/**
	 * Test de l'instanciation pour le constructeur<br>
	 * <code>FraisForfaitCtrl(TypeFraisCtrl typeFrais, int quantite)</code>
	 */
	@Test
	public void testFraisForfaitCtrlTypeFraisCtrlInt() {
		assertNotNull("Erreur à l'instanciation de l'objet FraisForfaitCtrl", this.fraisForfait);
	}

}
