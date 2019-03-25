package com.eh.hospital.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genders")
public class Genders {

	@Id
	@GeneratedValue
	private String gender_code;
	private String gender_name;

	public String getGender_code() {
		return gender_code;
	}

	public void setGender_code(String gender_code) {
		this.gender_code = gender_code;
	}

	public String getGender_name() {
		return gender_name;
	}

	public void setGender_name(String gender_name) {
		this.gender_name = gender_name;
	}

}
