package com.esprit.microservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service

public class SAVService {
	@Autowired
	private SAVRepository SAVRepository;
	public SAV addSAV(SAV sav) {
		return SAVRepository.save(sav);
	}
	public SAV updateSAV(int id, SAV newSav) {
		if (SAVRepository.findById(id).isPresent()) {
		SAV existingSAV = SAVRepository.findById(id).get();
		    existingSAV.setSatstisfaction(newSav.getSatstisfaction());
		    existingSAV.setAvis(newSav.getAvis());
		    

			return SAVRepository.save(existingSAV);
		} else
			return null;
	}
	
	public String deleteSAV(int id) {
		if (SAVRepository.findById(id).isPresent()) {
			SAVRepository.deleteById(id);
			return "supprimé";
		} else
			return "supprimé";
	}
}
