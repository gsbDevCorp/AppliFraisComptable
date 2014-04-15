package views;

import javax.swing.*;

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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3752300838132144956L;
	//-- Attributs
	private JButton validerBut, retourBut, deconnexionBut;
	private JLabel comptableLabel, dateLabel, accueilLabel;
	
	private JLabel oldLabel, newLabel, c_newLabel;
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
		
		//-- Instanciation des attributs
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

		this.accueilLabel = new JLabel("Modification des informations personnelles");
		this.accueilLabel.setFont(new Font("Arial", Font.BOLD, 15));
		this.accueilLabel.setForeground(new Color(255,255,255));
		
		this.oldLabel = new JLabel("Ancien mot de passe :");
		this.newLabel = new JLabel("Nouveau mot de passe :");
		this.c_newLabel = new JLabel("Confirmation du mot de passe :");
		
		this.oldPasswd = new JPassword(20);
		this.newPasswd = new JPassword(20);
		this.c_newPasswd = new JPassword(20);
		
		this.validerBut = new JButton("Valider les informations");
		this.retourBut = new JButton("Retour");
		
		//-- Ajout à l'ActionListener
		this.validerBut.addActionListener(this);
		this.retourBut.addActionListener(this);
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
		
		// Ancien mot de passe (label)
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(25, 10, 0, 0);
		mainPanel.add(this.oldLabel, gbc);
		
		// Ancien mot de passe (Password)
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 10, 0, 0);
		mainPanel.add(this.oldPasswd, gbc);
		
		// Nouveau mot de passe (label)
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(5, 10, 0, 0);
		mainPanel.add(this.newLabel, gbc);
		
		// Nouveau mot de passe (Password)
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 10, 0, 0);
		mainPanel.add(this.newPasswd, gbc);
		
		// Confirmation nouveau mot de passe (label)
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(5, 10, 0, 0);
		mainPanel.add(this.c_newLabel, gbc);
		
		// Confirmation nouveau mot de passe (Password)
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 10, 0, 0);
		mainPanel.add(this.c_newPasswd, gbc);
		
		// Valider (Button)
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.insets = new Insets(15, 10, 0, 0);
		mainPanel.add(this.validerBut, gbc);
		
        // Retour (Button)
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridheight = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.anchor = GridBagConstraints.BASELINE;
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(10, 10, 0, 10);
		mainPanel.add(this.retourBut, gbc);
		
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
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object evt = event.getSource();
		if(evt.equals(this.validerBut))
			this.setPassword();
		if(evt.equals(this.retourBut))
			this.fenetre.setActivePanel(new Accueil(this.fenetre,this.comptable).launchPanel());
	}
}
