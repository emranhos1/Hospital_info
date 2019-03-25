package com.eh.hospital.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eh.hospital.entity.Patients;
import com.eh.hospital.repository.PatientInfoRepository;
import com.eh.hospital.repository.SearchPatientsByCriteria;

@Service
public class PatientInfoService {

	@Autowired
	PatientInfoRepository patientInfoRepository;
	@Autowired
	SearchPatientsByCriteria searchPatientsByCriteria;

	public List<Patients> findAllPatient() {
		List<Patients> allPatient = patientInfoRepository.findAll();

		if (allPatient.isEmpty()) {
			return null;
		} else {
			return allPatient;
		}
	}

	public Patients findByIdPatient(int id) {

		Optional<Patients> oneData = patientInfoRepository.findById(id);
		if (!oneData.isPresent()) {
			return null;
		} else {
			return oneData.get();
		}
	}

	public Patients savePatient(Patients p) {
		Patients savePatient = patientInfoRepository.save(p);
		return savePatient;
	}

	public Patients updatePatient(int id, Patients p) {

		int patientNo = p.getPatientNo();

		Optional<Patients> row = patientInfoRepository.findById(patientNo);

		if (!row.isPresent()) {
			p.setPatientNo(id);
			Patients pat = patientInfoRepository.save(p);
			return pat;
		} else {
			return null;
		}
	}

	public boolean deletePatient(int id) {

		Optional<Patients> row = patientInfoRepository.findById(id);

		if (row.isPresent()) {
			patientInfoRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
//	public static void main (String args[]){
//		Patients p = new Patients();
//		multipleSearchPatient(p);
//	}
	public List<Patients> multipleSearchPatient(Patients patient){
		
		return searchPatientsByCriteria.selectPatientByCriteria(patient);
	}
}



// if (name !=="" && role ="" && markes == "") {
// name
// } else if (){
//
// }else if (){
//
// }else if (){
//
// }else if (){
//
// }
