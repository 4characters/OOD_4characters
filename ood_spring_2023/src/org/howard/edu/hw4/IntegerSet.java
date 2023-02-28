package org.howard.edu.hw4;
import java.util.*;

/**
 * 
 * @author Manish Bhurtel (@02964727)
 *
 */
public class IntegerSet {
	private ArrayList<Integer> set;
	
	
	/**
	 * This is the default constructor of the IntergetSet class that initializes the set attribute as an ArrayList
	 */
	public IntegerSet() {set = new ArrayList<Integer>();}
	
	
	/**
	 * Adds the given item to the IntegerSet if the set does not contain that item
	 * @param item: integer type item to add to the set if not present already
	 */
	public void add(int item) {
		if (!set.contains(item)){
			set.add(item);
		}
	}
	
	/**
	 * Clears the internal representation of the Integer Set
	 */
	public void clear() {set.clear();}
	
	
	/**
	 * Returns the number of elements in the set
	 * @return integer length of the set
	 */
	public int length() {return set.size();}
	
	
	 /**
	  * Checks whether the given two sets are equal or not
	  * @param b: another Integerset to check if it is equal to the current Integerset
	  * @return true if the two sets are equal, and if not equal then false
	  */
	@SuppressWarnings("unchecked")
	public boolean equals(IntegerSet b) {
		ArrayList<Integer> setCopy =  (ArrayList<Integer>) set.clone();	// Cloning the set of the 
		setCopy.sort(null);	// Sorting the set setCopy
		b.set.sort(null);	// Sorting the set b
		
		if (setCopy.equals(b.set)) {	// Comparing the sorted sets
			return true;
		}
		return false;
	}
	
	
	/**
	 * Returns true if the set contains the value, otherwise it returns false
	 * @param value: integer value to check if it is present in the set
	 * @return true if the value is present in the set, and if not present then false
	 */
	public boolean contains(int value) {
		if (set.contains(value)) {
			return true;
		}
		return false;
	}
	
	
	/**
	 * Finds the largest item in the set
	 * @return largest item in the set
	 * @throws IntegerSetException if the set is empty
	 */
	public int largest() throws IntegerSetException {
		if(this.isEmpty()) {
			throw new IntegerSetException("Set is Empty!");
		}
		return Collections.max(set);
	}
	
	
	/**
	 * Finds the smallest item in the set
	 * @return smallest item in the set
	 * @throws IntegerSetException if the set is empty
	 */
	public int smallest() throws IntegerSetException {
		if(this.isEmpty()) {
			throw new IntegerSetException("Set is Empty!");
		}
		return Collections.min(set);
	}
	
	
	/**
	 * Removes the item from the set
	 * @param item: the item to remove from the set if present in the set
	 */
	public void remove(int item) {
		if (this.contains(item)) {
			set.remove((Object) item);
		}
	}
	
	
	/**
	 * Performs the union of two sets
	 * @param intSetb: another set to perform the union with the current set
	 */
	public void union(IntegerSet intSetb) {
		for (Integer num: intSetb.set) {
			if (!this.contains(num)){
				this.add(num);
			}
		}
	}
	
	
	/**
	 * Performs the intersection of two sets
	 * @param intSetb: another set to perform the intersection with the current set
	 */
	@SuppressWarnings("unchecked")
	public void intersection(IntegerSet intSetb) {
		for (Integer num: (ArrayList<Integer>) set.clone()) {	// Looping over the clone of this.set, since we will refactor this.set
			if (!intSetb.contains(num)) {	// If the item is not present in intSetb, then we remove it from this.set
				this.remove(num);
			}
		}
	}
	
	
	/**
	 * Performs the difference operation between two sets
	 * @param intSetb: another set to perform the difference with the current set
	 */
	public void diff(IntegerSet intSetb) {
		for (Integer num: intSetb.set) {
			if (this.contains(num)) {	// if the item present in intSetb is also present in this.set, then we remove it
				this.remove(num);
			}
		}
	}
	
	/**
	 * Checks whether the given set is empty or not
	 * @return true if the set is empty, if not empty then returns false
	 */
	public boolean isEmpty() {return set.isEmpty();}
	
	
	/**
	 * Converts the set into string format
	 * @return set in string format
	 */
	public String toString() {return set.toString();}
	
}

