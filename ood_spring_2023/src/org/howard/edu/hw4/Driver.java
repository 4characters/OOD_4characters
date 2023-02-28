package org.howard.edu.hw4;

/**
 * 
 * @author Manish Bhurtel (@02964727)
 *
 */

@SuppressWarnings("serial")
class IntegerSetException extends Exception
{
    public IntegerSetException(String str)
    {
        // Call constructor of parent Exception
        super(str);
    }
}


public class Driver {
	
	/**
	 * This helper function is created to check multiple test cases of equals() method and avoid redundant code. It takes  two
	 * IntegerSets and compares the equality of the two.
	 * @param set1: first integer set to compare
	 * @param set2: second integer set to compare
	 */
	public void print_equals(IntegerSet set1, IntegerSet set2) {
		System.out.println("Value of set1:" + set1.toString());
		System.out.println("Value of set2:" + set2.toString());
		
		if (set1.equals(set2)) {
			System.out.println("Result: set1 and set2 are equal!");
		}
		else {
			System.out.println("Result: set1 and set2 are not equal!");
		}
	}
	
	/**
	 * This helper function is created to add values to the IntegerSet. We have to add values at multiple places while testing, so
	 * I created this method to avoid redundant codes. It takes an integer list and adds the values to the IntegerSet.
	 * @param values: first integer set to compare
	 * @param set2: integer set to add_values
	 */
	public void add_values(Integer[] values, IntegerSet set1) {
		set1.clear();
		for (Integer val: values) {
			set1.add(val);
		}
	}
	
	/**
	 * This helper function is created to check multiple test cases of equals() method and avoid redundant code. It takes an
	 * IntegerSet object and checks whether the item is present in the set.
	 * @param values: first integer set to compare
	 * @param set2: integer set to add_values
	 */
	public void print_contains(IntegerSet set1, Integer item) {
		System.out.println("Value of set1: " + set1.toString());
		System.out.println("Value of item: " + item);
		if (set1.contains(item)) {
			System.out.println("Result: set1 contains the item " + item);
		}else {
			System.out.println("Result: set1 does not contain the item " + item);
		}
	}
	
