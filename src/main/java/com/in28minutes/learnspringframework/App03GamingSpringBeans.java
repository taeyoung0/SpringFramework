package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		try (var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)) {
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
