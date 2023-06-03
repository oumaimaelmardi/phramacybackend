package com.example.demo.entity;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@JsonIgnoreProperties("gardes")
@Entity
public class Pharmacie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String adresse;
	private double latitude;
	private double longitude;
	private String nom;
	private String image;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime heureOuverture;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime heureFermeture;

	

	//@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name = "zone_id")
	//@JsonBackReference
	private Zone zone;

	

	@ManyToMany
	@JoinTable(name = "pharmacie_service", joinColumns = @JoinColumn(name = "pharmacie_id"), inverseJoinColumns = @JoinColumn(name = "garde_id"))
	@JsonManagedReference
	
    private List<Garde> gardes = new ArrayList<>();

	public LocalTime getHeureOuverture() {
		return heureOuverture;
	}

	public void setHeureOuverture(LocalTime heureOuverture) {
		this.heureOuverture = heureOuverture;
	}

	public LocalTime getHeureFermeture() {
		return heureFermeture;
	}

	public void setHeureFermeture(LocalTime heureFermeture) {
		this.heureFermeture = heureFermeture;
	}
	
	
	public int getId() {
		return id;
	}

	public List<Garde> getGardes() {
		return gardes;
	}

	public void setGardes(List<Garde> gardes) {
		this.gardes = gardes;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	

	

}
