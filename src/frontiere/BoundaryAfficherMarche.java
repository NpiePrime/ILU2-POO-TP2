package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {

		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		} else {
			System.out.println(nomAcheteur + ", vous trouverez au marché :");
			int j = 0;
			while (j<infosMarche.length) {
				String vendeur = infosMarche[j%3];
				String quantite = infosMarche[(j%3) +1];
				String produit = infosMarche[(j%3) + 2];
				System.out.println("-" + vendeur + " qui vend " + quantite + " " + produit);
				j++;
			}
			
		}
	}
}
