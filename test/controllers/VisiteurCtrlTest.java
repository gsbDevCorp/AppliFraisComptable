package controllers;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de test du contrôleur <code>VisiteurCtrl</code><br>
 * Test JUnit 4<br>
 * Les Getters et Setters ne sont pas pris en charge dans la série de tests.
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class VisiteurCtrlTest {
	
	//-- Attributs
	private VisiteurCtrl visiteur;
	
	//-- Méthodes de test

	/**
	 * Méthode setUp<br>
	 * Initialisation du Visiteur de test
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.visiteur = new VisiteurCtrl("A123", "Jules", "Martin");
	}

	/**
	 * Test de l'instanciation pour le constructeur<br>
	 * <code>VisiteurCtrl(String id, String nom, String prenom)</code>
	 */
	@Test
	public void testVisiteurCtrl() {
		assertNotNull("Erreur à l'instanciation de l'objet VisiteurCtrl",this.visiteur);
	}

	/**
	 * Test du chargement des fiches depuis la base de données<br>
	 * <b>Deux cas :</b>
	 * <ul>
	 * <li>Visiteur virtuel :<ul><li>Aucune fiche ne doit être retournée</li></ul></li>
	 * <li>Visiteur réel :
	 * 		<ul>
	 * 		<li>Plusieurs fiches doivent être retournées</li>
	 * 		<li>Attention : Le test ne se fait pas sur un nombre exact de fiches celui-ci étant ammené à évoluer</li>
	 * 		</ul
	 * ></li>
	 * </ul>
	 */
	@Test
	public void testLoadFichesFrais() {
		assertEquals("Erreur sur le nombre de fiches retournées", 0, this.visiteur.loadFichesFrais().size());
		
		/* 
		 * Visiteur réel (identifiant a17)
		 * Attention : On ne test pas le nombre exact de fiches retournées celui-ci étant ammené à évoluer
		 */
		VisiteurCtrl visiteurReel = new VisiteurCtrl("a17", "Andre", "David");
		assertTrue("Erreur sur le nombre de fiches retournées", visiteurReel.loadFichesFrais().size() > 0);
	}

	/**
	 * Test de la récupération de fiches à un état particulier depuis la liste des fiches de frais du visiteur<br>
	 * <ol>
	 * <li>Instanciation de fiches aux différents états</li>
	 * <li>Test du nombre de fiches instanciées</li>
	 * <li>Test du nombre de fiches d'un état précis retournées</li>
	 * <ol>
	 */
	@Test
	public void testGetFichesFraisEtat() {
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		FicheFraisCtrl fiche1 = new FicheFraisCtrl(this.visiteur.getId(), "CL", "201401", date, 2, 0.0);
		FicheFraisCtrl fiche2 = new FicheFraisCtrl(this.visiteur.getId(), "CL", "201402", date, 2, 34.54);
		FicheFraisCtrl fiche3 = new FicheFraisCtrl(this.visiteur.getId(), "RB", "201403", date, 2, 12.0);
		FicheFraisCtrl fiche4 = new FicheFraisCtrl(this.visiteur.getId(), "VA", "201404", date, 2, 124.0);
		FicheFraisCtrl fiche5 = new FicheFraisCtrl(this.visiteur.getId(), "RB", "201405", date, 2, 316.47);
		ArrayList<FicheFraisCtrl> listeFicheFrais = new ArrayList<FicheFraisCtrl>();
		listeFicheFrais.add(fiche1);
		listeFicheFrais.add(fiche2);
		listeFicheFrais.add(fiche3);
		listeFicheFrais.add(fiche4);
		listeFicheFrais.add(fiche5);
		this.visiteur.setListeFicheFrais(listeFicheFrais);
		
		assertEquals("Mauvais nombre de fiches retournées", 5, this.visiteur.getListeFicheFrais().size());
		assertEquals("Mauvais nombre de fiches retournées", 2, this.visiteur.getFichesFraisEtat("CL").size());
		assertEquals("Mauvais nombre de fiches retournées", 2, this.visiteur.getFichesFraisEtat("RB").size());
		assertEquals("Mauvais nombre de fiches retournées", 1, this.visiteur.getFichesFraisEtat("VA").size());
	}

}
