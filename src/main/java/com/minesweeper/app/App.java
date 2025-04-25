package com.minesweeper.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    	boolean exit = false;
    	int GAMELOOP = 1;
    	GameScanner gameScanner = new GameScanner(new Scanner(System.in));
    	GameController gameController = new GameController();
    	
    	do {
    		
    		System.out.println("------Minesweeper-------");
			System.out.println("Start game - start | Check score - score");
			
			gameController.startNewGame(GAMELOOP, gameScanner);
			gameScanner.isRestart();
			
			switch(gameScanner.status.toLowerCase()) {
			      case "start":
			    	  gameScanner.setStatus(gameController.getGameInProgress().run());
				      break;
			      case "score":
			    	  System.out.print("EM TESTE");
			    	  break;
			}
			
			GAMELOOP++;
			
    	} while(!exit);
    }
}
