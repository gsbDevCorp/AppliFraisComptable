package controllers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test du contrôleur <code>FicheFraisCtrl</code><br>
 * Test JUnit 4<br>
 * Les Getters et Setters ne sont pas pris en charge dans la série de tests.
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class FicheFraisCtrlTest {

	//-- Attributs
	private FicheFraisCtrl ficheFraisSimu, ficheFraisReel;
	
	//-- Méthodes de test
	
	/**
	 * Méthode setUp<br>
	 * Initialisation des fiches de frais de test
	 * <ul>
	 * <li>ficheFraisSimu -> fiche de frais simulée</li>
	 * <li>ficheFraisReel -> fiche de frais réelle, utilise le cas de test visiteur inscrit en BDD :
	 * 		<ul>
	 * 		<li>ID -> test</li>
	 * 		<li>Nom -> visiteurTest</li>
	 * 		<li>Prénom -> visiteurTest</li>
	 * 		<ul>
	 * </li>
	 * </ul>
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		EtatCtrl etat = new EtatCtrl("CL", "saisie clôturée");
		this.ficheFraisSimu = new FicheFraisCtrl("a123", etat, "201404", date, 2, 0.0);
		this.ficheFraisReel = new FicheFraisCtrl("test", etat, "201404", date, 4, 0.0);
	}

	/**
	 * Test de l'instanciation pour le constructeur<br>
	 * <code>FicheFraisCtrl(String idVisiteur, String idEtat, String mois, Date dateModif, int nbJustificatifs, double montantValide)</code>
	 */
	@Test
	public void testFicheFraisCtrl() {
		assertNotNull("Erreur à l'instanciation de l'objet FicheFraisCtrl", this.ficheFraisSimu);
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
		this.ficheFraisSimu.loadListeFraisForfait();
		assertEquals("Erreur sur le nombre de frais forfait retournés", 0, this.ficheFraisSimu.getListeFraisForfait().size());
		
		/*
		 * Test sur le cas de test visiteur réel (ID -> test)
		 * Le test ne se fait pas sur le nombre exact de frais forfait retournés celui-ci pouvant être ammené à évoluer.
		 */
		this.ficheFraisReel.loadListeFraisForfait();
		assertTrue("Erreur sur le nombre de frais forfait retournés", this.ficheFraisReel.getListeFraisForfait().size() > 0);
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
		this.ficheFraisSimu.loadListeFraisHorsForfait();
		assertEquals("Erreur sur le nombre de frais hors forfait retournés", 0, this.ficheFraisSimu.getListeFraisHorsForfait().size());
		
		/*
		 * Test sur le cas de test visiteur réel (ID -> test)
		 * Le test ne se fait pas sur le nombre exact de frais retournés celui-ci pouvant être ammené à évoluer.
		 */
		this.ficheFraisReel.loadListeFraisHorsForfait();
		assertTrue("Erreur sur le nombre de frais hors forfait retournés", this.ficheFraisReel.getListeFraisHorsForfait().size() > 0);
	}

	/**
	 * Test de la modification d'état du libellé<br>
	 * Le test se fait sur l'une des fiches de frais du visiteur de test inscrit en BDD (ID -> test)<br>
	 * La vérification se fait sur le getIdEtat
	 */
	@Test
	public void testModifierEtatFiche() {
		assertEquals("Erreur : Le code de la fiche de frais devrait être 'CL'", "CL", this.ficheFraisReel.getEtat().getId());
		this.ficheFraisReel.modifierEtatFiche(new EtatCtrl("VA", "Validée et mise en paiement"));
		assertEquals("Erreur à la modification de l'état de la fiche de frais", "VA", this.ficheFraisReel.getEtat().getId());
	}

	/**
	 * Test de la méthode de formatage des mois<br>
	 * Doit retourner le mois du format <code>aaaamm</code> au format <code>aaaa - mm</code><br>
	 * Ici : <code>201404</code> -> <code>2014 - 04</code>
	 */
	@Test
	public void testGetMoisFormate() {
		assertEquals("Le format du mois retourné est invalide", "2014 - 04", this.ficheFraisSimu.getMoisFormate());
	}
}
