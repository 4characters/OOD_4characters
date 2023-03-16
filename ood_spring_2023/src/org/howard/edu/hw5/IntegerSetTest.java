package org.howard.edu.hw5;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {
	private IntegerSet set;
	
	/**
	 * This helper function is created to clear and add values to the IntegerSet. We have to add values at multiple places while testing, so
	 * I created this method to avoid redundant codes. It takes an integer list and adds the values to the IntegerSet.
	 * @param values: first integer set to compare
	 * @param set: integer set to add_values
	 */
	public void clear_and_add_values(Integer[] values, IntegerSet set) {
		set.clear();
		for (Integer val: values) {
			set.add(val);
		}
	}
	
	@BeforeEach
	void setUp() {
		set = new IntegerSet();
	}
	
	/*###############################################################################################################*/
	
	@Test
	@DisplayName("test add")
	public void testAdd(){
		set.add(-4);
		assertAll("Test add() #1", () -> assertTrue(set.contains(-4)), () -> assertEquals(set.length(), 1));
		set.add(-4);
		
		// After adding -4 to the set, it should pass the test assertTrue(set.contains(-4)) and the length of the set should be 1
		assertAll("Test add() #2", () -> assertTrue(set.contains(-4)), () -> assertEquals(set.length(), 1));
		
		// There is no 35 in the set, so it should pass the test assertFalse(set.contains(35)), and the length is still 1
		assertAll("Test add() #3", () -> assertFalse(set.contains(35)), () -> assertEquals(set.length(), 1));
		
		set.add(35);	// Adding 35 to the set
		
		// After adding 35 to the set, it should pass the test assertTrue(set.contains(35)) and the length of the set should be 2
		assertAll("Test add() #4", () -> assertTrue(set.contains(35)), () -> assertEquals(set.length(), 2));
		
		// There is no 0 in the set, so it should pass the test assertFalse(set.contains(0)), and the length is still 2
		assertAll("Test add() #5", () -> assertFalse(set.contains(0)), () -> assertEquals(set.length(), 2));
	}
	
	/*###############################################################################################################*/
	
	@Test
	@DisplayName("test clear")
	public void testClear(){
		clear_and_add_values(new Integer[] {9, 36, -4}, set);	// 3 elements are added to the set
		
		// The set contains some elements, so it should pass the test assertFalse(set.isEmpty()), with length of 3
		assertAll("Test clear() #1", () -> assertFalse(set.isEmpty()), () -> assertEquals(set.length(), 3));
		
		set.clear();	// Clearing the set
		
		// After clearing the set, it should be a empty set with length 0
		assertAll("Test clear() #2", () -> assertTrue(set.isEmpty()), () -> assertEquals(set.length(), 0));
	}
	
	/*###############################################################################################################*/
	
	@Test
	@DisplayName("test length")
	public void testLength(){
		set.add(-9);
		assertEquals(set.length(), 1);	// Adding -9 to the set makes length=1
		
		set.add(36);
		assertEquals(set.length(), 2);	// Adding 36 to the set makes length=2
		
		set.add(27);
		assertEquals(set.length(), 3);	// Adding 27 to the set makes length=3
		
		set.remove(36);
		assertEquals(set.length(), 2);	// Removing 36 from the set makes length=2 again
		
		set.clear();
		assertEquals(set.length(), 0);	// Clearing the set, makes length=0
	}
	
	/*###############################################################################################################*/
	
	@Test
	@DisplayName("test equals")
	public void testEquals(){
		IntegerSet set2 = new IntegerSet();
		
		set.add(9);
		set2.add(9);
		assertTrue(set.equals(set2));	// set and set2 both as same elements 9
		
		set.add(-5);
		assertFalse(set.equals(set2));	// set contains -5 but set2 does not contain -5, so not equal
		
		set2.add(-5);
		assertTrue(set.equals(set2));	// -5 is added to set2, thus both are equal again
		
		set.add(0);
		assertFalse(set.equals(set2));	// set contains 0 but set 2 does not contain 0, so not equal
		
		set2.add(0);
		assertTrue(set.equals(set2));	// 0 is added to set2, so both are equal again
	}
	
	/*###############################################################################################################*/
	
	@Test
	@DisplayName("test contains")
	public void testContains(){
		clear_and_add_values(new Integer[] {36, 9}, set);
		
		assertTrue(set.contains(9));	// set contains 9
		assertFalse(set.contains(-4));	// set does not contain -4
		assertTrue(set.contains(36));	// set contains 36
		assertFalse(set.contains(63));	// set does not contain 63
	}
	
	/*###############################################################################################################*/
	
	@Test
	@DisplayName("test remove")
	public void testRemove(){
		set.add(36);
		assertAll("Test remove() #1", () -> assertTrue(set.contains(36)), () -> assertEquals(set.length(), 1));
		
		set.add(9);
		assertAll("Test remove() #2", () -> assertTrue(set.contains(9)), () -> assertEquals(set.length(), 2));
		
		set.remove(36);
		assertAll("Test remove() #3", () -> assertFalse(set.contains(36)), () -> assertEquals(set.length(), 1));
		
		set.remove(9);
		assertAll("Test remove() #4", () -> assertFalse(set.contains(9)), () -> assertEquals(set.length(), 0));
	}
	
	/*###############################################################################################################*/
	
	@Test
	@DisplayName("test union")
	public void testUnion(){
		IntegerSet set2 = new IntegerSet();
		IntegerSet unionTestSet = new IntegerSet();
		
		// Case #1: Disjoint sets (No common elements)
		clear_and_add_values(new Integer[] {-1,0,2,5}, set);
		clear_and_add_values(new Integer[] {3,-6,12,9}, set2);
		clear_and_add_values(new Integer[] {-1,0,2,5,3,-6,12,9}, unionTestSet);
				
		set.union(set2);
		assertTrue(set.equals(unionTestSet));
		
		// Case #2: Partially intersected sets (Some common elements)
		clear_and_add_values(new Integer[] {-1,0,2,5}, set);
		clear_and_add_values(new Integer[] {0,-6,5,9}, set2);
		clear_and_add_values(new Integer[] {-1,0,2,5,-6,9}, unionTestSet);
		
		set.union(set2);
		assertTrue(set.equals(unionTestSet));
		
		// Case #3: Completely intersected sets (All common elements)
		clear_and_add_values(new Integer[] {-1,0,2,5}, set);
		clear_and_add_values(new Integer[] {-1,0,2,5}, set2);
		clear_and_add_values(new Integer[] {-1,0,2,5}, unionTestSet);
		
		set.union(set2);
		assertTrue(set.equals(unionTestSet));
	}
	
	/*###############################################################################################################*/
	
	@Test
	@DisplayName("test intersection")
	public void testIntersection(){
		IntegerSet set2 = new IntegerSet();
		IntegerSet intersectTestSet = new IntegerSet();
		
		// Case #1: Disjoint sets (No common elements)
		clear_and_add_values(new Integer[] {-1,0,2,5}, set);
		clear_and_add_values(new Integer[] {3,-6,12,9}, set2);
		
		set.intersection(set2);
		assertTrue(set.equals(intersectTestSet));
		
		// Case #2: Partially intersected sets (Some common elements)
		clear_and_add_values(new Integer[] {-1,0,2,5}, set);
		clear_and_add_values(new Integer[] {0,-6,5,9}, set2);
		clear_and_add_values(new Integer[] {0,5}, intersectTestSet);
		
		set.intersection(set2);
		assertTrue(set.equals(intersectTestSet));
		
		// Case #3: Completely intersected sets (All common elements)
		clear_and_add_values(new Integer[] {-1,0,2,5}, set);
		clear_and_add_values(new Integer[] {-1,0,2,5}, set2);
		clear_and_add_values(new Integer[] {-1,0,2,5}, intersectTestSet);
		
		set.intersection(set2);
		assertTrue(set.equals(intersectTestSet));
	}
	
	/*###############################################################################################################*/
	
	@Test
	@DisplayName("test difference")
	public void testDifference(){
		IntegerSet set2 = new IntegerSet();
		IntegerSet diffTestSet = new IntegerSet();
		
		// Case #1: Disjoint sets (No common elements)
		clear_and_add_values(new Integer[] {-1,0,2,5}, set);
		clear_and_add_values(new Integer[] {3,-6,12,9}, set2);
		clear_and_add_values(new Integer[] {-1,0,2,5}, diffTestSet);
		
		set.diff(set2);
		assertTrue(set.equals(diffTestSet));
		
		// Case #2: Partially intersected sets (Some common elements)
		clear_and_add_values(new Integer[] {-1,0,2,5}, set);
		clear_and_add_values(new Integer[] {0,-6,5,9}, set2);
		clear_and_add_values(new Integer[] {-1,2}, diffTestSet);
		
		set.diff(set2);
		assertTrue(set.equals(diffTestSet));
		
		// Case #3: Completely intersected sets (All common elements)
		clear_and_add_values(new Integer[] {-1,0,2,5}, set);
		clear_and_add_values(new Integer[] {-1,0,2,5}, set2);
		clear_and_add_values(new Integer[] {}, diffTestSet);
		
		set.diff(set2);
		assertTrue(set.equals(diffTestSet));
	}
	
	/*###############################################################################################################*/
	
	@Test
	@DisplayName("test largest")
	public void testLargest() throws IntegerSetException{
		clear_and_add_values(new Integer[] {0,-4,9,36}, set);
		assertEquals(set.largest(), 36);	// 36 is the largest element
		
		set.remove(36);
		assertEquals(set.largest(), 9);	// After removing, 36 from the set, 9 is the largest element
		
		set.clear();
	}
	
	@Test
	@DisplayName("test largest exception")
	public void testLargest_Throws_IntegerSetException() throws IntegerSetException{
		Throwable exception = assertThrows(IntegerSetException.class, () -> set.largest());
		assertEquals("Set is Empty!", exception.getMessage());	// exception's message is "Set is Empty!"
	}
	
	/*###############################################################################################################*/
	
	@Test
	@DisplayName("test smallest")
	public void testSmallest() throws IntegerSetException{
		clear_and_add_values(new Integer[] {0,-4,9,36}, set);
		assertEquals(set.smallest(), -4);
	}
	
	@Test
	@DisplayName("test smalles exception")
	public void testSmallest_Throws_IntegerSetException() throws IntegerSetException{
		Throwable exception = assertThrows(IntegerSetException.class, () -> set.smallest());
		assertEquals("Set is Empty!", exception.getMessage());	// exception's message is "Set is Empty!"
	}
	
	/*###############################################################################################################*/
	
	@Test
	@DisplayName("test isEmpty")
	public void testIsEmpty(){
		
		// Case #1: Non-empty set
		clear_and_add_values(new Integer[] {9,4,27}, set); 
		assertFalse(set.isEmpty());
		
		// Case #2: Empty set
		set.clear();
		assertTrue(set.isEmpty());
	}
	
	/*###############################################################################################################*/
	
	@Test
	@DisplayName("test toString")
	public void testToString(){
		
		clear_and_add_values(new Integer[] {9,4,27}, set);
		String testStr = "[9, 4, 27]";
		
		assertTrue(set instanceof IntegerSet);	// Testing whether set belongs to the IntegerSet class
		
		// Testing whether return value of set.toString() is the instance of String class, and is same as our testStr
		assertAll("Test toString()", () -> assertTrue(set.toString() instanceof String), () -> assertEquals(set.toString(), testStr));
	}
	
	
	/*###############################################################################################################*/
	
}
