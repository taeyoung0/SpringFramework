package com.in28minutes.learnspringframework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// 실행 할 스프링 컨텍스트// 만든 구성 클래스를 이용해서 인스턴스 생성
		try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			System.out.println(context.getBean("name")); // 메소드를 통해 생성된 빈을 회수, 이름을 속성으로 전달받는 방법

			System.out.println(context.getBean("age"));

			System.out.println(context.getBean("person"));

			System.out.println(context.getBean("person2MethodeCall"));

			System.out.println(context.getBean("person3Parameters"));

			System.out.println(context.getBean("address2"));

			// System.out.println(context.getBean(Address.class)); // 타입을 매개변수로 클래스를 전달받는 방법
			// 클래스도 빈으로 관리되는걸 확인할 수 있음

			// Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			// // 스프링 빈 목록 출력
		}

	}
}
