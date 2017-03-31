package com.fuzzymeme.changecalculator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class ChangeCalculatorTests {

	private ChangeCalculator changer;
	private List<Map<Integer, Integer>> expected = new ArrayList<>();
	
	@Before
	public void setUp() {
		changer = new ChangeCalculator();
	}
	
	@Test
	public void test_Given11_returns4ItemListWithCorrectEntries() {

		expected.clear();
		expected.add(buildMap("1:11"));
		expected.add(buildMap("1:6 5:1"));
		expected.add(buildMap("1:1 5:2"));
		expected.add(buildMap("1:1 10:1"));

		List<Map<Integer, Integer>> calculated = changer.calculateCoinOptions(11);

		assertFailIfNotEquivalentLists(calculated, expected);
	}
	
	@Test
	public void test_Given16_returns6ItemListWithCorrectEntries() {

		expected.clear();
		expected.add(buildMap("1:16"));
		expected.add(buildMap("1:6 10:1"));
		expected.add(buildMap("1:1 5:3"));
		expected.add(buildMap("1:11 5:1"));
		expected.add(buildMap("1:6 5:2"));
		expected.add(buildMap("1:1 5:1 10:1"));

		List<Map<Integer, Integer>> calculated = changer.calculateCoinOptions(16);

		assertFailIfNotEquivalentLists(calculated, expected);
	}
	
	@Test
	public void test_Given23_returns9ItemListWithCorrectEntries() {

		expected.clear();
		expected.add(buildMap("1:13 5:2"));
		expected.add(buildMap("1:3 5:4"));
		expected.add(buildMap("1:3 5:2 10:1"));
		expected.add(buildMap("1:23"));
		expected.add(buildMap("1:18 5:1"));
		expected.add(buildMap("1:13 10:1"));
		expected.add(buildMap("1:8 5:1 10:1"));
		expected.add(buildMap("1:3 10:2"));
		expected.add(buildMap("1:8 5:3"));

		List<Map<Integer, Integer>> calculated = changer.calculateCoinOptions(23);

		assertFailIfNotEquivalentLists(calculated, expected);
	}
	
	@Test
	public void test_Given0_returns0ItemList() {

		List<Map<Integer, Integer>> expected = new ArrayList<>();
		List<Map<Integer, Integer>> calculated = changer.calculateCoinOptions(0);

		assertFailIfNotEquivalentLists(calculated, expected);
	}

	//
	// Helpers
	//
	private boolean assertFailIfNotEquivalentLists(List<Map<Integer, Integer>> one, List<Map<Integer, Integer>> other) {

		Set<Map<Integer, Integer>> oneSet = new HashSet<>(one);
		Set<Map<Integer, Integer>> otherSet = new HashSet<>(other);
		
		if(oneSet.size() != otherSet.size()) {
			System.out.println("Two lists are different sizes " + 
					oneSet.size() + 
					" and " + 
					otherSet.size());
		}
		
		if(!oneSet.equals(otherSet)) {
			for(Map<Integer, Integer> map: one) {
				if(!otherSet.contains(map)) {
					System.out.println("Missing: " + map);
				}
			}
			System.out.println(oneSet + " does not equal " + otherSet);
			fail("Two lists are not the same");
		}

		return oneSet.equals(otherSet);
	}
	
	private Map<Integer, Integer> buildMap(String mapDefinition) {
		
		Map<Integer, Integer> result = new HashMap<>();
		String[] items = mapDefinition.split(" ");
		for(String item: items) {
			String[] entry = item.split(":");
			result.put(Integer.parseInt(entry[0].trim()), 
					   Integer.parseInt(entry[1].trim()));
		}
		
		return result;
	}

}
