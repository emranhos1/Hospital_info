package com.eh.hospital.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.eh.hospital.entity.MaritalStatus;
import com.eh.hospital.service.MaritalStatusInfoService;


@RestController
@RequestMapping("/maritalStatus")
public class MaritalStatusController {

	@Autowired
	MaritalStatusInfoService maritalStatusInfoService;
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> findMaritalStatus() {
		
		Map<String, Object> response = new HashMap<String, Object>();
		List<MaritalStatus> pat = maritalStatusInfoService.findAllMaritalStatus();
		if(pat==null){
			 response.put("Success", false);
			 response.put("data", pat);
			 response.put("massage", "There are no Marital Status");
		 }else{
			 response.put("Success", true);
			 response.put("data", pat);
			 response.put("massage", "Select All Marital Status");
		 }
		System.out.println("Find All Marital Status");
		return response;
	}
}
