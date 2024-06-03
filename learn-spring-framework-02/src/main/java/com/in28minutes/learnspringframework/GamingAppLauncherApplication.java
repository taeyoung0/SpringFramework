package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game") // 다른 패키지에 있는 컴포넌트를 찾음
public class GamingAppLauncherApplication {

//	@Bean							// 컴포넌트로 만들었기 때문에 주석처리
//	public GamingConsole game() {
//		var game = new PacmanGame(); // 팩맨게임클래스의 인스턴스 생성
//		return game; // 팩맨게임 클래스를 리턴
//	}

//	@Bean						// 게임러너 컴포넌트로 만듬
//	public GameRunner gameRunner(GamingConsole game) { // 게임러너라는 이름의 빈을 생성, 게임콘솔 타입을 매개변수로 받음
//
//		System.out.println("Parameter : " + game);
//		var gameRunner = new GameRunner(game); // 게임콘솔 인스턴스를 사용해서 게임러너 클래스의 새로운 인스턴스를 생성
//		return gameRunner;
//	}

//	var game = new PacmanGame(); // 오브젝트 생성
	// var game = new MarioGame();
	// var game = new SuperContraGame();

	// 오브젝트 생성 + 의존성 와이어링(의존성 주입)
//	var gameRunner = new GameRunner(game); // GamingConsole 인터페이스를 구현 함으로써 게임을 바꿔도 게임러너 클래스를 변경할 필요가 없어짐
//	gameRunner.run();

	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
			// 스프링 컨텍스트를 만듬
			context.getBean(GamingConsole.class).up(); // 스프링 컨텍스트에서 GamingConsole 타입의 빈을 가져와서 up() 메서드를 호출함
			context.getBean(GameRunner.class).run(); // 스프링 컨텍스트에서 GameRunner 타입의 빈을 가져와서 run() 메서드를 호출함
		}
//		var game = new PacmanGame(); // 오브젝트 생성
//		// var game = new MarioGame();	
//		// var game = new SuperContraGame();
//
//		// 오브젝트 생성 + 의존성 와이어링(의존성 주입)
//		var gameRunner = new GameRunner(game); // GamingConsole 인터페이스를 구현 함으로써 게임을 바꿔도 게임러너 클래스를 변경할 필요가 없어짐
//		gameRunner.run();

	}

}
