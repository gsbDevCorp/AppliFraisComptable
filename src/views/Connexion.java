package views;

import javax.swing.*;

import overrides.JPassword;
import controllers.ComptableCtrl;
import models.ComptableMdl;

import java.awt.*;
import java.awt.event.*;

/**
 * Vue de Connexion
 * Gestion de la connexion
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.1
 *
 */
public class Connexion extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8708924523414443376L;
	//-- Attributs
	private JTextField loginText;
	private JPassword passwordText;
	private JButton connexionBut;
	private JLabel loginLabel, passwordLabel;
	private Fenetre fenetre;
	
	//-- Constructeurs
	public Connexion(Fenetre fenetre) {
		this.fenetre = fenetre;
	}
	public JPanel launchPanel() {
		
		//-- Définition du JPanel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setBackground(new Color(141,182,205));
		
		//-- Instanciation des attributs
		this.loginLabel = new JLabel("Identifiant :");
		this.loginLabel.setForeground(new Color(255,255,255));
		this.loginLabel.setFont(new Font("Arial", Font.BOLD, 15));
		this.loginText = new JTextField(20);
		
		this.passwordLabel = new JLabel("Mot de passe :");
		this.passwordLabel.setForeground(new Color(255,255,255));
		this.passwordLabel.setFont(new Font("Arial", Font.BOLD, 15));
		this.passwordText = new JPassword(20);
		
		this.connexionBut = new JButton("Connexion");
		this.connexionBut.setBackground(new Color(221,72,20));
		this.connexionBut.setFont(new Font("Arial", Font.BOLD, 15));
		this.connexionBut.setForeground(new Color(255,255,255));
		
		//-- Ajout à l'ActionListener
		this.connexionBut.addActionListener(this);
		
		//-- Mise en forme
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Identifiant (label)
		gbc.gridx = gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 10, 0, 0);
		mainPanel.add(this.loginLabel, gbc);
		
		// Identifiant (text)
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 10, 0, 0);
		mainPanel.add(this.loginText, gbc);
		
		// Mot de passe (label)
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(5, 10, 0, 0);
		mainPanel.add(this.passwordLabel, gbc);
		
		// Mot de passe (text)
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight =  1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(0, 10, 0, 0);
		mainPanel.add(this.passwordText, gbc);
		
		// Connexion
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.insets = new Insets(10, 10, 0, 0);
		mainPanel.add(this.connexionBut, gbc);
		
		//-- Retour du panel
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
		String stringMdp = this.passwordText.transformString();
		//-- Traitement des informations avec le modèle
		try {
			ComptableCtrl comptable = ComptableMdl.connexionComptable(this.loginText.getText(), stringMdp);
			if(comptable == null) {
				final ImageIcon icon = new ImageIcon("img/gsb.png");
				JOptionPane.showMessageDialog(null,"Le couple identifiant/mot de passe est incorrect.","AppliFrais - Comptable",JOptionPane.ERROR_MESSAGE, icon);
			}
			else
				fenetre.setActivePanel(new Accueil(fenetre,comptable).launchPanel());
		}
		catch(Exception e) {
			System.out.println("[Connexion] - ERREUR - Erreur lors du traitement des données : " + e);
		}
	}
	
	@Override
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
