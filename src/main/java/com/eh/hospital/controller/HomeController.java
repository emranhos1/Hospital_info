package com.eh.hospital.controller;

import com.eh.hospital.entity.Patients;
import com.eh.hospital.service.GenderInfoService;
import com.eh.hospital.service.MaritalStatusInfoService;
import com.eh.hospital.service.NationalitiesInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eh.hospital.service.PatientInfoService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	PatientInfoService patientInfoService;
	@Autowired
	GenderInfoService genderInfoService;
	@Autowired
	MaritalStatusInfoService maritalStatusInfoService;
	@Autowired
	NationalitiesInfoService nationalitiesInfoService;
	
    @RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
    public String home(ModelMap model) {
        model.addAttribute("message", "Welcome Medical System Co. Ltd.");
        System.out.println("Home");
        return "home";
    }

    @RequestMapping(value = "/allPatient", method = RequestMethod.GET)
    public ModelAndView allPatient(ModelAndView model) {
    	
    	ModelAndView modelView = new ModelAndView();
    	System.out.println(model.getModelMap());
    	modelView.addObject("massage", model.getModelMap());
    	modelView.addObject("patient", new Patients());
    	modelView.addObject("allPatient", patientInfoService.findAllPatient());
    	modelView.addObject("gender", genderInfoService.findAllGender());
    	modelView.addObject("maritalStatus", maritalStatusInfoService.findAllMaritalStatus());
    	modelView.addObject("nationalities", nationalitiesInfoService.findAllNationalitie());
        System.out.println("All Patients");
        modelView.setViewName("allPatients");
        return modelView;
    }
}



//@ResponseBody
//@RequestMapping(method = RequestMethod.GET)
//public Map<String, Object> findAllPatient() {
//	Map<String, Object> response = new HashMap<String, Object>();
//	List<Patients> pat = patientInfoService.findAllPatient();
//	if (pat == null) {
//		response.put("Success", false);
//		response.put("data", pat);
//		response.put("massage", "There are no Patient");
//	} else {
//		response.put("Success", true);
//		response.put("data", pat);
//		response.put("massage", "Select All Patient");
//	}
//	System.out.println("Find All Patient");
//	return response;
//}