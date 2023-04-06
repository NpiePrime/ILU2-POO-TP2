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

			for (int j = 0; j<infosMarche.length; j+=3) {
				String vendeur = infosMarche[j];
				String quantite = infosMarche[j +1];
				String produit = infosMarche[j + 2];
				System.out.println("-" + vendeur + " qui vend " + quantite + " " + produit);
			}
			
		}
	}
}
