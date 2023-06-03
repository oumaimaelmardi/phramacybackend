package com.example.demo.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.Service.ZoneService;
import com.example.demo.entity.Zone;
import com.example.demo.repository.ZoneRepository;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("zones")
public class ZoneRest {
	@Autowired
	private ZoneService zoneService;
	@GetMapping("Nom/{nom}")
	public Zone findByNom(@PathVariable String nom) {
		return zoneService.findByNom(nom);
	}
	@GetMapping("/{id}")
	public Zone findById(@PathVariable int id) {
		return zoneService.findById(id);
	}
	@PostMapping("/save")
	public int save(@RequestBody   Zone entity) {
		return zoneService.save(entity);
	}
	@PutMapping("/update")
	public void update(@RequestBody Zone zone) {
		zoneService.update(zone);
	}
	@DeleteMapping("/deleteZone/{id}")
	public void deleteById(@PathVariable  int id) {
		zoneService.deleteById(id);
	}
	@GetMapping("/all")
	public List<Zone> findAll() {
		return zoneService.findAll();
	}

	

}
