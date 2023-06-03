package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.entity.Pharmacie;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer> {
	Pharmacie findById(int id);
	List<Pharmacie> findByZoneVilleId(int villeId);

	//List<Pharmacie> findPharmacieByZoneAndGardes( String ville,  String zone,  String garde);
	

}
