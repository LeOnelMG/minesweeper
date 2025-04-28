package com.minesweeper.app;

public interface IRules {
	public void insertMines(int GAMELOOP);
	public Integer[][] getRulesValues();
	public int getElementValue(int line, int column);
}
