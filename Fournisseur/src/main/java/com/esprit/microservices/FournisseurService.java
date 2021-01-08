package com.esprit.microservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class FournisseurService {
	@Autowired
	private FournisseurRepository FournisseurRepository;
	public Fournisseur addFournisseur(Fournisseur fournisseur) {
		return FournisseurRepository.save(fournisseur);
	}
	public Fournisseur updateFournisseur(int id, Fournisseur newFournisseur) {
		if (FournisseurRepository.findById(id).isPresent()) {
			Fournisseur existingf =FournisseurRepository.findById(id).get();
			existingf.setNomf(newFournisseur.getNomf());
			existingf.setMobile(newFournisseur.getMobile());
			existingf.setEmail(newFournisseur.getEmail());

			return FournisseurRepository.save(existingf);
		} else
			return null;
	}
	
	public String deleteFournisseur(int id) {
		if (FournisseurRepository.findById(id).isPresent()) {
			FournisseurRepository.deleteById(id);
			return " supprimé";
		} else
			return "non supprimé";
	}
}
