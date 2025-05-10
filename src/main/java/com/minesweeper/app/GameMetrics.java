package com.minesweeper.app;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import static com.minesweeper.app.GameAttributes.*;

public class GameMetrics {
	private Map<String, Map<String, String>> metrics = new HashMap<>();
	
	public Map<String, Map<String, String>> metricsReport() {
		return metrics;
	}
	
	void setGameMetrics(Game game) {
		metrics.put(game.getAttributes().get(GAMELOOP_ID), game.getAttributes());
	}
	
	Map<String, String> filterGameMetrics(final Predicate<Map<String, String>> filter){
		for(Map<String, String> metric: metrics.values()) {
			if(filter.test(metric)) {
				return metric;
			}
		}
		return null;
	}
}
