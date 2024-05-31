package com.in28minutes.learnspringframework.game;

import org.springframework.stereotype.Component;

@Component // 스프링이 특정 클래스의 인스턴스를 만들게 함
public class PacmanGame implements GamingConsole {

	public void up() {
		System.out.println("Jump");
	}

	public void down() {
		System.out.println("sit");
	}

	public void left() {
		System.out.println("Go back");
	}

	public void right() {
		System.out.println("trun");
	}
}
