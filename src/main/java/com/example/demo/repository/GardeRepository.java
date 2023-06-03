package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Garde;
import com.example.demo.entity.Garde_PharmaciePK;
import com.example.demo.entity.Pharmacie;
import com.example.demo.entity.Ville;
@Repository
public interface GardeRepository  extends JpaRepository<Garde, Integer>{
	Garde findByType(String type);
    Garde findById(Garde_PharmaciePK gardeId);
    Garde findById(int id);
}
