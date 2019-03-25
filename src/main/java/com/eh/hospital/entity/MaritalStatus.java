package com.eh.hospital.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marital_status")
public class MaritalStatus {

	@Id
	@GeneratedValue
	private String marital_status_code;
	private String marital_status_name;

	public String getMarital_status_code() {
		return marital_status_code;
	}

	public void setMarital_status_code(String marital_status_code) {
		this.marital_status_code = marital_status_code;
	}

	public String getMarital_status_name() {
		return marital_status_name;
	}

	public void setMarital_status_name(String marital_status_name) {
		this.marital_status_name = marital_status_name;
	}

}
