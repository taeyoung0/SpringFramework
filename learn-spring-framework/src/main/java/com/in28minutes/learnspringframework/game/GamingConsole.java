package com.in28minutes.learnspringframework.game;

// GameRunner가 특정 게임에 결합되지 않게 GamingConsole 인터페이스를 구현
public interface GamingConsole {

	void up();

	void down();

	void left();

	void right();
}
