package com.example.demo.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.VilleService;
import com.example.demo.entity.Pharmacie;
import com.example.demo.entity.Ville;
import com.example.demo.entity.Zone;
import com.example.demo.repository.GardeRepository;
import com.example.demo.repository.PharmacieRepository;
import com.example.demo.repository.VilleRepository;
import com.example.demo.repository.ZoneRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("villes")
public class VilleRest {

	@Autowired
	private VilleService villeService;

	@GetMapping("/all")

	public List<Ville> findAll() {
		return villeService.findAll();
	}
  @Transactional
	@DeleteMapping("/deleteVille/{id}")
	public void deleteById(@PathVariable int id) {
		villeService.deleteById(id);
	}

	/*@PutMapping("/updateVille/{id}")
    public ResponseEntity<Ville> updateVille(@PathVariable int id, @RequestBody Ville ville) {
        Ville updatedVille = villeService.updateVille(id, ville);
        return ResponseEntity.ok(updatedVille);
    }*/
	@PutMapping("/update")
	public void update(@RequestBody Ville ville) {
		villeService.update(ville);
	}

	@PostMapping("/save")
	public void save(@RequestBody Ville ville) {
		villeService.save(ville);
	}

	@GetMapping("/{id}/zones")
	public List<Zone> findByVille(@PathVariable int id) {

		return villeService.findByVille(id);

	}

	@GetMapping("/{id}")
	public Ville findById(@PathVariable int id) {
		return villeService.findById(id);
	}

	@GetMapping("/{ville}/{zone}/pharmacies")
	public List<Pharmacie> findPharmacieByVilleByZone(@PathVariable String ville, @PathVariable String zone) {
		return villeService.findPharmacieByVilleByZone(ville, zone);
	}

}
