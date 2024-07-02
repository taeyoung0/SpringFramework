package com.in28minutes.learn_spring_boot.courses.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.learn_spring_boot.courses.bean.Course;

@RestController // Json 형태로 객체 데이터를 반환, REST API를 개발할 때 주로 사용
public class CourseController {

	// http://localhost:8080/courses
	@GetMapping("/courses") // url 요청
	public List<Course> getAllCourses() {
		return Arrays.asList(new Course(1, "Learn Microservices", "in28minutes"));
	}
}
