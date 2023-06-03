package com.example.demo.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.GardeService;
import com.example.demo.entity.Garde;
import com.example.demo.entity.Pharmacie;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin
@RequestMapping("/gardes")
public class GardeRest {
	private final GardeService gardeService;

	@Autowired
	public GardeRest(GardeService gardeService) {
		this.gardeService = gardeService;
	}

	@GetMapping("/id/{id}")
	public Garde findById(@PathVariable int id) {
		return gardeService.findById(id);
	}

	@GetMapping("/all")
	public List<Garde> findAll() {
		return gardeService.findAll();
	}

	/*
	 * @PostMapping("/{gardeId}/pharmacies")
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) public void assignGardeToPharmacie(
	 * 
	 * @PathVariable("gardeId") int gardeId,
	 * 
	 * @RequestBody Pharmacie pharmacie) {
	 * gardeService.assignGardeToPharmacie(gardeId, pharmacie); }
	 */
}