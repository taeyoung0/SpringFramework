package com.in28minutes.learn_spring_boot.courses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping("/courses/{id}") // HTTP GET 요청을 "/courses/{id}" 경로로 매핑, {id}는 URL의 가변 부분으로, 요청 시 실제 값으로 대체
	public Course getAllCoursesDetails(@PathVariable long id) { // 요청 경로의 {id} 부분을 파라미터로 매핑, 즉 100001이 파리미터로 들어오고 이 값으로
																// 메서드가 실행
		Optional<Course> course = repository.findById(id); // id를 이용해 데이터베이스에서 Course를 Optional 형태로 조회
		if (course.isEmpty()) {
			throw new RuntimeException("Course not found with id" + id);
		}
		return course.get();
	}

	@PostMapping("/courses") // 클라이언트가 데이터를 서버로 전송할때 사용, 새로운 사용자나 게시물을 생성할때 POST 사용
	public void createCourse(@RequestBody Course course) { // HTTP 요청 본문에 포함된 Course 객체를 받아오는 메서드, 주로 Json 형식의 데이터를 자바
															// 객체로 변환하는데 사용
		repository.save(course); // 받아온 Course 객체를 데이터베이스에 저장
	}

	@PutMapping("/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable long id) {
		repository.save(course);
	}
}
