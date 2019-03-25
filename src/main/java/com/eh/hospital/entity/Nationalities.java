package com.eh.hospital.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nationalities")
public class Nationalities {

	@Id
	@GeneratedValue
	private String nationality_code;
	private String nationality_name;

	public String getNationality_code() {
		return nationality_code;
	}

	public void setNationality_code(String nationality_code) {
		this.nationality_code = nationality_code;
	}

	public String getNationality_name() {
		return nationality_name;
	}

	public void setNationality_name(String nationality_name) {
		this.nationality_name = nationality_name;
	}
}
