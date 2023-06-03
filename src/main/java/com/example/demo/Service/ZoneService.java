package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Ville;
import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;



@Service
public class ZoneService {
	@Autowired
	private ZoneRepository zoneRepository;
	
	public Zone findByNom(String nom) {
		return zoneRepository.findByNom(nom);
		
	}
	
	public void update(Zone zone) {
		zoneRepository.save(zone);
	}	
	

	public Zone findById(int id) {
		return zoneRepository.findById(id);
	}

	public int save(Zone entity) {
		if (findById(entity.getId()) != null) {
			return -1;
		} else {
			zoneRepository.save(entity);
			return 1;
		}
	}

	public List<Zone> findAll() {
		return zoneRepository.findAll();
	}

	public void deleteById(Integer id) {
		zoneRepository.deleteById(id);
	}

	

}
