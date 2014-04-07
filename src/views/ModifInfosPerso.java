package views;

import javax.swing.*;
import javax.swing.border.Border;

import models.ComptableMdl;

import overrides.JPassword;

import controllers.ComptableCtrl;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Vue de modification des informations personnelles
 * Permet de modifier le mot de passe
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class ModifInfosPerso extends JPanel implements ActionListener {
	
	//-- Attributs
	private JButton butValiderModif, butRetour;
	private JPassword oldPasswd, newPasswd, c_newPasswd;
	private Fenetre fenetre;
	private ComptableCtrl comptable;
	
	//-- Constructeurs
	public ModifInfosPerso(Fenetre fenetre, ComptableCtrl comptable) {
		this.fenetre = fenetre;
		this.comptable = comptable;
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
		ligne1.setBackground(new Color(141,182,185));
		ligne1.setBorder(BorderFactory.createLineBorder(Color.black));
		ligne2.setBackground(new Color(255,255,255));
		ligne3.setBackground(new Color(255,255,255));
		
		// Grid formulaire
		JPanel gridFormulaire = new JPanel();
		gridFormulaire.setLayout(new GridLayout(3,2));
		gridFormulaire.setBackground(new Color(255,255,255));
		grid.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
		
		// Instanciation des attributs
		this.oldPasswd = new JPassword(20);
		this.newPasswd = new JPassword(20);
		this.c_newPasswd = new JPassword(20);
		this.butValiderModif = new JButton("Valider les modifications");
		this.butValiderModif.setBackground(new Color(34,139,34));
		this.butValiderModif.setForeground(new Color(255,255,255));
		this.butRetour = new JButton("Retour");
		this.butRetour.setBackground(new Color(141,182,205));
		
		// Ajout à l'ActionListener
		this.butValiderModif.addActionListener(this);
		this.butRetour.addActionListener(this);
		
		// Ajout des attributs aux lignes
		ligne1.add(new JLabel("Informations personnelles :"));
		gridFormulaire.add(new JLabel("Ancien mot de passe :"));
		gridFormulaire.add(this.oldPasswd);
		gridFormulaire.add(new JLabel("Nouveau mot de passe :"));
		gridFormulaire.add(this.newPasswd);
		gridFormulaire.add(new JLabel("Confirmation du mot de passe :"));
		gridFormulaire.add(this.c_newPasswd);
		ligne2.add(this.butValiderModif);
		ligne3.add(this.butRetour);
		
		// Ajout des lignes à la grille
		grid.add(ligne1);
		grid.add(gridFormulaire);
		grid.add(ligne2);
		grid.add(ligne3);
		
		// Ajout de la grille au panel principal
		mainPanel.add(grid);
		
		return mainPanel;
	}
	
	private void setPassword() {
		String oldPasswd = this.oldPasswd.transformString();
		String newPasswd = this.newPasswd.transformString();
		String c_newPasswd = this.c_newPasswd.transformString();
		
		//-- Vérification de la saisie
		if(!oldPasswd.isEmpty() && !newPasswd.isEmpty() && !c_newPasswd.isEmpty()) {
			//-- Comparaison des nouveaux mots de passe
			if(newPasswd.equals(c_newPasswd)) {
				//-- Comparaison à l'ancien mot de passe
				if(!oldPasswd.equals(newPasswd)) {
					//-- Vérification de la validité de l'ancien mot de passe (contrôle d'identité)
					if(ComptableMdl.checkPassword(this.comptable.getId(), oldPasswd)) {
						try {
							ComptableMdl.setPassword(this.comptable.getId(), newPasswd);
							final ImageIcon icon = new ImageIcon("img/gsb.png");
							JOptionPane.showMessageDialog(null,"Modification du mot de passe effectuée avec succès.","AppliFrais - Comptable",JOptionPane.INFORMATION_MESSAGE, icon);
						}
						catch(Exception e) {
							System.err.println("[ModifsInfosPerso] - ERREUR - Erreur lors du traitement des données : " + e);
							final ImageIcon icon = new ImageIcon("img/gsb.png");
							JOptionPane.showMessageDialog(null,"Erreur lors de la modification du mot de passe, merci de réessayer dans quelques minutes.","AppliFrais - Comptable",JOptionPane.ERROR_MESSAGE, icon);
						}
					}
					else {
						final ImageIcon icon = new ImageIcon("img/gsb.png");
						JOptionPane.showMessageDialog(null,"L'ancien mot de passe est invalide.","AppliFrais - Comptable",JOptionPane.ERROR_MESSAGE, icon);
					}
				}
				else {
					final ImageIcon icon = new ImageIcon("img/gsb.png");
					JOptionPane.showMessageDialog(null,"Le nouveau mot de passe ne doit pas être identique à l'ancien mot de passe.","AppliFrais - Comptable",JOptionPane.ERROR_MESSAGE, icon);
				}
			}
			else {
				final ImageIcon icon = new ImageIcon("img/gsb.png");
				JOptionPane.showMessageDialog(null,"Le nouveau mot de passe saisi ne correspond pas à la confirmation.","AppliFrais - Comptable",JOptionPane.ERROR_MESSAGE, icon);
			}
		}
		else {
			final ImageIcon icon = new ImageIcon("img/gsb.png");
			JOptionPane.showMessageDialog(null,"Tous les champs doivent être saisis.","AppliFrais - Comptable",JOptionPane.ERROR_MESSAGE, icon);
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		switch (event.getActionCommand()) {
		case "Valider les modifications":
			this.setPassword();
			break;
		case "Retour":
			this.fenetre.setActivePanel(new Accueil(this.fenetre,this.comptable).launchPanel());
			break;
		default:
			break;
		}
	}
}