	/**
	 * This helper function is created to check multiple test cases of isEmpty() method and avoid redundant code. It takes an
	 * IntegerSet and checks whether it is empty or not.
	 * @param set1
	 */
	public void print_isEmpty(IntegerSet set1) {
		System.out.println("Value of set1: " + set1.toString());
		if (set1.isEmpty()) {
			System.out.println("Result: set1 is empty!");
		}else {
			System.out.println("Result: set1 is not empty!");
		}
	}
	
	
	public static void main(String[] args) throws IntegerSetException{
		
		Driver d = new Driver();	// This object will be used to invoke other methods inside the class		
		
		System.out.println("1. Testing default constructor: ");
		System.out.println("-----------------------------");
		IntegerSet set1 = new IntegerSet(), set2 = new IntegerSet();
		System.out.println("Two sets are initialized to be empty sets!");
		System.out.println("Value of set1: " + set1.toString() + " and value of set2: " + set2.toString());
		
		/*###########################################################################################################*/
		
		System.out.println("\n\n2. Testing add() method: ");
		System.out.println("------------------------");

		System.out.println("Intially, value of set1:" + set1.toString());
		set1.add(-1);
		set1.add(0);
		set1.add(1);
		System.out.println("After adding 3 elements, value of set1: " + set1.toString() + "");
		
		/*###########################################################################################################*/
		
		System.out.println("\n\n3. Testing clear() method: ");
		System.out.println("--------------------------");
		System.out.println("Value of set1:" + set1.toString());
		set1.clear();
		System.out.println("After applying clear() method, value of set1: " + set1.toString() + "");
		
		/*###########################################################################################################*/
		
		System.out.println("\n\n4. Testing length() method: ");
		System.out.println("---------------------------");
		d.add_values(new Integer[] {-1,-2,0,3,2,4}, set1);
		System.out.println("Value of set1:" + set1.toString());
		System.out.println("Length of set1: " + set1.length() + "");
		
		/*###########################################################################################################*/
		
		System.out.println("\n\n5. Testing equals() method: ");
		System.out.println("---------------------------");
		
		System.out.println("Test Case #1: Both sets have same elements in same order");
		d.add_values(new Integer[] {-1,-2,0,3,2,4}, set2);
		d.print_equals(set1, set2);
		
		System.out.println("\nTest Case #2: Both sets have same elements but different order");
		d.add_values(new Integer[] {3,-2,4,-1,2,0}, set2);
		d.print_equals(set1, set2);
		
		System.out.println("\nTest Case #3: Both sets have some items common but different lengths");
		d.add_values(new Integer[] {-1,0,2,4,5}, set2); 
		d.print_equals(set1, set2);
		
		System.out.println("\nTest Case #4: Both sets are entirely different");
		d.add_values(new Integer[] {13,-12,7,-10,21,6}, set2);
		d.print_equals(set1, set2);
		
		/*###########################################################################################################*/
		
		System.out.println("\n\n6. Testing contains() method: ");
		System.out.println("-----------------------------");
		
		System.out.println("Test Case #1: Item present in the set");
		d.print_contains(set1, 3);
		
		System.out.println("\nTest Case #2: Item not present in the set");
		d.print_contains(set1, -9);	
		
		/*###########################################################################################################*/
		
		System.out.println("\n\n7. Testing largest() method: ");
		System.out.println("-----------------------------");
		System.out.println("Value of set1: " + set1.toString());
		System.out.println("Largest value of set1: " + set1.largest());
		
		/*###########################################################################################################*/
		
		System.out.println("\n\n8. Testing smallest() method: ");
		System.out.println("-----------------------------");
		System.out.println("Value of set1 is: " + set1.toString());
		System.out.println("Smallest value of set1: " + set1.smallest());
		
		/*###########################################################################################################*/
		
		System.out.println("\n\n9. Testing remove() method: ");
		System.out.println("----------------------------");
		System.out.println("Value of set1: " + set1.toString());
		set1.remove(-2);
		System.out.println("After removing -2, value of set1: " + set1.toString() + "");
		
		/*###########################################################################################################*/
		
		System.out.println("\n\n10. Testing union() method (set1 u set2): ");
		System.out.println("-----------------------------------------");
		System.out.println("Case #1: Disjoint sets (No common elements)");
		d.add_values(new Integer[] {-1,0,2,5}, set1); 
		d.add_values(new Integer[] {3,-6,12,9}, set2); 
		System.out.println("Value of set1: " + set1.toString());
		System.out.println("Value of set2: " + set2.toString());
		set1.union(set2);
		System.out.println("Value of set1 union with set2: " + set1.toString());
		
		System.out.println("\nCase #2: Partially intersected sets (Some common elements)");
		d.add_values(new Integer[] {-1,0,2,5}, set1); 
		d.add_values(new Integer[] {0,-6,5,9}, set2); 
		System.out.println("Value of set1: " + set1.toString());
		System.out.println("Value of set2: " + set2.toString());
		set1.union(set2);
		System.out.println("Value of set1 union with set2: " + set1.toString());
		
		System.out.println("\nCase #3: Completely intersected sets (All common elements)");
		d.add_values(new Integer[] {-1,0,2,5}, set1); 
		d.add_values(new Integer[] {-1,0,2,5}, set2); 
		System.out.println("Value of set1: " + set1.toString());
		System.out.println("Value of set2: " + set2.toString());
		set1.union(set2);
		System.out.println("Value of set1 union with set2: " + set1.toString());
		
		/*###########################################################################################################*/
		
		System.out.println("\n\n11. Testing intersection() method (set1 n set2): ");
		System.out.println("------------------------------------------------");
		System.out.println("Case #1: Disjoint sets (No common elements)");
		d.add_values(new Integer[] {-1,0,2,5}, set1); 
		d.add_values(new Integer[] {3,-6,12,9}, set2); 
		System.out.println("Value of set1: " + set1.toString());
		System.out.println("Value of set2: " + set2.toString());
		set1.intersection(set2);
		System.out.println("Value of set1 intersection with set2: " + set1.toString());
		
		System.out.println("\nCase #2: Partially intersected sets (Some common elements)");
		d.add_values(new Integer[] {-1,0,2,5}, set1); 
		d.add_values(new Integer[] {0,-6,5,9}, set2); 
		System.out.println("Value of set1: " + set1.toString());
		System.out.println("Value of set2: " + set2.toString());
		set1.intersection(set2);
		System.out.println("Value of set1 intersection with set2: " + set1.toString());
		
		System.out.println("\nCase #3: Completely intersected sets (All common elements)");
		d.add_values(new Integer[] {-1,0,2,5}, set1);
		d.add_values(new Integer[] {-1,0,2,5}, set2);
		System.out.println("Value of set1: " + set1.toString());
		System.out.println("Value of set2: " + set2.toString());
		set1.intersection(set2);
		System.out.println("Value of set1 intersection with set2: " + set1.toString());
		
		/*###########################################################################################################*/
		
		System.out.println("\n\n12. Testing diff() method (set1 - set2): ");
		System.out.println("------------------------------------------");
		System.out.println("Case #1: Disjoint sets (No common elements)");
		d.add_values(new Integer[] {-1,0,2,5}, set1); 
		d.add_values(new Integer[] {3,-6,12,9}, set2); 
		System.out.println("Value of set1: " + set1.toString());
		System.out.println("Value of set2: " + set2.toString());
		set1.diff(set2);
		System.out.println("Value of set1 difference with set2: " + set1.toString());
		
		System.out.println("\nCase #2: Partially intersected sets (Some common elements)");
		d.add_values(new Integer[] {-1,0,2,5}, set1); 
		d.add_values(new Integer[] {0,-6,5,9}, set2); 
		System.out.println("Value of set1: " + set1.toString());
		System.out.println("Value of set2: " + set2.toString());
		set1.diff(set2);
		System.out.println("Value of set1 difference with set2: " + set1.toString());
		
		System.out.println("\nCase #3: Completely intersected sets (All common elements)");
		d.add_values(new Integer[] {-1,0,2,5}, set1);
		d.add_values(new Integer[] {-1,0,2,5}, set2);
		System.out.println("Value of set1: " + set1.toString());
		System.out.println("Value of set2: " + set2.toString());
		set1.diff(set2);
		System.out.println("Value of set1 difference with set2: " + set1.toString());
		
		/*###########################################################################################################*/
		
		System.out.println("\n\n13. Testing isEmpty() method");
		System.out.println("------------------------------");
		System.out.println("Case #1: Non-empty set");
		d.add_values(new Integer[] {9,4,27}, set1); 
		d.print_isEmpty(set1);
		
		System.out.println("\nCase #2: Empty set");
		set1.clear();
		d.print_isEmpty(set1);
		
		/*###########################################################################################################*/
		
		System.out.println("\n\n14. Testing toString() method");
		System.out.println("--------------------------------");
		System.out.println("set1 is the object of: "+ set1.getClass());
		System.out.println("After invoking toString() method, we get: " + set1.toString().getClass());
	}
}

