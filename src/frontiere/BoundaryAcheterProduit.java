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
		StringBuilder question = new StringBuilder();
		StringBuilder question2 = new StringBuilder();
		String produit;
		int quantiteProduit;
		String nomVendeur;
		Etal etalVendeur;
		Gaulois[] vendeurs;
		int choixUtilisateur = 0;
		if (controlAcheterProduit.verifierIdentite(nomAcheteur)) {

			System.out.println("Quel produit voulez-vous acheter?");
			produit = scan.next();

			vendeurs = controlAcheterProduit.trouverVendeurProduit(produit);
			if (vendeurs != null) {
				question.append("Chez quel commer�ant voulez-vous acheter vos " + produit + " ?\n");
				for (int i = 0; i < vendeurs.length; i++) {
					question.append((i + 1) + " - " + vendeurs[i].getNom() + "\n");
				}
				do {
					choixUtilisateur = Clavier.entrerEntier(question.toString());
				} while (choixUtilisateur == 0 && choixUtilisateur > vendeurs.length);

				nomVendeur = vendeurs[choixUtilisateur - 1].getNom();
				etalVendeur = controlAcheterProduit.trouverEtalVendeur(nomVendeur);
				System.out.println(nomAcheteur + " se d�place jusqu'� l'�tal du vendeur " + nomVendeur + ".");
				question2.append("Bonjour " + nomAcheteur + "\n");
				question2.append("Combien de " + produit + " voulez-vous acheter?\n");
				quantiteProduit = Clavier.entrerEntier(question2.toString());

				if (etalVendeur.getQuantite() == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantiteProduit + " " + produit
							+ ", malheureusement  il n'y en a plus.");
					
				} else if (quantiteProduit > etalVendeur.getQuantite()) {
					controlAcheterProduit.acheterProduit(etalVendeur, quantiteProduit);
					System.out.println(nomAcheteur + " veut acheter " + quantiteProduit + " " + produit
							+ ", malheureusement " + nomVendeur + " n'en a plus que " + etalVendeur.getQuantite() + ". "
							+ nomAcheteur + " ach�te tout le stock.");
				} else {
					controlAcheterProduit.acheterProduit(etalVendeur, quantiteProduit);
					System.out.println(
							nomAcheteur + " a achet� " + quantiteProduit + " de " + produit + " � " + nomVendeur + ".");
				}
			} else {
				System.out.println("D�sol�, personne ne vend ce produit au march�.");
			}
		} else {
			System.out.println(
					"Je suis d�sol� " + nomAcheteur + " mais il faut �tre habitant de ce village pour commercer ici.");
		}
	}
}
