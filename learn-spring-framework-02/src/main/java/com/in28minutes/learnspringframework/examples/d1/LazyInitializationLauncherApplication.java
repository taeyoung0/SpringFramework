package com.in28minutes.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {

}

@Component
@Lazy // 스프링 컨텍스트가 실행될때 빈이 자동으로 초기화가 되는데 Lazy를 쓰면 호출할 경우에만 실행
class ClassB {

	private ClassA classA;

	public ClassB(ClassA classA) {
		System.out.println("Some Initialization logic");
		this.classA = classA;
	}

	public void doSomething() {
		System.out.println("Do Something");
	}
}

@Configuration
@ComponentScan // 다른 패키지에 있는 컴포넌트를 찾음
public class LazyInitializationLauncherApplication {

	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
			// Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			// Eager Initialization은 스프링 컨텍스트가 실행되면 바로 로딩, 자주 사용
			// Lazy Initialization은 호출될때 로딩, 자주 사용X
			System.out.println("Initialization of context is completed");

			context.getBean(ClassB.class).doSomething(); // 메서드도 호출될때 실행
		}

	}

}
