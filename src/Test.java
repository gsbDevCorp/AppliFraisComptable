import java.util.ArrayList;

import models.*;
import controllers.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<VisiteurCtrl> liste =  VisiteurMdl.getAllVisitors();
		for(VisiteurCtrl visiteur : liste) {
			System.out.println(visiteur.getId() + " - " + visiteur.getNom() + " " + visiteur.getPrenom());
		}
	}

}
