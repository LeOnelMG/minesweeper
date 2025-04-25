package com.minesweeper.app;

import java.util.ArrayList;
import java.util.List;

public class GameController {
	private List<Game> games = new ArrayList<Game>();
	private Game gameInProgress;
	
	public Game getGameInProgress() {
		return gameInProgress;
	}
	
	public Game startNewGame(int GAMELOOP, GameScanner gameScanner) {
		gameInProgress = new Game(GAMELOOP, new Board(GAMELOOP), gameScanner);
		return gameInProgress;
	}
	
	public void saveCurrentGame(Game game) {
		games.add(game);
	}
}
