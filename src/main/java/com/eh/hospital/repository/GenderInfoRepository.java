package com.eh.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eh.hospital.entity.Genders;

public interface GenderInfoRepository extends JpaRepository<Genders, Integer>{

}
