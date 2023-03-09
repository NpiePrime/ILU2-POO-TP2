package controleur;

import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	//TODO a completer
//	public boolean verifierIdentite(String nomAcheteur) {
//		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
//	}
//	
////	public Etal trouverEtalProduit(String produit) {
//////		Etal etal = null;
//////		etal.contientProduit(produit);
//////		return etal;
////	}
//	
//	public void acheterProduit(String nomAcheteur) {
//		
//		
//	}
}
