package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	
	@Autowired
	private UserRep candidateRepository;

	public User addCandidat(User candidate) {
		return candidateRepository.save(candidate);
	}
	
	public User updateCandidat(int id, User newCandidat) {
		if (candidateRepository.findById(id).isPresent()) {
			User existingCandidat = candidateRepository.findById(id).get();
			existingCandidat.setNom(newCandidat.getNom());
			existingCandidat.setPrenom(newCandidat.getPrenom());
			existingCandidat.setEmail(newCandidat.getEmail());
			existingCandidat.setAdress(newCandidat.getAdress());
			existingCandidat.setRole_id(newCandidat.getRole_id());
			

			return candidateRepository.save(existingCandidat);
		} else
			return null;
	}
	
	public String deleteCandidat(int id) {
		if (candidateRepository.findById(id).isPresent()) {
			candidateRepository.deleteById(id);
			return "User supprimé";
		} else
			return "User non supprimé";
	}

}
