package com.eh.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eh.hospital.entity.Genders;
import com.eh.hospital.repository.GenderInfoRepository;

@Service
public class GenderInfoService {

	@Autowired
	GenderInfoRepository genderInfoRepository;
	
	public List<Genders> findAllGender() {
		List<Genders> allGender = genderInfoRepository.findAll();
		
		if (allGender.isEmpty()) {
			return null;
		} else {
			return allGender;
		}
	}
}
