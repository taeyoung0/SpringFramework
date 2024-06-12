package com.in28minutes.learnspringframework.examples.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private SomeDependency someDependency;

	public SomeClass(SomeDependency someDependency) { // 생성자 주입을 통해 SomeDependency를 주입
		super();
		this.someDependency = someDependency;
		System.out.println("All dependencies are ready"); // 모든 의존성이 주입된 후 출력
	}

	@PostConstruct // 빈 초기화 후 호출될 메서드를 지정
	public void initialize() {
		someDependency.getReady(); // someDependency의 getReady 메서드를 호출하여 초기화 로직을 실행

	}

	@PreDestroy // 빈이 소멸되기 전에 호출될 메서드를 지정
	public void cleanup() {
		System.out.println("CleanUp");
	}

}

@Component
class SomeDependency {

	public void getReady() {
		System.out.println("Some logic using SomeDependency");

	}

}

@Configuration
@ComponentScan // 다른 패키지에 있는 컴포넌트를 찾음
public class PrePostAnnotationsContextLauncherApplication {

	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(PrePostAnnotationsContextLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		}

	}

}
