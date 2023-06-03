package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Garde_PharmaciePK implements Serializable {
	private int garde_id;
	private int pharmacie_id;

	public int getGarde_id() {
		return garde_id;
	}

	public void setGarde_id(int garde_id) {
		this.garde_id = garde_id;
	}

	public int getPharmacie_id() {
		return pharmacie_id;
	}

	public void setPharmacie_id(int pharmacie_id) {
		this.pharmacie_id = pharmacie_id;
	}

}
