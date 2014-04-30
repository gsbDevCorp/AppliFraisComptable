package overrides;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controllers.ComptableCtrl;
import controllers.FicheFraisCtrl;
import controllers.VisiteurCtrl;

/**
 * Classe de test de l'override <code>TableModel</code><br>
 * Test JUnit 4<br>
 * Les Getters et Setters ne sont pas pris en charge dans la série de tests.
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class TableModelTest {

	//-- Attributs
	private TableModel tableSansParams, tableAvecParams;
	private VisiteurCtrl visiteur = new VisiteurCtrl("a17", "Andre", "David");
	
	//-- Méthodes de test
	
	/**
	 * Méthode setUp<br>
	 * Instanciation d'objets de type TableModel pour tests d'instanciation
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.tableSansParams = new TableModel();
		
		String etat = "CL";
		this.tableAvecParams = new TableModel(this.visiteur, etat);
	}
	
	/**
	 * Test de l'instanciation pour le constructeur
	 * <code>TableModel()</code>
	 */
	@Test
	public void testTableModel() {
		assertNotNull(this.tableSansParams);
	}
	
	/**
	 * Test de l'instanciation pour le constructeur
	 * <code>TableModel(VisiteurCtrl visiteur, String etat)</code>
	 */
	@Test
	public void testTableModelVisiteurEtat() {
		assertNotNull(this.tableAvecParams);
	}
	
	/**
	 * Test de la méthode <code>setListeFicheFrais(VisiteurCtrl visiteur, String etat)<br>
	 * <ul>
	 * <li> Test 1 :
	 * 		<ul>
	 * 		<li>Test de la méthode avec un visiteur précis (Andre David - a17)</li>
	 * 		<li>Test de la méthode avec un état précis (Remboursée - RB)</li>
	 * 		<li>Le test doit permettre de trouver plusieurs fiches, toutes du même état.</li>
	 * 		<ul>
	 * </li>
	 * <li>Test 2 :
	 * 		<ul>
	 * 		<li>Test de la méthode avec un visiteur précis (Andre David - a17)</li>
	 * 		<li>Test de la méthode sans état précis : toutes les fiches de frais sont demandées (TS)</li>
	 * 		<li>Le test doit permettre de trouver plusieurs fiches aux états différents.</li>
	 * 		</ul>
	 * </li>
	 */
	@Test
	public void testSetListeFicheFrais() {

		//-- Test 1
		String etatTest1 = "RB";
		tableAvecParams.setListeFicheFrais(visiteur, etatTest1);
		assertTrue("Aucune fiche de frais trouvée au Test 1", this.tableAvecParams.getListeFicheFrais().size() > 0);
		for(FicheFraisCtrl ficheFraisTest1 : this.tableAvecParams.getListeFicheFrais()) {
			assertTrue("Fiche de frais avec un mauvais etat récupérée au Test 1", ficheFraisTest1.getEtat().getId().equalsIgnoreCase("RB"));
		}
		
		//-- Test 2
		String etatTest2 = "TS";
		tableAvecParams.setListeFicheFrais(visiteur, etatTest2);
		assertTrue("Aucune fiche de frais trouvée au Test 2", this.tableAvecParams.getListeFicheFrais().size() > 0);
		String etatPrecedent = "CL";
		boolean multiplesEtats = false;
		for(FicheFraisCtrl ficheFraisTest2 : this.tableAvecParams.getListeFicheFrais()) {
			if(ficheFraisTest2.getEtat().getId() != etatPrecedent)
				multiplesEtats = true;
		}
		assertTrue("Un seul état de fiche retourné au Test 2", multiplesEtats);
	}

}
