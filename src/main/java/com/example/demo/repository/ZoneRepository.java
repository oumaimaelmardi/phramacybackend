package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Ville;
import com.example.demo.entity.Zone;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {
	
	Zone findById(int id);
	Zone findByNom(String nom);
	 
 
}
