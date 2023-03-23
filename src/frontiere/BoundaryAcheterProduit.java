package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		// TODO Ã  completer
		StringBuilder question = new StringBuilder();
		StringBuilder question2 = new StringBuilder();
		int produitAchete;
		String produit;
		int quantiteProduit;
		String nomVendeur;
		Etal etalVendeur;
		Gaulois[] vendeurs;
		int choixUtilisateur = 0;

		System.out.println("Quel produit voulez-vous acheter?");
		produit = scan.next();
		vendeurs = controlAcheterProduit.trouverVendeurProduit(produit);
		
		
		question.append("Chez quel commerçant voulez-vous acheter vos " + produit + " ?\n");
		for (int i = 0; i < vendeurs.length; i++) {
			question.append((i + 1) + " - " + vendeurs[i].getNom() + "\n");
		}
		
		do {
			choixUtilisateur = Clavier.entrerEntier(question.toString());
		} while (choixUtilisateur == 0 && choixUtilisateur > vendeurs.length);
		
		nomVendeur = vendeurs[choixUtilisateur - 1].getNom();
		etalVendeur = controlAcheterProduit.trouverEtalVendeur(nomVendeur);
		System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur + ".");
		question2.append("Bonjour " + nomAcheteur + "\n");
		question2.append("Combien de " + produit + " voulez-vous acheter?\n");
		quantiteProduit = Clavier.entrerEntier(question2.toString());
		produitAchete = controlAcheterProduit.acheterProduit(etalVendeur, quantiteProduit);
		System.out.println(nomAcheteur + " a acheté " + quantiteProduit + " de " + produit + " à " + nomVendeur + ".");

	}
}
