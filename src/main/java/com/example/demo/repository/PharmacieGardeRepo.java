package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Garde_PharmaciePK;
import com.example.demo.entity.Pharmacie;
import com.example.demo.entity.Pharmacie_service;

@Repository
public interface PharmacieGardeRepo extends JpaRepository<Pharmacie_service, Integer> {
	
  // int deleteById(Garde_PharmaciePK id);
	@Modifying
    @Transactional
    @Query("DELETE FROM Pharmacie_service pg WHERE pg.id = :id")
    void deleteById(@Param("id") Garde_PharmaciePK id);
	
	List<Pharmacie_service> findByPharmacieGardesId(int gardeId);

}
