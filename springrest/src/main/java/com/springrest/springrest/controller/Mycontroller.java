package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.service.CourseService;

@RestController
public class Mycontroller {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() 
	{
		return "welcome to courses application";
	}
	
	//get courses
	@GetMapping("/courses")
	public List<Course> getcourses()
	{
		return this.courseService.getCourses();
	}
	
	
	
	
	//get one course
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) 
	{
		return this.courseService.getcourse(Long.parseLong(courseId));
	}
	
	
	
	
	//add course
	@PostMapping("/courses")
	public Course addcourse(@RequestBody Course course)
	{
		return this.courseService.addcourse(course);
	}
	
	
	
	
	
	//Update course
	@PutMapping("/courses/")
	public Course updatecourse(@RequestBody Course course)
	{
		return this.courseService.updatecourse(course);
	}
	
	
	
	
	
	
	// delete course
	@DeleteMapping("/courses/{courseID}")
	public  ResponseEntity<HttpStatus>deletecourse(@PathVariable String courseID) {
		try 
		{
			this.courseService.deleteCourse(Long.parseLong(courseID));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	
}
