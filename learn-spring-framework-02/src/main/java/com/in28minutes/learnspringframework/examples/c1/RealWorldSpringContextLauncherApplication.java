package com.in28minutes.learnspringframework.examples.c1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan // 다른 패키지에 있는 컴포넌트를 찾음
public class RealWorldSpringContextLauncherApplication {

	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(RealWorldSpringContextLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			System.out.println(context.getBean(BusinessCalculationService.class).findMax());

		}

		// @Component, @Service, @Controller, @Repository 모두 스테레오타입 어노테이션 임.
		// 정확한 어노테이션을 사용하면 특정 클래스가 무엇을 하는지 더 많은 정보를 줌.

	}

}
