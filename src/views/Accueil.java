package views;

import javax.swing.*;
import javax.swing.border.Border;

import models.ComptableMdl;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Vue de Connexion
 * Gestion de la connexion
 * 
 * @author Robin BILLY - SIO2
 * Package views
 * @version 1.0.1
 *
 */
public class Accueil extends JPanel implements ActionListener {
	
	//-- Attributs
	private JButton butGererFrais, butInfosPerso;
	private Fenetre fenetre;
	
	//-- Constructeurs
	public Accueil(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
	public JPanel launchPanel() {
		// Définition du JPanel principal
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(new Color(141,182,205));
		
		// Définition de la grille
		JPanel grid = new JPanel();
		grid.setBorder(BorderFactory.createLineBorder(Color.black));
		grid.setLayout(new GridLayout(4,1));
		
		// Définition des lignes
		JPanel ligne1 = new JPanel();
		JPanel ligne2 = new JPanel();
		JPanel ligne3 = new JPanel();
		JPanel ligne4 = new JPanel();
		
		// Instanciation des attributs
		this.butGererFrais = new JButton("Gérer les fiches de frais");
		this.butGererFrais.setBackground(new Color(141,182,205));
		this.butInfosPerso = new JButton("Modifier mes informations personnelles");
		this.butInfosPerso.setBackground(new Color(141,182,205));
		
		// Ajout à l'ActionListener
		this.butGererFrais.addActionListener(this);
		this.butInfosPerso.addActionListener(this);
		
		// Ajout des attributs aux lignes
		ligne1.add(new JLabel("Levis Smith"));
		ligne2.add(new JLabel(new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).format(new Date())));
		ligne3.add(this.butGererFrais);
		ligne4.add(this.butInfosPerso);
		
		// Ajout des lignes à la grille
		grid.add(ligne1);
		grid.add(ligne2);
		grid.add(ligne3);
		grid.add(ligne4);
		
		// Ajout de la grille au panel principal
		mainPanel.add(grid);
		
		return mainPanel;
	}
	
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "Gérer les fiches de frais":
			
			break;
		case "Modifier mes informations personnelles":
			this.fenetre.setActivePanel(new ModifInfosPerso(this.fenetre).launchPanel());
			break;
		default:
			break;
		}
	}
}
