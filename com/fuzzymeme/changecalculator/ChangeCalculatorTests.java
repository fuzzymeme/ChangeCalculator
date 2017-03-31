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
		expected.add(buildMap("1:11"));
		expected.add(buildMap("1:6 5:1"));
		expected.add(buildMap("1:1 5:2"));
		expected.add(buildMap("1:1 10:1"));

		ChangeCalculator changer = new ChangeCalculator();
		List<Map<Integer, Integer>> calculated = changer.calculateCoinOptions(11);

		assertTrue(equivalentLists(calculated, expected));
	}

	//
	// Helpers
	//
	private boolean equivalentLists(List<Map<Integer, Integer>> one, List<Map<Integer, Integer>> other) {

		Set<Map<Integer, Integer>> oneSet = new HashSet<>(one);
		Set<Map<Integer, Integer>> otherSet = new HashSet<>(other);

		return oneSet.equals(otherSet);
	}
	
	private Map<Integer, Integer> buildMap(String mapDefinition) {
		
		Map<Integer, Integer> result = new HashMap<>();
		String[] items = mapDefinition.split(" ");
		for(String item: items) {
			String[] entry = item.split(":");
			result.put(Integer.parseInt(entry[0].trim()), Integer.parseInt(entry[1].trim()));
		}
		
		return result;
	}

}
