package com.eh.hospital.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.eh.hospital.entity.Genders;
import com.eh.hospital.service.GenderInfoService;

@RestController
@RequestMapping("/gender")
public class GenderController {

	@Autowired
	GenderInfoService genderInfoService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> findAllGender() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Genders> pat = genderInfoService.findAllGender();
		if(pat==null){
			 response.put("Success", false);
			 response.put("data", pat);
			 response.put("massage", "There are no Patient");
		 }else{
			 response.put("Success", true);
			 response.put("data", pat);
			 response.put("massage", "Select All Patient");
		 }
		System.out.println("Find All Genders");
		return response;
	}
}
