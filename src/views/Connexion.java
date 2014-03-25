package views;

import javax.swing.*;
import javax.swing.border.Border;

import models.ComptableMdl;

import java.awt.*;
import java.awt.event.*;

/**
 * Vue de Connexion
 * Gestion de la connexion
 * 
 * @author Robin BILLY - SIO2
 * @package views
 * @version 1.0.1
 *
 */
public class Connexion extends JPanel implements ActionListener {
	
	//-- Attributs
	private JTextField login;
	private JPasswordField mdp;
	private JButton butConnexion;
	private Fenetre fenetre;
	
	//-- Constructeurs
	public Connexion(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
	public JPanel launchPanel() {
		// Définition du JPanel principal
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(new Color(141,182,205));
		
		// Définition de la grille
		JPanel grid = new JPanel();
		grid.setBackground(new Color(255,255,255));
		grid.setBorder(BorderFactory.createLineBorder(Color.black));
		grid.setLayout(new GridLayout(5,1));
		
		// Définition des lignes
		JPanel ligne1 = new JPanel();
		JPanel ligne2 = new JPanel();
		JPanel ligne3 = new JPanel();
		JPanel ligne4 = new JPanel();
		JPanel ligne5 = new JPanel();
		ligne1.setBackground(new Color(255,255,255));
		ligne2.setBackground(new Color(255,255,255));
		ligne3.setBackground(new Color(255,255,255));
		ligne4.setBackground(new Color(255,255,255));
		ligne5.setBackground(new Color(255,255,255));
		
		// Instanciation des attributs
		this.login = new JTextField(30);
		this.mdp = new JPasswordField(30);
		this.butConnexion = new JButton("Connexion");
		this.butConnexion.setBackground(new Color(141,182,205));
		
		// Ajout à l'ActionListener
		this.butConnexion.addActionListener(this);
		
		// Ajout des attributs aux lignes
		ligne1.add(new JLabel("Identifiant :"));
		ligne2.add(login);
		ligne3.add(new JLabel("Mot de passe :"));
		ligne4.add(mdp);
		ligne5.add(butConnexion);
		
		// Ajout des lignes à la grille
		grid.add(ligne1);
		grid.add(ligne2);
		grid.add(ligne3);
		grid.add(ligne4);
		grid.add(ligne5);
		
		// Ajout de la grille au panel principal
		mainPanel.add(grid);
		
		return mainPanel;
	}
	
	/**
	 * Gestion de la connexion des comptables
	 * 
	 */
	private void connexionComptable() {
		/*
		 * Passage du mot de passe en clair pour traitements modèle
		 */
		char[] charMdp = this.mdp.getPassword();
		String stringMdp = new String(charMdp);
		//-- Traitement des informations avec le modèle
		try {
			int retourModele = ComptableMdl.connexionComptable(this.login.getText(), stringMdp);
			if(retourModele != 1) {
				final ImageIcon icon = new ImageIcon("img/logo.jpg");
				JOptionPane.showMessageDialog(null,"Le couple identifiant/mot de passe est incorrect.","AppliFrais - Comptable",JOptionPane.ERROR_MESSAGE, icon);
			}
			else {
				fenetre.setActivePanel(new Accueil(fenetre).launchPanel());
			}
	
		}
		catch(Exception e) {
			System.out.println("[Connexion] - ERREUR - Erreur lors du traitement des données : " +e);
		}
		
	}
	
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "Connexion":
			this.connexionComptable();
			break;
		default:
			break;
		}
	}
}
