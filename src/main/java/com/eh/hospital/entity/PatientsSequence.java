package com.eh.hospital.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patients_sequence")
public class PatientsSequence {

	@Id
	@GeneratedValue
	private int patient_no;
	private Date amend_date;

	public int getPatient_no() {
		return patient_no;
	}

	public void setPatient_no(int patient_no) {
		this.patient_no = patient_no;
	}

	public Date getAmend_date() {
		return amend_date;
	}

	public void setAmend_date(Date amend_date) {
		this.amend_date = amend_date;
	}

}
