package com.fuzzymeme.changecalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeCalculator {

	private int[] denoms = new int[]{1, 5, 10, 25};
	private List<Map<Integer, Integer>> answers = new ArrayList<>();
	private long lastPrintTime = System.currentTimeMillis();

	public List<Map<Integer, Integer>> calculateCoinOptions(int target) {
		answers = new ArrayList<>();
		recurseToCalculateCoinOptions(new HashMap<>(), 0, target);

		return answers;
	}

	private void recurseToCalculateCoinOptions(Map<Integer, Integer> soFar, int index, int target) {

		for(int i = index; i < denoms.length; i++) {
			int denom = denoms[i];

			if(getTotal(soFar) + denom <= target) {
				Map<Integer, Integer> copy = getCopy(soFar);
				addDenom(copy, denom);

				if(getTotal(copy) == target) {
					addAnswer(copy);
				} else {					
					recurseToCalculateCoinOptions(copy, i, target);
				}
			}
		}
	}

	private Map<Integer, Integer> getCopy(Map<Integer, Integer> coinMap) {

		Map<Integer, Integer> copy = new HashMap<>();
		for(int denom: coinMap.keySet()) {
			copy.put(denom, coinMap.get(denom));
		}
		return copy;
	}

	private void addDenom(Map<Integer, Integer> coinMap, int denom) {

		if(!coinMap.containsKey(denom)) {
			coinMap.put(denom, 1);
		} else {
			coinMap.put(denom, coinMap.get(denom) + 1);
		}
	}

	private int getTotal(Map<Integer, Integer> coinMap) {
		int total = 0;
		for(Integer denom: coinMap.keySet()) {
			total += denom * coinMap.get(denom);
		}
		return total;
	}
	
	private void addAnswer(Map<Integer, Integer> newAnswer) {
		if(System.currentTimeMillis() - lastPrintTime > 1000 ) {
			lastPrintTime = System.currentTimeMillis();
			System.out.println("results count: " + answers.size());
		}

		answers.add(newAnswer);
	}

}
