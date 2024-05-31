package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PacmanGame;

@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole game() {
		var game = new PacmanGame(); // 팩맨게임클래스의 인스턴스 생성
		return game; // 팩맨게임 클래스를 리턴
	}

	@Bean
	public GameRunner gameRunner(GamingConsole game) { // 게임러너라는 이름의 빈을 생성, 게임콘솔 타입을 매개변수로 받음
		var gameRunner = new GameRunner(game); // 게임콘솔 인스턴스를 사용해서 게임러너 클래스의 새로운 인스턴스를 생성
		return gameRunner;
	}

//	var game = new PacmanGame(); // 오브젝트 생성
	// var game = new MarioGame();
	// var game = new SuperContraGame();

	// 오브젝트 생성 + 의존성 와이어링(의존성 주입)
//	var gameRunner = new GameRunner(game); // GamingConsole 인터페이스를 구현 함으로써 게임을 바꿔도 게임러너 클래스를 변경할 필요가 없어짐
//	gameRunner.run();
}
