package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PacmanGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		var game = new PacmanGame();
		// var game = new MarioGame();
		// var game = new SuperContraGame();
		var gameRunner = new GameRunner(game); // GamingConsole 인터페이스를 구현 함으로써 게임을 바꿔도 게임러너 클래스를 변경할 필요가 없어짐
		gameRunner.run();

	}

}
