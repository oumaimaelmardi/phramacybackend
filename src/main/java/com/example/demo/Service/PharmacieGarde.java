package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Garde_PharmaciePK;
import com.example.demo.entity.Pharmacie;
import com.example.demo.entity.Pharmacie_service;
import com.example.demo.entity.Ville;
import com.example.demo.repository.GardeRepository;
import com.example.demo.repository.PharmacieGardeRepo;

@Service
public class PharmacieGarde {
	@Autowired
	private PharmacieGardeRepo pharmacieGardeRepo;

	public List<Pharmacie_service> findAll() {
		return pharmacieGardeRepo.findAll();
	}

	public int save(Pharmacie_service entity) {
		pharmacieGardeRepo.save(entity);
		 return 1;
	}

	
	/*public int deleteById(Garde_PharmaciePK id) {
		return pharmacieGardeRepo.deleteById(id);
	}*/

	public void update(Pharmacie_service pharmacieGarde) {
		pharmacieGardeRepo.save(pharmacieGarde);
	}

	public List<Pharmacie_service> findByPharmacieGardesId(int gardeId) {
		return pharmacieGardeRepo.findByPharmacieGardesId(gardeId);
	}

	public void deleteById(Garde_PharmaciePK id) {
		pharmacieGardeRepo.deleteById(id);
	}
	
	
	

	
	
	
	
	
	

}
