package com.in28minutes.learnspringframework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class NormalClass {

}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class PrototypeClass {

}

@Configuration
@ComponentScan // 다른 패키지에 있는 컴포넌트를 찾음
public class BeanScopesLauncherApplication {

	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class)) {

			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));

			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));

			// 기본적으로 스프링 프레임워크에서 생성되는 모든 빈이 싱글톤
			// 빈이 참조될 때마다 다른 인스턴스가 생성되게 하려면 프로토타입 적용해야 함

			// 싱글톤은 스프링 ioc 컨테이너마다 단 1개의 객체 인스턴스 생성
			// 프로토타입은 많은 객체 인스턴스를 생성

			// Java 싱글톤은 JVM당 1개의 객체 인스턴스 생성
		}

	}

}
