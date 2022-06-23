package com.aktech.students.controller;

import com.aktech.students.model.Student;
import com.aktech.students.model.StudentStandardResponse;
import com.aktech.students.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student){
		log.info("Received request for adding new student:");
		try {
			return studentService.addStudent(student);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new Student();
	}


	@GetMapping("/students/{id}")
	public StudentStandardResponse getStudentDetails(@PathVariable("id") Long studentId){
		log.info("Received request for get student details with id: "+studentId);
		try {
			return studentService.getStudentDetails(studentId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new StudentStandardResponse();
	}

	@GetMapping("/students")
	public List<Student> getAllStudents(){
		log.info("Received request for getting all student details: ");
		try {
			return studentService.getAllStudents();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
