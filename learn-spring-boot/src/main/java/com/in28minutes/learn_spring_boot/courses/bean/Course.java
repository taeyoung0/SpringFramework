package com.in28minutes.learn_spring_boot.courses.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// 테이블과 자바 클래스간의 매핑
@Entity
public class Course {
	@Id // primary 키
	@GeneratedValue // Id 값을 자동으로 넣어줌
	private long id;

	private String name;
	private String author;

	public Course() {
		// 엔터티를 생성할때 반드시 기본 생성자를 가져야 함
	}

	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}

}
