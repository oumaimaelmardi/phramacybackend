package com.example.demo.ws;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.PharmacieGarde;
import com.example.demo.Service.PharmacieService;
import com.example.demo.entity.Garde;
import com.example.demo.entity.Garde_PharmaciePK;
import com.example.demo.entity.Pharmacie;
import com.example.demo.entity.Pharmacie_service;
import com.example.demo.repository.GardeRepository;
import com.example.demo.repository.PharmacieRepository;

//Assuming you have a controller or service class for handling the creation of the association

//Import necessary dependencies
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PharmacieGardeRest {
 
 // Autowire necessary repositories or services
/* @Autowired
 private GardeRepository gardeRepository;
 
 @Autowired
 private PharmacieRepository pharmacieRepository;
 
 @Autowired
 private com.example.demo.repository.PharmacieGarde pharmacieServiceRepository;

 //@PostMapping("/association")
 /*public void createAssociation(@RequestBody Pharmacie_service request) {
     Garde_PharmaciePK gardeId = request.getId();
     Pharmacie pharmacieId = request.getPharmacie();
     LocalDateTime startDateTime = request.getDate_debut();
     LocalDateTime endDateTime = request.getDate_fin();
     
     // Get the Garde and Pharmacie instances
   /*  Garde garde = gardeRepository.findById(gardeId).orElse(null);
     Pharmacie pharmacie = pharmacieRepository.findById(pharmacieId).orElse(null);
     
     if (garde != null && pharmacie != null) {
         // Create the primary key
         Garde_PharmaciePK primaryKey = new Garde_PharmaciePK();
         primaryKey.setGarde_id(gardeId);
         primaryKey.setPharmacie_id(pharmacieId);
     
         // Create the Pharmacie_service instance
         Pharmacie_service pharmacieService = new Pharmacie_service();
         pharmacieService.setId(primaryKey);
         pharmacieService.setGarde(garde);
         pharmacieService.setPharmacie(pharmacie);
         pharmacieService.setDate_debut(startDateTime);
         pharmacieService.setDate_fin(endDateTime);
     
         // Save the Pharmacie_service
        /* pharmacieServiceRepository.save(pharmacieService);*/
    /* }
 }*/
}

