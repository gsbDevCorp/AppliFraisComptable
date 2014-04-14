package controllers;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test du contrôleur <code>FicheFraisCtrl</code><br>
 * Test JUnit 4<br>
 * Les Getters et Setters ne sont pas pris en charge dans les tests.
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class FicheFraisCtrlTest {

	//-- Attributs
	private FicheFraisCtrl ficheFrais;
	
	//-- Méthodes de test
	
	/**
	 * Méthode setUp<br>
	 * Initialisation de la fiche de frais de test
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		this.ficheFrais = new FicheFraisCtrl("a123", "CL", "201404", date, 2, 0.0);
	}

	/**
	 * Test de l'instanciation pour le constructeur<br>
	 * <code>FicheFraisCtrl(String idVisiteur, String idEtat, String mois, Date dateModif, int nbJustificatifs, double montantValide)</code>
	 */
	@Test
	public void testFicheFraisCtrl() {
		assertNotNull("Erreur à l'instanciation de l'objet FicheFraisCtrl", this.ficheFrais);
	}

	/**
	 * Test du chargement de la liste des frais forfait correspondant à la fiche de frais.<br>
	 * Les frais forfait sont chargés depuis la base de données<br>
	 * <b>Deux cas :</b>
	 * <ul>
	 * <li>Fiche de frais virtuelle : aucun frais ne doit être retourné</li>
	 * <li>Fiche de frais réelle :
	 * 		<ul>
	 * 		<li>Plusieurs frais forfait doivent être retournées</li>
	 * 		<li>Attention : Le test ne se fait pas sur un nombre exact de frais forfait celui-ci pouvant être ammené à évoluer</li>
	 * 		</ul>
	 * </li>
	 * </ul>
	 */
	@Test
	public void testLoadListeFraisForfaits() {
		this.ficheFrais.loadListeFraisForfaits();
		assertEquals("Erreur sur le nombre de frais forfait retournés", 0, this.ficheFrais.getListeFraisForfait().size());
		
		/*
		 * Instanciation d'une fiche de frais pour un visiteur réel (a131)
		 * Le test ne se fait pas sur le nombre exact de frais forfait retournés celui-ci pouvant être ammené à évoluer.
		 */
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		FicheFraisCtrl ficheFraisReelle = new FicheFraisCtrl("a131", "RB", "201001", date, 5, 0.0);
		ficheFraisReelle.loadListeFraisForfaits();
		assertTrue("Erreur sur le nombre de frais forfait retournés", ficheFraisReelle.getListeFraisForfait().size() > 0);
	}

	/**
	 * Test du chargement de la liste des frais hors forfait correspondant à la fiche de frais.<br>
	 * Les frais hors forfait sont chargés depuis la base de données<br>
	 * <b>Deux cas :</b>
	 * <ul>
	 * <li>Fiche de frais virtuelle : aucun frais ne doit être retourné</li>
	 * <li>Fiche de frais réelle :
	 * 		<ul>
	 * 		<li>Plusieurs frais hors forfait doivent être retournées</li>
	 * 		<li>Attention : Le test ne se fait pas sur un nombre exact de frais hors forfait celui-ci pouvant être ammené à évoluer</li>
	 * 		</ul>
	 * </li>
	 * </ul>
	 */
	@Test
	public void testLoadListeFraisHorsForfaits() {
		this.ficheFrais.loadListeFraisHorsForfaits();
		assertEquals("Erreur sur le nombre de frais hors forfait retournés", 0, this.ficheFrais.getListeFraisHorsForfait().size());
		
		/*
		 * Instanciation d'une fiche de frais pour un visiteur réel (a131)
		 * Le test ne se fait pas sur le nombre exact de frais retournés celui-ci pouvant être ammené à évoluer.
		 */
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		FicheFraisCtrl ficheFraisReelle = new FicheFraisCtrl("a131", "RB", "201001", date, 5, 0.0);
		ficheFraisReelle.loadListeFraisHorsForfaits();
		assertTrue("Erreur sur le nombre de frais hors forfait retournés", ficheFraisReelle.getListeFraisHorsForfait().size() > 0);
	}

	@Test
	public void testModifierEtatFiche() {
		fail("Not yet implemented");
	}

	/**
	 * Test de la méthode de formatage des mois<br>
	 * Doit retourner le mois du format <code>aaaamm</code> au format <code>aaaa - mm</code><br>
	 * Ici : <code>201404</code> -> <code>2014 - 04</code>
	 */
	@Test
	public void testGetMoisFormate() {
		assertEquals("Le format du mois retourné est invalide", "2014 - 04", this.ficheFrais.getMoisFormate());
	}

	@Test
	public void testGetLibelleIdEtat() {
		fail("Not yet implemented");
	}

}
