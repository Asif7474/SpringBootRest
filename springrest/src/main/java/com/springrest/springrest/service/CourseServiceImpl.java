package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springrest.springrest.Dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;

	// List<Course> list;
	public CourseServiceImpl() {
		/*
		 * list=new ArrayList<>(); list.add(new
		 * Course(111,"core java course","this basic of java")); list.add(new
		 * Course(222,"spring boot course","this is advance spring boot "));
		 */
	}

	// get all course
	@Override
	public List<Course> getCourses() {

		return courseDao.findAll();
	}

	// get single course
	@Override
	public Course getcourse(long courseId) {

		/*
		 * Course c=null; for(Course course:list) { if(course.getId() == courseId) {
		 * c=course; break;
		 */
		return courseDao.getOne(courseId);
	}

	// add course
	@Override
	public Course addcourse(@RequestBody Course course) {
		// list.add(course);
		courseDao.save(course);
		return course;
	}

	// update course
	@Override
	public Course updatecourse(@RequestBody Course course) {
		/*
		 * list.forEach(e ->{ if(e.getId()==course.getId()) {
		 * e.setTitle(course.getTitle()); e.setDescription(course.getDescription()); }
		 * })
		 * */
		courseDao.save(course);
		   return course;
		 
	}

	@Override
	public void deleteCourse(long parseLong) {
		// list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
		Course entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
		
	}

}
