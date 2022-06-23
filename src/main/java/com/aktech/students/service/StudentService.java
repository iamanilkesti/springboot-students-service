package com.aktech.students.service;

import com.aktech.students.model.Standard;
import com.aktech.students.model.Student;
import com.aktech.students.model.StudentStandardResponse;
import com.aktech.students.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	RestTemplate restTemplate;

	public Student addStudent(Student student){
		try {
			return studentRepository.save(student);
		} catch (Exception e){
			e.printStackTrace();
		}
		return new Student();
	}

	public StudentStandardResponse getStudentDetails(Long studentId) {
		log.info("Fetching student details for id: "+studentId);
		StudentStandardResponse response = new StudentStandardResponse();
		try {

			Student student = studentRepository.getReferenceById(studentId);
			Standard details = restTemplate.getForObject("http://localhost:8088/standards/" + student.getStandard(), Standard.class);
			response.setStudent(student);
			response.setStandard(details);
		} catch (Exception e){
			e.printStackTrace();
		}
		return response;
	}

	public List<Student> getAllStudents() {
		try {
			return studentRepository.findAll();
		}catch (Exception e){
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
