package com.minesweeper.app;

import com.minesweeper.app.ElementAround.ElementReveal;

public class Game {
	private final int GAMELOOP;
	private final Board board;
	private GameScanner gameScanner;
	private boolean exit = false;
	
	public Game(final int GAMELOOP, Board board, GameScanner gameScanner) {
		this.GAMELOOP = GAMELOOP;
		this.board = board;
		this.gameScanner = gameScanner;
	}
	
	public String run() {
		System.out.printf("\n------Minesweeper (%d)-------\n", GAMELOOP);
		System.out.println("Exit game - exit | Start a new game - restart");
		
		while(!exit) {
			
			board.drawerBoardValue();
			
			System.out.println("\nDigite as coordenadas:");
			String gameOption = gameScanner.scanner.nextLine();
			
			if(gameOption.toLowerCase().equals("exit") || gameOption.toLowerCase().equals("restart")) {
				exit = true;
				return gameOption.toLowerCase();
			}
			
			if(!exit) {
				try {
					ElementReveal revealElement = board.revealElement(
							                            gameScanner.formatCoordinates(gameOption).get(0),
							                            gameScanner.formatCoordinates(gameOption).get(1));
					if(revealElement.type() == "BOMB") { 
						board.drawerBoardValue();
						return "BOMB";
					}
				} catch(NumberFormatException e) {
					System.out.println("No accept format");
				}
			}
		}
		
		return "no-running";
	}
}
