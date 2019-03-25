package com.eh.hospital.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eh.hospital.entity.Patients;
import com.eh.hospital.util.HibernateSessionUtil;

@Repository
public class SearchPatientsByCriteria {

	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@Autowired
	HibernateSessionUtil hibernateSessionUtil;
	
	public List<Patients> selectPatientByCriteria(Patients p){
		
		List<Patients> patientList;
		Session session = hibernateSessionUtil.getSessionFactory(entityManagerFactory).openSession();
		session.beginTransaction();
		
		String patientNo ;
		String firstName;
		String lastName;
		String fatherName;
		String mothersName;
		String birthDate;
		String genderCode;
		String maritalStatusCode;
		String nationalityCode;
		String phoneNumber;
		
		if (p.getPatientNo() == 0){
			patientNo = "";
		} else{
			patientNo = Integer.toString(p.getPatientNo());
		}
		
		if(p.getFirstName() == null){
			firstName = "";
		} else {
			firstName = p.getFirstName();
		}
		
		if (p.getLastName() == null){
			lastName = "";
		} else{
			lastName = p.getLastName();
		}
		
		if (p.getFathersName() == null){
			fatherName = "";
		} else{
			fatherName = p.getFathersName();
		}
		
		if (p.getMothersName() == null){
			mothersName = "";
		} else{
			mothersName = p.getMothersName();
		}
		
		if (p.getBirthDate() == null){
			birthDate = "";
		} else{
//			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        birthDate = p.getBirthDate();
		}
		
		if (p.getGenderCode() == null){
			genderCode = "";
		} else{
			genderCode = p.getGenderCode();
		}
		
		if (p.getMaritalStatusCode() == null){
			maritalStatusCode = "";
		} else{
			maritalStatusCode = p.getMaritalStatusCode();
		}
		
		if (p.getNationalityCode() == null){
			nationalityCode = "";
		} else{
			nationalityCode = p.getNationalityCode();
		}
		if (p.getPhoneNumber() == null){
			phoneNumber = "";
		} else{
			phoneNumber = p.getPhoneNumber();
		}
		String sql = "FROM Patients "
				+ "where patientNo like '%"+patientNo+"%'"
				+ " and firstName like '%"+firstName+"%' "
				+ " and lastName like '%"+lastName+"%' "
				+ " and fathersName like '%"+fatherName+"%'"
				+ " and mothersName like '%"+mothersName+"%'"
				+ " and birthDate like '%"+birthDate+"%'"
				+ " and genderCode like '%"+genderCode+"%'"
				+ " and maritalStatusCode like '%"+maritalStatusCode+"%'"
				+ " and nationalityCode like '%"+nationalityCode+"%'"
				+ " and phoneNumber like '%"+phoneNumber+"%'";
		
		System.out.println(patientNo);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(fatherName);
		System.out.println(mothersName);
		System.out.println("from entity : "+birthDate);
		System.out.println(genderCode);
		System.out.println(maritalStatusCode);
		System.out.println(nationalityCode);
		System.out.println(phoneNumber);
		System.out.println(sql);
		patientList = session.createQuery(sql).list();
		session.close();
		return patientList;
	}
}
