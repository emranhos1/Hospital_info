package com.eh.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eh.hospital.entity.Patients;

public interface PatientInfoRepository extends JpaRepository<Patients, Integer>{

}
