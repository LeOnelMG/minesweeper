package com.minesweeper.app;

import com.minesweeper.app.ElementAround.ElementReveal;

public class Board {
	private String[][] matriz = new String[8][14];
	IRules rules;
	
	public Board(IRules rules) {
		this.rules = rules;
		this.insertBoardValue();
    }
	
	private void insertBoardValue() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 14; j++) {
				this.matriz[i][j] = "?";
			}
		}
	}
	
	public void drawerBoardValue() {
		for(int i = 0; i < 8; i++) {
			System.out.print((i > 0) ? '\n' : "");
			for(int j = 0; j < 14; j++) {
				System.out.printf("%s", matriz[i][j]);
			}
		}
	}
	
	public ElementReveal revealElement(int line, int column) {
		ElementReveal element = ElementAround.verifyAround(line, column, rules.getRulesValues());
	    this.matriz[line][column] = Integer.toString(element.bombsAround());
	    if(element.type() == "EMPTY" && element.bombsAround() == 0) {
	    	revealElementsAround(line, column);
	    }
		return element;
	}
	
	public void revealElementsAround(int line, int column) {
		for(ElementAround elementAround: ElementAround.values()) {
			int nextLine = line + elementAround.getLine();
			int nextColumn = column + elementAround.getColumn();
			if(!ElementAround.exceedsMatrizLimit(nextLine, nextColumn, this.matriz)) {
    		   if(this.matriz[nextLine][nextColumn] == "?") {
    			  revealElement(nextLine, nextColumn);
    	       }
			}
		}
	}
}
