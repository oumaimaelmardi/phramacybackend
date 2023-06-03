
package com.example.demo.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.Service.PharmacieGarde;
import com.example.demo.entity.Garde_PharmaciePK;
import com.example.demo.entity.Pharmacie_service;

@RestController
@CrossOrigin
@RequestMapping("pharmacieGarde")
public class PharmacieGardeController {

	@Autowired
	private PharmacieGarde pharmacieGardeService;

	@GetMapping("/all")
	public List<Pharmacie_service> findAll() {
		return pharmacieGardeService.findAll();
	}

	@PostMapping("/save")
	public int save(@RequestBody Pharmacie_service entity) {
		return pharmacieGardeService.save(entity);
	}

	@PutMapping("/update")
	public void update(@RequestBody Pharmacie_service pharmacieGarde) {
		pharmacieGardeService.update(pharmacieGarde);
	}
	@Transactional
	@DeleteMapping("/delete/{gardeId}/{pharmacieId}")
    public void deletePharmacieGarde(@PathVariable int gardeId, @PathVariable int pharmacieId) {
        Garde_PharmaciePK id = new Garde_PharmaciePK();
        id.setGarde_id(gardeId);
        id.setPharmacie_id(pharmacieId);
        pharmacieGardeService.deleteById(id);
    }

	@GetMapping("/find/{gardeId}")
	public List<Pharmacie_service> getPharmacieServiceByGardeId(@PathVariable int gardeId) {
	    return pharmacieGardeService.findByPharmacieGardesId(gardeId);
	}

	/*@Transactional
	@DeleteMapping("/delete")
	public int deleteById(@RequestBody Garde_PharmaciePK id) {
		return pharmacieGardeService.deleteById(id);
	}*/

	/*
	 * @PostMapping("/save") public void save(@RequestBody Pharmacie_service
	 * pharmacieGarde){ pharmacieGardeService.save(pharmacieGarde); }
	 * 
	 * @GetMapping("") public List<Pharmacie_service> findAll(){ return
	 * pharmacieGardeService.findAll(); }
	 * 
	 * @DeleteMapping("/delete") public void delete(@RequestBody Pharmacie_service
	 * pharmacieGarde){
	 * 
	 * // Pharmacie_garde ph = pharmacieGardeService.findById(id); // if (ph !=
	 * null){ // pharmacieGardeService.delete(pharmacieGarde); // } }
	 * 
	 * @PutMapping("/update") public void update(@RequestBody Pharmacie_service o){
	 * pharmacieGardeService.update(o); }
	 */
}
