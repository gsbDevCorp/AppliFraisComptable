package views;

import javax.swing.*;
import javax.swing.border.Border;

import controllers.ComptableCtrl;
import models.ComptableMdl;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Vue d'accueil
 * Menu de choix des sections de l'application
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.1
 *
 */
public class Accueil extends JPanel implements ActionListener {
	
	//-- Attributs
	private JButton gererFraisBut, infosPersoBut, deconnexionBut;
	private JLabel comptableLabel, dateLabel, accueilLabel;
	private Fenetre fenetre;
	private ComptableCtrl comptable;
	
	//-- Constructeurs
	public Accueil(Fenetre fenetre, ComptableCtrl comptable) {
		this.fenetre = fenetre;
		this.comptable = comptable;
	}
	public JPanel launchPanel() {
		
		//-- Définition du JPanel principal
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(new Color(141,182,205));
		
		//-- Instanciation des attributs
		this.infosPersoBut = new JButton("Modifier mes informations personnelles");
		this.infosPersoBut.setBackground(new Color(221,72,20));
		this.infosPersoBut.setFont(new Font("Arial", Font.BOLD, 15));
		this.infosPersoBut.setForeground(new Color(255,255,255));
		
		this.gererFraisBut = new JButton("Gérer les fiches de frais");
		this.gererFraisBut.setBackground(new Color(221,72,20));
		this.gererFraisBut.setFont(new Font("Arial", Font.BOLD, 15));
		this.gererFraisBut.setForeground(new Color(255,255,255));
		
		this.deconnexionBut = new JButton("Déconnexion");
		this.deconnexionBut.setBackground(new Color(255,0,0));
		this.deconnexionBut.setFont(new Font("Arial", Font.BOLD, 15));
		this.deconnexionBut.setForeground(new Color(255,255,255));
		
		this.comptableLabel = new JLabel(this.comptable.getPrenom()+" "+this.comptable.getNom());
		this.comptableLabel.setFont(new Font("Arial", Font.BOLD, 15));
		this.comptableLabel.setForeground(new Color(255,255,255));
		
		this.dateLabel = new JLabel(new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE).format(new Date()));
		this.dateLabel.setFont(new Font("Arial", Font.BOLD, 15));
		this.dateLabel.setForeground(new Color(255,255,255));
		
		this.accueilLabel = new JLabel("Gestion des frais pour les visiteurs médicaux");
		this.accueilLabel.setFont(new Font("Arial", Font.BOLD, 15));
		this.accueilLabel.setForeground(new Color(255,255,255));
		
		//-- Ajout à l'ActionListener
		this.gererFraisBut.addActionListener(this);
		this.infosPersoBut.addActionListener(this);
		this.deconnexionBut.addActionListener(this);
		
		//-- Mise en forme
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Comptable (label)
		gbc.gridx = gbc.gridy = 0;
		gbc.gridheight = gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 10, 0, 0);
		mainPanel.add(this.comptableLabel, gbc);
		
		// Date (label)
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 10, 0, 0);
		mainPanel.add(this.dateLabel, gbc);
		
		// Déconnexion (Button)
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(0, 10, 0, 0);
		mainPanel.add(this.deconnexionBut, gbc);
		
		// Accueil (label)
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(5, 10, 0, 0);
		mainPanel.add(this.accueilLabel, gbc);
		
		// Gestion des frais (Button)
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 0, 0);
		mainPanel.add(this.gererFraisBut, gbc);
		
		// Gestion des informations personnelles (Button)
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 0, 0);
		mainPanel.add(this.infosPersoBut, gbc);
		
		
		return mainPanel;
	}
	
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "Gérer les fiches de frais":
			this.fenetre.setActivePanel(new OverviewFrais(this.fenetre, this.comptable).launchPanel());
			break;
		case "Modifier mes informations personnelles":
			this.fenetre.setActivePanel(new ModifInfosPerso(this.fenetre, this.comptable).launchPanel());
			break;
		case "Déconnexion":
			this.fenetre.setActivePanel(new Connexion(this.fenetre).launchPanel());
			break;
		default:
			break;
		}
	}
}
