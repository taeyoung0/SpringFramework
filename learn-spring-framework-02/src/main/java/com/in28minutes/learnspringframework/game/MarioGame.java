package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // 여러 개의 컴포넌트 후보군이 있을때 특정한 빈을 선택하게끔 함
public class MarioGame implements GamingConsole {

	public void up() {
		System.out.println("Jump");
	}

	public void down() {
		System.out.println("Go into	a hole");
	}

	public void left() {
		System.out.println("Go back");
	}

	public void right() {
		System.out.println("Accelerate");
	}
}
