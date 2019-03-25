package com.eh.hospital.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/deletePatient")
public class DeletePatientController {

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
	public ModelAndView deletePatientById(@PathVariable int id) {
		ModelAndView modelView = new ModelAndView();
		boolean pat = patientInfoService.deletePatient(id);
		System.out.println("Delete by Patient ID");
		if (pat == false) {
			modelView.addObject("Patient not Deleted");
		} else {
			modelView.addObject("Patient Deleted");
		}
		modelView.setViewName("redirect:/allPatient");
		return modelView;
	}

//	@RequestMapping(value = "/allPatient", method = RequestMethod.GET)
//	public String allPatient(ModelMap model) {
//		model.addAttribute("patient", new Patients());
//		model.addAttribute("allPatient", patientInfoService.findAllPatient());
//		model.addAttribute("gender", genderInfoService.findAllGender());
//		model.addAttribute("maritalStatus", maritalStatusInfoService.findAllMaritalStatus());
//		model.addAttribute("nationalities", nationalitiesInfoService.findAllNationalitie());
//		System.out.println("All Patients");
//		return "allPatients";
//	}
}
