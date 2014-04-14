package controllers;

/**
 * 
 * Gestion des comptables<br>
 * Seuls les comptables peuvent accéder à l'application.
 * 
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class ComptableCtrl {

	//-- Attributs
	
	private int id;
	private String nom, prenom;
	
	//-- Constructeurs
	
	/**
	 * Constructeur ComptableCtrl sans paramètres
	 */
	public ComptableCtrl() {
	}
	
	/**
	 * Constructeur ComptableCtrl avec paramètres<br>
	 * L'ensemble des attributs du comptable ne sont pas récupérés,
	 * seul son identifiant, son nom et son prénom sont utiles pour l'application.
	 * 
	 * @param id int
	 * @param nom String
	 * @param prenom String
	 */
	public ComptableCtrl(int id, String nom, String prenom) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	//-- Accesseurs | Modificateurs
	
	/**
	 * Accesseur id
	 * 
	 * @return String
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Modificateur id
	 * 
	 * @param id String
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Accesseur nom
	 * 
	 * @return String
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Modificateur nom
	 * 
	 * @param nom String
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Accesseur prenom
	 * 
	 * @return String
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Modificateur prenom
	 * 
	 * @param prenom String
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
