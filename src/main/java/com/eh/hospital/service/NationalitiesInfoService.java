package com.eh.hospital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eh.hospital.entity.Nationalities;
import com.eh.hospital.repository.NationalitiesInfoRepository;

@Service
public class NationalitiesInfoService {

	@Autowired
	NationalitiesInfoRepository nationalitiesInfoRepository;

	public List<Nationalities> findAllNationalitie() {

		List<Nationalities> allNationalities = nationalitiesInfoRepository.findAll();

		if (allNationalities.isEmpty()) {
			return null;
		} else {
			return allNationalities;
		}
	}
}
