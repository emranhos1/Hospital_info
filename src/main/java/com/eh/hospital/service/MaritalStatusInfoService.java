package com.eh.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eh.hospital.entity.MaritalStatus;
import com.eh.hospital.repository.MaritalStatusRepository;

@Service
public class MaritalStatusInfoService {

	@Autowired
	MaritalStatusRepository maritalStatusRepository;
	
	public List<MaritalStatus> findAllMaritalStatus() {
		
		List<MaritalStatus> maritalStatus = maritalStatusRepository.findAll();
		if (maritalStatus.isEmpty()) {
			return null;
		} else {
			return maritalStatus;
		}
	}
}
