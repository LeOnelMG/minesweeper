package com.minesweeper.app;

import java.util.ArrayList;
import java.util.Scanner;

public class GameScanner {
	Scanner scanner;
	
	GameScanner(Scanner scanner){
		this.scanner = scanner;
	}
	
	public ArrayList<Integer> formatCoordinates(String coordinates){
		String[] inputSplited = coordinates.split("\\s+");
		ArrayList<Integer> coordinatesArray = new ArrayList<Integer>();
		coordinatesArray.add(0, Integer.parseInt(inputSplited[0]));
		coordinatesArray.add(1, Integer.parseInt(inputSplited[1]));
		return coordinatesArray;
	}
}
