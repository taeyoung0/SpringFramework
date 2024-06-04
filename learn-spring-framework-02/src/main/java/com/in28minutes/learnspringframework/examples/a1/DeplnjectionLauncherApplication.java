package com.in28minutes.learnspringframework.examples.a1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass {
	// 필드 주입 방식 (생성자나 수정자가 없는 방식)
	// @Autowired // 자동 와이어링
	Dependency1 dependency1;
	// @Autowired
	Dependency2 dependency2; // 의존성 주입

	// @Autowired // 생성자 주입 방식은 @Autowired 구문 없이도 자동 와이어링 됨
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) { // 생성자 주입 방식
		super();
		System.out.println("Constructor Injection - YourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
		// 스프링에서 생성자 주입 방식을 항시 사용하도록 권장
		// 단 하나의 생성자 메서드 만으로 초기화가 모두 이루어짐
		// 어노테이션 필요X
	}

	public String toString() {
		return "Using" + dependency1 + "and" + dependency2;

	}

//	@Autowired		// 수정자(Setter) 주입방식
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection - setDependency1");
//		this.dependency1 = dependency1;
//	}
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection - setDependency2");
//		this.dependency2 = dependency2;
//	}

}

@Component
class Dependency1 {

}

@Component
class Dependency2 {

}

@Configuration
@ComponentScan // 현재 패키지 지정
public class DeplnjectionLauncherApplication {

	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(DeplnjectionLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			System.out.println(context.getBean(YourBusinessClass.class));

		}

	}

}
