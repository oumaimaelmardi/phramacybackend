package com.example.demo.ws;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.GardeService;
import com.example.demo.Service.PharmacieService;
import com.example.demo.Service.VilleService;
import com.example.demo.Service.ZoneService;

import com.example.demo.entity.Garde;
import com.example.demo.entity.Pharmacie;
import com.example.demo.entity.Ville;
import com.example.demo.entity.Zone;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("pharmacies")
public class PharmacieRest {
	
	@Autowired
	private PharmacieService pharmacieService;
	@Autowired
	private ZoneService zoneService;
	@Autowired
	private VilleService villeService;
	@Autowired
	private GardeService gardeService;

	
	

	

	

	
	
	
	
	
	
	@GetMapping("/all")
	public List<Pharmacie> findAll() {
		return pharmacieService.findAll();
	}

	@PostMapping("/save")
	public int save(@RequestBody Pharmacie entity) {
		return pharmacieService.save(entity);
	}
	@Transactional
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id) {
		pharmacieService.deleteById(id);
	}

	@GetMapping("/{id}")
	public Pharmacie findById(@PathVariable int id) {
		return pharmacieService.findById(id);

	}
	@GetMapping("zone/{zone}")
	public List<Pharmacie> findPharmacyByZone(@PathVariable int zone) {
		return pharmacieService.findPharmacyByZone(zone);
	}
	@GetMapping("/ville/{villeId}/pharmacies")
	public List<Pharmacie> findPharmaciesByVille(@PathVariable int villeId) {
	    return pharmacieService.findPharmaciesByVille(villeId);
	}
      

	@PutMapping("/update")
	public void update(@RequestBody Pharmacie pharmacie) {
		pharmacieService.update(pharmacie);
	}
	@PostMapping("/images/upload")
    public String uploadImage(@RequestParam("image") MultipartFile file) {
        // Implement the logic to handle the uploaded file
        // You can access the file using the 'file' parameter
        
        // Example: Save the file to a specific location
        String filePath = "/path/to/save/uploads/" + file.getOriginalFilename();
         try {
			file.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return "File uploaded successfully!";
    }

	/*@GetMapping("/{ville}/{zone}/{garde}/pharmacies")
	public List<Pharmacie> findPharmacieByZoneByGarde(@PathVariable String ville, @PathVariable String zone,
			@PathVariable String garde) {
		Ville nom_ville = villeService.findByNom(ville);
		Zone zone_name = zoneService.findByNom(zone);
		Garde garde_nom = gardeService.findByType(garde);

		// List<Zone> zonesByVille = nom_ville.getZones();
		List<Pharmacie> filtreByVille = villeService.findPharmacieByVilleByZone(ville, zone);
		filtreByVille = garde_nom.getPharmacies();

		return filtreByVille;

	}*/
	@GetMapping("/{ville}/{zone}/{garde}/pharmacies")
	public List<Pharmacie> findPharmacieByZoneByGarde(@PathVariable int ville, @PathVariable int zone, @PathVariable String garde) {
	   return pharmacieService.findPharmacieByZoneByGarde(ville, zone, garde);
	}
	

}
