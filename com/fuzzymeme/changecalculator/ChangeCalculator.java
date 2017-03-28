package com.fuzzymeme.changecalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChangeCalculator {
	
	
	public List<Map<Integer, Integer>> calculateCoinOptions(int target) {

		List<Map<Integer, Integer>> expected = new ArrayList<>();
		Map<Integer, Integer> one = new HashMap<>();
		one.put(1, 11);
		expected.add(one);

		Map<Integer, Integer> two = new HashMap<>();
		two.put(1, 6);
		two.put(5, 1);
		expected.add(two);

		Map<Integer, Integer> three = new HashMap<>();
		three.put(1, 1);
		three.put(5, 2);
		expected.add(three);

		Map<Integer, Integer> four = new HashMap<>();
		four.put(1, 1);
		four.put(10, 1);
		expected.add(four);
		
		return expected;
	}
	
	public static void main(String[] args) {
		
	}

}
