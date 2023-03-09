package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		//TODO a completer
		
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis d�sol� " + nomVendeur + " mais il faut �tre un habitant de notre village pour commercer ici.");
		} else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un �tal.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("D�sol� " + nomVendeur + "je n'ai plus d'�tal qui ne soit pas d�j� occup�.");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
		StringBuilder question = new StringBuilder();
		String produit = " ";
		int nbProduit;
		int numeroEtal = -1;
		question.append("C'est parfait, il me reste un �tal pour vous !\n");
		question.append("Il me faudrait quelques renseignements :\n");
		question.append("Quel produit souhaitez-vous vendre ?\n");
		System.out.println(question.toString());
		produit = scan.next();
		nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?\n");
		numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est install� � l'�tal n� " + numeroEtal + ".");
		}
	}
}
