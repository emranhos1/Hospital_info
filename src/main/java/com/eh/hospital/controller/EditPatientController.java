package com.eh.hospital.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eh.hospital.entity.Patients;
import com.eh.hospital.service.GenderInfoService;
import com.eh.hospital.service.MaritalStatusInfoService;
import com.eh.hospital.service.NationalitiesInfoService;
import com.eh.hospital.service.PatientInfoService;

@Controller
@RequestMapping("/goEditPatient")
public class EditPatientController {
	
	@Autowired
	PatientInfoService patientInfoService;
	@Autowired
	GenderInfoService genderInfoService;
	@Autowired
	MaritalStatusInfoService maritalStatusInfoService;
	@Autowired
	NationalitiesInfoService nationalitiesInfoService;
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView updatePatientById(@PathVariable int id) {

		ModelAndView modelView = new ModelAndView();
		Patients pat = patientInfoService.findByIdPatient(id);

//		if (pat == null) {
//			
//		} else {
			modelView.addObject("patient", pat);
			modelView.setViewName("allPatients");
			
			modelView.addObject("allPatient", patientInfoService.findAllPatient());
	    	modelView.addObject("gender", genderInfoService.findAllGender());
	    	modelView.addObject("maritalStatus", maritalStatusInfoService.findAllMaritalStatus());
	    	modelView.addObject("nationalities", nationalitiesInfoService.findAllNationalitie());
//		}
		System.out.println("Update by Patient ID");
		return modelView;
	}

}
