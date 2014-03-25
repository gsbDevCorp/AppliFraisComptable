package views;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class Connexion extends JPanel implements ActionListener {
	
	//-- Attributs
	private JTextField login;
	private JPasswordField mdp;
	private JButton butConnexion;
	private boolean erreurConnexion;
	
	//-- Constructeurs
	public Connexion() {
		this.erreurConnexion = true;
	}
	public JPanel launchPanel() {
		// Définition du JPanel principal
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(Color.gray);
		
		// Définition de la grille
		JPanel grid = new JPanel();
		grid.setBorder(BorderFactory.createLineBorder(Color.black));
		grid.setLayout(new GridLayout(7,1));
		
		// Définition des lignes
		JPanel ligne1 = new JPanel();
		JPanel ligne2 = new JPanel();
		JPanel ligne3 = new JPanel();
		JPanel ligne4 = new JPanel();
		JPanel ligne5 = new JPanel();
		JPanel ligne6 = new JPanel();
		JPanel ligne7 = new JPanel();
		
		// Instanciation des attributs
		this.login = new JTextField(30);
		this.mdp = new JPasswordField(30);
		this.butConnexion = new JButton("Connexion");
		if(this.erreurConnexion) {
			JLabel labelErreur = new JLabel("Couple Identifiant / Mot de passe incorrect.");
			labelErreur.setForeground(new Color(255,0,0));
			ligne7.add(labelErreur);
		}
		
		// Ajout à l'ActionListener
		this.butConnexion.addActionListener(this);
		
		// Ajout des attributs aux lignes
		/**
		 * @TODO ajout logo gsb au dessus de la connexion
		 */
		ligne2.add(new JLabel("Identifiant :"));
		ligne3.add(login);
		ligne4.add(new JLabel("Mot de passe :"));
		ligne5.add(mdp);
		ligne6.add(butConnexion);
		
		// Ajout des lignes à la grille
		grid.add(ligne1);
		grid.add(ligne2);
		grid.add(ligne3);
		grid.add(ligne4);
		grid.add(ligne5);
		grid.add(ligne6);
		grid.add(ligne7);
		
		// Ajout de la grille au panel principal
		mainPanel.add(grid);
		
		return mainPanel;
	}
	
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "Connexion":
			System.out.println("on est ok");
			break;
		default:
			break;
		}
	}
}
