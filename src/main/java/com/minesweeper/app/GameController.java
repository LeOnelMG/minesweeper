package com.minesweeper.app;

public class GameController {
	private Game currentGame;
	private GameMetrics gameMetrics;
	
	GameController(GameMetrics gameMetrics){
		this.gameMetrics = gameMetrics;
	}
	
	public Game getCurrentGame() {
		return currentGame;
	}
	
	public Game startNewGame(int GAMELOOP, GameScanner gameScanner) {
		currentGame = new Game(
				GAMELOOP, 
				new Board(new StandardRules(GAMELOOP)), 
				gameScanner
		);
		return currentGame;
	}
	
	public void exitGame() {
		gameMetrics.setGameMetrics(currentGame);
	}
}
