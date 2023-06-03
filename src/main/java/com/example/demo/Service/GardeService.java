package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Garde;
import com.example.demo.entity.Pharmacie;
import com.example.demo.repository.GardeRepository;

@Service
public class GardeService {
	@Autowired
	private GardeRepository gardeRepository;
	
	public List<Garde> findAll() {
		return gardeRepository.findAll();
	}
	public Garde findById(int id) {
		return gardeRepository.findById(id);
	}
	public Garde findByType(String type) {
		
		return gardeRepository.findByType(type);
	}
	/*@Transactional
    public void assignGardeToPharmacie(int gardeId, Pharmacie pharmacie) {
        Garde garde = gardeRepository.findById(gardeId).orElseThrow(() ->
                new IllegalArgumentException("Invalid Garde ID"));

        garde.getPharmacies().add(pharmacie);
        pharmacie.getGardes().add(garde);

        gardeRepository.save(garde);
    }*/

}
