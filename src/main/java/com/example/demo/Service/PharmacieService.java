package com.example.demo.Service;

import java.util.ArrayList;
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
public class PharmacieService {

	@Autowired
	private PharmacieRepository pharmacieRepository;
	@Autowired
	private ZoneService zoneService;
	@Autowired
	private VilleService villeService;
	@Autowired
	private GardeService gardeService;

	
	public List<Pharmacie> findPharmacyByZone(int zone){
		Zone zone_name = zoneService.findById(zone);
		List<Pharmacie> pharmacies = new ArrayList<>();
		for (Pharmacie z : zone_name.getPharmacies()) {
			pharmacies.add(z);
		}
		return pharmacies;
		
		 
	 }
	public List<Pharmacie> findPharmaciesByVille(int villeId) {
	    return pharmacieRepository.findByZoneVilleId(villeId);
	}

	public List<Pharmacie> findPharmacieByZoneByGarde(int ville, int zone, String garde) {
		Ville nom_ville = villeService.findById(ville);
		Zone zone_name = zoneService.findById(zone);
		Garde garde_nom = gardeService.findByType(garde);

		List<Pharmacie> pharmacies = new ArrayList<>();

		for (Zone z : nom_ville.getZones()) {
			if (z.equals(zone_name)) {
				List<Pharmacie> pharmaciesInZone = z.getPharmacies();
				for (Pharmacie pharmacie : pharmaciesInZone) {
					if (pharmacie.getGardes().contains(garde_nom)) {
						pharmacies.add(pharmacie);
					}
				}
			}
		}

		return pharmacies;
		
		
	}
	
	public void update(Pharmacie pharmacie) {
		pharmacieRepository.save(pharmacie);
	}
	public void deleteById(Integer id) {
		pharmacieRepository.deleteById(id);
	}


	public Pharmacie findById(int id) {
		Pharmacie pharmacie = pharmacieRepository.findById(id);

		return pharmacie;

	}

	public int  save(Pharmacie entity) {
		 pharmacieRepository.save(entity);
		 return 1;
	}

	public List<Pharmacie> findAll() {
		return pharmacieRepository.findAll();
	}
	
	

	/*@Override
	public List<Pharmacie> findPharmacieByZoneByGarde(String ville, String zone, String garde) {
		Ville nom_ville = villeRepository.findByNom(ville);
		Zone zone_name = zoneRepository.findByNom(zone);
		Garde garde_nom = gardeRepository.findByType(garde);

		List<Pharmacie> pharmacies = new ArrayList<>();

		for (Zone z : nom_ville.getZones()) {
			if (z.equals(zone_name)) {
				List<Pharmacie> pharmaciesInZone = z.getPharmacies();
				for (Pharmacie pharmacie : pharmaciesInZone) {
					if (pharmacie.getGardes().contains(garde_nom)) {
						pharmacies.add(pharmacie);
					}
				}
			}
		}

		return pharmacies;
	}*/

}
