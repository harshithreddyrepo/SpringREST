package com.telusko.SpringRestXmlJson.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.SpringRestXmlJson.model.Course;

@RestController
@RequestMapping("/course")
public class CourseController {

	@PostMapping(value="/addCourse", consumes= {"application/json", "application/xml"})
	public ResponseEntity<String> addCourseInfo(@RequestBody Course course){
		String msg=course.getName() +" course has beed added into the database";
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getCourse", produces= {"application/json", "application/xml"})
	public Course getCourseInfo() {
		Course course=new Course(101, "Spring Boot and Micro Services", 6999.0);
		return course;
	}
}
