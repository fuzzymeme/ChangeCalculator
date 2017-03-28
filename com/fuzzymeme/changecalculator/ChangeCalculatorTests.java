package com.fuzzymeme.changecalculator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class ChangeCalculatorTests {

	@Test
	public void test_Given11_returns4ItemListWithCorrectEntries() {

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

		ChangeCalculator changer = new ChangeCalculator();
		List<Map<Integer, Integer>> calculated = changer.calculateCoinOptions(11);

		assertTrue(equivalentLists(calculated, expected));
	}

	//Helpers
	private boolean equivalentLists(List<Map<Integer, Integer>> one, List<Map<Integer, Integer>> other) {

		Set<Map<Integer, Integer>> oneSet = new HashSet<>(one);
		Set<Map<Integer, Integer>> otherSet = new HashSet<>(other);

		return oneSet.equals(otherSet);
	}

}
