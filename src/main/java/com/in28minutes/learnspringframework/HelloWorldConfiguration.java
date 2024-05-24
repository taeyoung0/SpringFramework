package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age, Address address) {
	// getter,setter,생성자를 생략해서 클래스를 간단하게 자바빈을 쉽게 만들 수 있도록 해줌 JDK16 부터 도입
} // 강의에서는 중괄호를 넣어줬는데 생략해도 에러가 안뜸

record Address(String firstLine, String city) {

}

@Configuration // 스프링 구성 클래스
public class HelloWorldConfiguration {
	// 여기서 스프링 빈을 정의, 스프링 빈을 만드는 메소드를 정의

	@Bean // 스프링 컨테이너가 관리하는 빈 생성
	public String name() {
		return "Ranga";
	}

	@Bean
	public int age() {
		return 20;
	}

	@Bean
	public Person person() {
		// var person = new Person("Ty", 30);
		// return person;

		return new Person("Ty", 30, new Address("Main Street", "Utrecht"));
		// 위에 var person이랑 new Person 같다고 해서 이렇게 씀
		// 어드레스는 클래스이기 때문에 new로 인스턴스를 생성해줌
	}

	@Bean
	public Person person2MethodeCall() {
		return new Person(name(), age(), address()); // 기존에 만들어진 빈의 메소드를 이용해서 새로운 빈을 생성
	}

	@Bean
	public Person person3Parameters(String name, int age, Address address3) { // 기존에 만들어진 빈의 매개변수를 이용해서 새로운 빈을 생성
		return new Person(name, age, address3); // 자동 와이어링
	}

	@Bean(name = "address2") // 일반적으로 빈의 이름과 메소드 이름은 같음, 필요에 따라 빈 이름을 사용자가 정의할때 이렇게 씀
	public Address address() {
		return new Address("부산", "연산");
	}

	@Bean(name = "address3")
	public Address address3() {
		return new Address("Motinagar", "Hyderabad");
	}

}
