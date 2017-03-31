package com.fuzzymeme.changecalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeCalculator {

	private final int[] denoms = new int[]{1, 5, 10, 25};
	private final List<Map<Integer, Integer>> answers = new ArrayList<>();
	private long lastPrintTime = System.currentTimeMillis();

	public List<Map<Integer, Integer>> calculateCoinOptions(int target) {
		answers.clear();
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
		return new HashMap<Integer, Integer>(coinMap);
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

	private void showAllAnswers() {

		System.out.println("All Answers:");
		for(Map<Integer, Integer> answer: answers) {
			System.out.println("----------- result: " + prettyPrintResultMap(answer) + ", Total: " + getTotal(answer));
		}
	}

	private String prettyPrintResultMap(Map<Integer, Integer> result) {

		StringBuilder stringBuilder = new StringBuilder("{");
		for(Map.Entry<Integer, Integer> entry: result.entrySet()) {
			stringBuilder.append(entry.getValue()).append("x").append(entry.getKey()).append(" ");
		}
		return stringBuilder.toString().trim() + "}";
	}

	public static void main(String[] args) {

		ChangeCalculator changer = new ChangeCalculator();
		changer.calculateCoinOptions(16);
		changer.showAllAnswers();
		System.out.println("results count: " + changer.answers.size());
	}

}
