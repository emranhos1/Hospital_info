package com.eh.hospital.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eh.hospital.entity.Patients;
import com.eh.hospital.service.PatientInfoService;

@RestController
@RequestMapping("/patient")
public class PatientInfoController {

	@Autowired
	PatientInfoService patientInfoService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> findAllPatient() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Patients> pat = patientInfoService.findAllPatient();
		if (pat == null) {
			response.put("Success", false);
			response.put("data", pat);
			response.put("massage", "There are no Patient");
		} else {
			response.put("Success", true);
			response.put("data", pat);
			response.put("massage", "Select All Patient");
		}
		System.out.println("Find All Patient");
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Map<String, Object> findByIdPatient(@PathVariable int id) {

		Map<String, Object> response = new HashMap<String, Object>();
		Patients pat = patientInfoService.findByIdPatient(id);
		if (pat == null) {
			response.put("Success", false);
			response.put("data", pat);
			response.put("massage", "There are no Patient");
		} else {
			response.put("Success", true);
			response.put("data", pat);
			response.put("massage", "Select Patient By ID");
		}
		System.out.println("Find by Patient ID");
		return response;
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> addPatient(@RequestBody Patients p) {

		Map<String, Object> response = new HashMap<String, Object>();
		Patients pat = patientInfoService.savePatient(p);

		if (pat == null) {
			response.put("Success", false);
			response.put("data", pat);
			response.put("massage", "Patient not Added");
		} else {
			response.put("Success", true);
			response.put("data", pat);
			response.put("massage", "Patient Added");
		}
		System.out.println("add Patient");
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Map<String, Object> updatePatientById(@PathVariable int id, @RequestBody Patients p) {

		Map<String, Object> response = new HashMap<String, Object>();
		Patients pat = patientInfoService.updatePatient(id, p);

		if (pat == null) {
			response.put("Success", false);
			response.put("data", pat);
			response.put("massage", "Patient not Updated");
		} else {
			response.put("Success", true);
			response.put("data", pat);
			response.put("massage", "Patient Updated");
		}
		System.out.println("Update by Patient ID");
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deletePatientById(@PathVariable int id) {
		Map<String, Object> response = new HashMap<String, Object>();
		boolean pat = patientInfoService.deletePatient(id);

		System.out.println("Delete by Patient ID");
		if (pat == false) {
			response.put("Success", false);
			response.put("massage", "Patient not Deleted");
		} else {
			response.put("Success", true);
			response.put("massage", "Patient Deleted");
		}
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/searchPatients", method = RequestMethod.GET)
	public Map<String, Object> searchPatients(@RequestHeader("patientN") String patientNo,
			@RequestHeader("firstN") String firstName, @RequestHeader("lastN") String lastName,
			@RequestHeader("fatherN") String fatherName, @RequestHeader("mothersN") String mothersName,
			@RequestHeader("birthD") String birthDate, @RequestHeader("genderC") String genderCode,
			@RequestHeader("maritalStatusC") String maritalStatusCode,
			@RequestHeader("nationalityC") String nationalityCode, @RequestHeader("phoneN") String phoneNumber)
					throws ParseException {

		System.out.println("Search Patient");
		Patients patient = new Patients();

		int pNo;
		if (patientNo == "") {
			pNo = 0;
		} else {
			pNo = Integer.valueOf(patientNo);
		}
		System.out.println("patient No : " + pNo);

		String birthD;
		if (birthDate == "") {
			birthD = "0000-00-00 00:00:00";
		} else {
			birthD = birthDate;

		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(birthD);

		// date1 = new
		// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'TZD'").parse(birthDate);

		System.out.println("birthdate = " + birthDate);
		System.out.println("birthd = " + birthD);
		patient.setPatientNo(pNo);
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setFathersName(fatherName);
		patient.setMothersName(mothersName);
		patient.setBirthDate(birthD);
		patient.setGenderCode(genderCode);
		patient.setMaritalStatusCode(maritalStatusCode);
		patient.setNationalityCode(nationalityCode);
		patient.setPhoneNumber(phoneNumber);

		Map<String, Object> response = new HashMap<String, Object>();
		List<Patients> pat = patientInfoService.multipleSearchPatient(patient);

		if (pat == null) {
			response.put("Success", false);
			response.put("massage", "Patient not found");
		} else {
			response.put("Success", true);
			response.put("data", pat);
			response.put("massage", "Patient Found");
		}
		return response;
	}
}
