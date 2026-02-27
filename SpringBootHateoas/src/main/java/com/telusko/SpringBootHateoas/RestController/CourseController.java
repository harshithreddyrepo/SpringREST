package com.telusko.SpringBootHateoas.RestController;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	class Pair{
		String msg;
		Link link;
		public Pair(String msg, Link link) {
			super();
			this.msg = msg;
			this.link = link;
		}
		 public String getMsg() {
		        return msg;
		    }

		    public Link getLink() {
		        return link;
		    }
	}
	
	@GetMapping("/beginCourse")
	public ResponseEntity<Pair> getCourse(){
		
		String msg="click the link to start the Java Full Stack Journey";
		
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class).getJava()).withRel("/beginJava");
	    
		Pair pair=new Pair(msg, link);
		
		return new ResponseEntity<Pair> (pair, HttpStatus.OK);
	}
	
	@GetMapping("/beginJava")
	public ResponseEntity<Course> getJava(){
		Course java=new Course("Java", "Beginner", "3 months");
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class).getSpringBoot()).withRel("/beginSpringBoot");
		java.add(link);
	    return new ResponseEntity<Course>(java, HttpStatus.OK);
	}
	
	@GetMapping("/beginSpringBoot")
	public ResponseEntity<Course> getSpringBoot(){
		Course springboot=new Course("Spring Boot", "Practioner", "3 months");
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class).getMicroServices()).withRel("/beginMicroServices");
		springboot.add(link);
	    return new ResponseEntity<Course>(springboot, HttpStatus.OK);
	}
	
	@GetMapping("/beginMicroServices")
	public ResponseEntity<Course> getMicroServices(){
		Course microservices=new Course("MicroServices", "Advanced", "2 months");
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CourseController.class).getGreet()).withRel("/endCourse");
		microservices.add(link);
	    return new ResponseEntity<Course>(microservices, HttpStatus.OK);
	}
	
	
	@GetMapping("/endCourse")
	public ResponseEntity<String> getGreet(){
		String msg="Congrates Developer! you have successfully completed the backend journey.";
		return new ResponseEntity<String> (msg, HttpStatus.OK);
	}
	
}
