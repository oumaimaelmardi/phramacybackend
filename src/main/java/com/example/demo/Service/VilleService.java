package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Garde;
import com.example.demo.entity.Pharmacie;
import com.example.demo.entity.Ville;
import com.example.demo.entity.Zone;
import com.example.demo.repository.GardeRepository;
import com.example.demo.repository.PharmacieRepository;
import com.example.demo.repository.VilleRepository;
import com.example.demo.repository.ZoneRepository;

@Service
public class VilleService {
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private ZoneService zoneService;
	@Autowired
	private GardeService gardeService;
	@Autowired
	private PharmacieService pharmacieService;

	public Ville updateVille(int id, Ville ville) {
		Ville existingVille = villeRepository.findById(id);

		existingVille.setNom(ville.getNom());

		return villeRepository.save(existingVille);
	}
  
	public Ville findByNom(String nom) {
		return villeRepository.findByNom(nom);
	}

	public Ville findById(int id) {
		return villeRepository.findById(id);
	}

	public int save(Ville entity) {
		if (findById(entity.getId()) != null) {
			return -1;
		} else {
			villeRepository.save(entity);
			return 1;
		}
	}

	public List<Ville> findAll() {
		return villeRepository.findAll();
	}

	public void deleteById(int id) {
		villeRepository.deleteById(id);
	}

	public List<Zone> findByVille(int id) {
		Ville ville = villeRepository.findById(id);
		return ville.getZones();

	}

	public List<Pharmacie> findPharmacieByVilleByZone(String ville, String zone) {
		Ville nom_ville = villeRepository.findByNom(ville);
		Zone zone_name = zoneService.findByNom(zone);

		List<Zone> zonesByVille = nom_ville.getZones();
		for (Zone z : zonesByVille) {
			if (z.equals(zone_name)) {
				return z.getPharmacies();
			}
		}
		return null;
	}
	public void update(Ville ville) {
		villeRepository.save(ville);
	}	

}
