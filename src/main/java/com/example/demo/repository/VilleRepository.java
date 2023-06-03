package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Pharmacie;
import com.example.demo.entity.Ville;
import com.example.demo.entity.Zone;
@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {
	
	Ville findById(int id);
	Ville findByNom(String nom);
	 
	
	// List<Pharmacie> findPharmacieByVilleByzone(String ville,String zone);
	 //List<Zone> findByVille( String nom);
   
}
