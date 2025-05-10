package com.minesweeper.app;

import com.minesweeper.app.ElementAround.ElementReveal;
import static com.minesweeper.app.GameStatus.*;
import static com.minesweeper.app.GameAttributes.*;

import java.util.HashMap;
import java.util.Map;

public class Game {
	private final Board board;
	private GameScanner gameScanner;
	private boolean exit = false;
	private Map<String, String> gameMetrics = new HashMap<>();
	
	public Game(
			final int GAMELOOP, 
			Board board, 
			GameScanner gameScanner) 
	{
		this.board = board;
		this.gameScanner = gameScanner;
		gameMetrics.put(STATUS, STATUS_NOT_FINISHED);
		gameMetrics.put(GAMELOOP_ID, Integer.toString(GAMELOOP));
		gameMetrics.put(SELECTED_OPTION, "");
		gameMetrics.put(NUMBER_OF_PLAYS, "0");
	}
	
	public String run() {
		System.out.printf("\n------Minesweeper (%s)-------\n", gameMetrics.get(GAMELOOP_ID));
		System.out.println("Exit game - exit | Start a new game - restart");
		
		while(!exit) {
			
			setPlay();
			board.drawerBoardValue();
			
			System.out.println("\nDigite as coordenadas:");
			gameMetrics.put(SELECTED_OPTION, gameScanner.scanner.nextLine());
			
			if(gameMetrics.get(SELECTED_OPTION).equals("exit") || gameMetrics.get(SELECTED_OPTION).equals("restart")) {
				exit = true;
				gameMetrics.put(STATUS, STATUS_NOT_FINISHED);
				return gameMetrics.get(SELECTED_OPTION);
			}
			
			if(!exit) {
				try {
					ElementReveal revealElement = board.revealElement(
							                            gameScanner.formatCoordinates(gameMetrics.get(SELECTED_OPTION)).get(0),
							                            gameScanner.formatCoordinates(gameMetrics.get(SELECTED_OPTION)).get(1));
					if(revealElement.type() == "BOMB") { 
						board.drawerBoardValue();
						gameMetrics.put(STATUS, STATUS_GAME_OVER);
						return gameMetrics.get(STATUS);
					}
				} catch(NumberFormatException e) {
					System.out.println("No accept format");
				}
			}
		}
		gameMetrics.put(STATUS, STATUS_NOT_FINISHED);
		return gameMetrics.get(STATUS);
	}
	
	public Map<String, String> getAttributes(){
		return gameMetrics;
	}
	
	public void setPlay() {
		Integer plays = Integer.parseInt(gameMetrics.get(NUMBER_OF_PLAYS));
		plays++;
		gameMetrics.put(NUMBER_OF_PLAYS, Integer.toString(plays));
	}
}