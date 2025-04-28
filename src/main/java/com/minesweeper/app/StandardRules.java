package com.minesweeper.app;

public class StandardRules implements IRules {
	private Integer[][] matriz = new Integer[8][14];
	
	public StandardRules(final int gameLoop) {
		this.insertMines(gameLoop);
	}
	
	public Integer[][] getRulesValues() {
		return this.matriz;
	}
	
	public int getElementValue(int line, int column) {
		return matriz[line][column];
	}
	
	public void insertMines(int seed) {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 14; j++) {
				int randomNumber = getTwoStartingNumbers(generateRandomNumber(seed));
				boolean cousin = isCousin(randomNumber);
			    if(cousin) {
					this.matriz[i][j] = 0;
				} else {
					this.matriz[i][j] = 1;
				}
			    seed++;
			}
			seed++;
		}
		
//		for(int i = 0; i < 8; i++) {
//			System.out.print((i > 0) ? '\n' : "");
//			for(int j = 0; j < 14; j++) {
//				System.out.printf("%d", matriz[i][j]);
//			}
//		}
	}
	
	public static int generateRandomNumber(long seed) {
		long random = (1664525 * seed + 1013904223) % 15892145;
		return (int) random % Integer.MAX_VALUE;
	}
	
	public static boolean isCousin(int number) {
		int d;
		
		if(number <= 1) { return false; }
		
		for(d = 2; d*d <= number; d++) {
			if(number%d == 0) { return false; }
		}
		
		return true;
		
	}
	
	public static int getTwoStartingNumbers(int number) {
	    String numberConverted = Integer.toString(number);
	    String lastNumer = numberConverted.substring(0, 2)+"";	
		return Integer.parseInt(lastNumer);
	}
}
