package com.minesweeper.app;

import java.util.List;
import java.util.Optional;

public enum ElementRevealTypes {
	
	BOMB(0, "BOMB"),
	EMPTY(1, "EMPTY");
	
	private final int number;
	private final String elementName;
	
	ElementRevealTypes(int number, String elementName){
		this.number = number;
		this.elementName = elementName;
	}
	
	int getNumber() {
		return this.number;
	}
	
	String getName(){
		return this.elementName;
	}
	
	public static String getElementByNumber(int element) {
		List<ElementRevealTypes> elements = List.of(ElementRevealTypes.values());
		Optional<ElementRevealTypes> elementFound = elements.stream().filter(s -> element == s.getNumber()).findFirst();
		return elementFound.get().getName();
	}
}
