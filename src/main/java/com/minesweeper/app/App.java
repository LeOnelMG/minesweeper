package com.minesweeper.app;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    	boolean exit = false;
    	int GAMELOOP = 1;
    	GameScanner gameScanner = new GameScanner(new Scanner(System.in));
    	GameMetrics gameMetrics = new GameMetrics();
    	GameController gameController = new GameController(gameMetrics);
    	String player_option = "";
    	
    	do {
    		
    		if(!player_option.equals("restart")) {
    		    System.out.println("------Minesweeper-------");
			    System.out.println("Start game - start | Check score - score");
    		}
    		
    		if(gameController.getCurrentGame() != null) {
    			gameController.exitGame();
    		}
			gameController.startNewGame(GAMELOOP, gameScanner);
			player_option = player_option.equals("restart") ? "start" : gameScanner.scanner.nextLine();
			
			switch(player_option) {
			      case "start":
			    	  player_option = gameController.getCurrentGame().run();
			    	  System.out.println(player_option);
				      break;
			      case "score":
			    	  System.out.println("developing");
			    	  break;
			}
			
			GAMELOOP++;
			
    	} while(!exit);
    }
}
