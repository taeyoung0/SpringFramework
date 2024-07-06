package com.in28minutes.learn_spring_boot.courses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.learn_spring_boot.courses.bean.Course;
import com.in28minutes.learn_spring_boot.courses.repository.CourseRepository;

@RestController // Json 형태로 객체 데이터를 반환, REST API를 개발할 때 주로 사용
public class CourseController {

	@Autowired
	private CourseRepository repository;

	// http://localhost:8080/courses
	@GetMapping("/courses") // url 요청
	public List<Course> getAllCourses() {
		return repository.findAll(); // DB에서 데이터를 받아옴

//		return Arrays.asList(new Course(1, "Learn Microservices", "in28minutes"),
//				new Course(2, "Learn Full Stack with Angular and React", "in28minutes"));

	}

	// http://localhost:8080/courses/1
	@GetMapping("/courses/1") // url 요청
	public Course getAllCoursesDetails() {
		return new Course(1, "Learn Microservices 1", "in28minutes");
	}
}
