package com.eh.hospital.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eh.hospital.entity.Patients;
import com.eh.hospital.service.PatientInfoService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
@RequestMapping("/addPatient")
public class AddPatient {

	@Autowired
	PatientInfoService patientInfoService;

	@RequestMapping(method = RequestMethod.POST)
    public ModelAndView addPatient(@ModelAttribute("patient") Patients patient) {
		ModelAndView modelView = new ModelAndView();
		System.out.println("addPatient");
		Patients pat = patientInfoService.savePatient(patient);
//		if (pat == null) {
//			model.addAttribute("message", "Patient not Added");
//		} else {
//			model.addAttribute("message", "Patient Added");
//		}
        return new ModelAndView("redirect:/allPatient");
    }
	
//	@ResponseBody
//	@RequestMapping(value = {"/newPatient"}, method = RequestMethod.GET)
//	public String addPatient(HttpServletRequest request, ModelMap model, @ModelAttribute("patient") Patients patient) {
//
//		System.out.println(patient.getFirstName());
//		System.out.println(patient.getLastName());
//		System.out.println(patient.getFathersName());
//		System.out.println(patient.getMothersName());
//		System.out.println(patient.getBirthDate());
//		System.out.println(patient.getGenderCode());
//		System.out.println(patient.getMaritalStatusCode());
//		System.out.println(patient.getNationalityCode());
//		System.out.println(patient.getPhoneNumber());
//		Patients pat = patientInfoService.savePatient(patient);
//		if (pat == null) {
//			model.addAttribute("message", "Patient not Added");
//		} else {
//			model.addAttribute("message", "Patient Added");
//		}
//		System.out.println("add Patient");
//		
//		return "/allPatient";
//	}
}
