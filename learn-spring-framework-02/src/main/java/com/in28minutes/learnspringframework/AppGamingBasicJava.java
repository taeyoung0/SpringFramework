package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PacmanGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		var game = new PacmanGame(); // 오브젝트 생성
		// var game = new MarioGame();
		// var game = new SuperContraGame();

		// 오브젝트 생성 + 의존성 와이어링(의존성 주입)
		var gameRunner = new GameRunner(game); // GamingConsole 인터페이스를 구현 함으로써 게임을 바꿔도 게임러너 클래스를 변경할 필요가 없어짐
		gameRunner.run();

	}

}
