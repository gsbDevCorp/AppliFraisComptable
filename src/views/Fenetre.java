package views;

import java.awt.*;

import javax.swing.*;

/**
 * ---------------------------------
 * Gestion de la fenêtre
 * ---------------------------------
 * 
 * @author Robin BILLY - SIO2
 * @version 1.0.0
 *
 */
public class Fenetre extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6364306074999260900L;

	public Fenetre() {
		//-- Définition de la fenêtre de base
		this.setTitle("AppliFrais - Comptable");
		this.setIconImage(new ImageIcon("img/gsb.png").getImage());
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		//this.setSize(1000, 650);
		this.setMinimumSize(new Dimension(1000, 650));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setVisible(true);
	}
	
	public void setActivePanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.getContentPane().revalidate();
	}
}
