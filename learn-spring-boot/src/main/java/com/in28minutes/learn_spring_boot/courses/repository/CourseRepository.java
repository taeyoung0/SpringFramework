package com.in28minutes.learn_spring_boot.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.learn_spring_boot.courses.bean.Course;

public interface CourseRepository extends JpaRepository<Course, Long> { // 첫번째 인자는 관리할 엔터티, 두번째는 primary 키의 타입

}
