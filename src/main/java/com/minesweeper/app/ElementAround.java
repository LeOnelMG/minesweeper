package com.minesweeper.app;

public enum ElementAround {
	
	/*Directions*/
	ABOVE(0,+1),
	BELOW(0, -1),
	LEFT(-1, 0),
	RIGHT(+1, 0),
	
	/*Diagonal directions*/
	dAboveRight(+1, +1),
	dAboveLeft(-1, +1),
	dDownRight(+1, -1),
	dDownLeft(-1, -1);
	
	private int line;
	private int column;
	
	ElementAround(int line, int column){
		this.line = line;
		this.column = column;
		
	}
	
	public int getLine() {
		return this.line;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public static ElementReveal verifyAround(int line, int column, Integer[][] matriz) {
        int bombsAround = 0;
		
		for(ElementAround element: ElementAround.values()) {
			int findedElement = exceedsMatrizLimit(line + element.line, column + element.column, matriz) ? 2 : matriz[line + element.line][column + element.column];
			if(findedElement == 0) {
        		bombsAround++;
        	}		
		}
		
		String type = ElementRevealTypes.getElementByNumber(matriz[line][column]);
		ElementReveal element = new ElementReveal(type, bombsAround);
		return element;
	}
	
	public static <T> boolean exceedsMatrizLimit(int line, int column, T[][] matriz) {
		if((line < 0 || line >= matriz.length) || (column < 0 || column >= matriz[0].length)) {
			return true;
		}
		return false;
		
	}
	
	record ElementReveal(String type, int bombsAround) {}

}
