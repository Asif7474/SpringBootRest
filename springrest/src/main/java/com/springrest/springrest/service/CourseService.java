package com.springrest.springrest.service;

import java.util.List;

import com.springrest.springrest.entities.Course;

public interface CourseService {

	public List<Course> getCourses();
	public Course getcourse(long courseId);
	public Course addcourse(Course course);
	public Course updatecourse(Course course);
	public void deleteCourse(long parseLong);
}
