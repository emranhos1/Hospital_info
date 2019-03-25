package com.eh.hospital.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.eh.hospital.entity.Nationalities;
import com.eh.hospital.service.NationalitiesInfoService;

@RestController
@RequestMapping("/nationalities")
public class NationalitiesController {
	
	@Autowired
	NationalitiesInfoService nationalitiesInfoService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> findAllNationalities() {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Nationalities> pat = nationalitiesInfoService.findAllNationalitie();
		if(pat==null){
			 response.put("Success", false);
			 response.put("data", pat);
			 response.put("massage", "There are no Nationalities");
		 }else{
			 response.put("Success", true);
			 response.put("data", pat);
			 response.put("massage", "Select All Nationalities");
		 }
		System.out.println("Find All Nationalities");
		return response;
	}
}
