import java.util.ArrayList;

import models.*;
import controllers.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*ArrayList<VisiteurCtrl> liste =  VisiteurMdl.getAllVisitors();
		for(VisiteurCtrl visiteur : liste) {
			System.out.println(visiteur.getId() + " - " + visiteur.getNom() + " " + visiteur.getPrenom());
		}*/
		//System.out.println(VisiteurMdl.getNbVisitors());
		ArrayList<FraisForfaitCtrl> liste = FraisForfaitMdl.getFraisForfait("a131", "201001");
		for(FraisForfaitCtrl frais : liste) {
			System.out.println(frais.getIdFraisForfait() + " - " + frais.getQuantite());
		}
	}
}