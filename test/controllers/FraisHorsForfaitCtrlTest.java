package controllers;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test du contrôleur <code>FraisHorsForfaitCtrl</code><br>
 * Test JUnit 4<br>
 * Les Getters et Setters ne sont pas pris en charge dans la série de tests.
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class FraisHorsForfaitCtrlTest {

	//-- Attributs
	private FraisHorsForfaitCtrl fraisHorsForfait;
	
	//-- Méthodes de test
	
	/**
	 * Méthode setUp<br>
	 * Initialisation du frais hors forfait de test<br>
	 * Le frais d'id 3948 existe en BDD pour cas de test (ID visiteur -> test),
	 * celui-ci peut donc être modifié sans impact pour l'intégrité des données des visiteurs réels
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		this.fraisHorsForfait = new FraisHorsForfaitCtrl(3948, "Taxi", date, 124.00, 0);
	}

	/**
	 * Test de l'instanciation pour le constructeur<br>
	 * <code>FraisHorsForfaitCtrl(int id, String libelle, Date date, double montant, int etat)</code>
	 */
	@Test
	public void testFraisHorsForfaitCtrl() {
		assertNotNull("Erreur à l'instanciation de l'objet FraisHorsForfaitCtrl", this.fraisHorsForfait);
	}

	/**
	 * Test du changement d'état du frais hors forfait<br>
	 * <ul>
	 * <li>NULL | 0 -> frais refusé</li>
	 * <li>1 -> frais validé</li>
	 * </ul>
	 * Le test se passe de la manière suivante :<br>
	 * <ol>
	 * <li>Utilisation de la méthode setEtat</li>
	 * <li>La méthode setEtat appel à une modification en base de données puis modifie l'état de l'objet courant</li>
	 * <li>Nous vérifions l'état de l'objet courant avant et après modification</li>
	 * </ol>
	 */
	@Test
	public void testSetEtat() {
		assertEquals("Erreur sur l'état de l'objet courant",0, this.fraisHorsForfait.getEtat());
		this.fraisHorsForfait.setEtat(1);
		assertEquals("Erreur sur l'état de l'objet courant",1, this.fraisHorsForfait.getEtat());
	}
}
