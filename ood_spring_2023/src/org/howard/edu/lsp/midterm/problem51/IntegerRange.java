package org.howard.edu.lsp.midterm.problem51;

public class IntegerRange implements Range {
	private int lower;
	private int upper;
	
	/**
	 * Constructor the InterRange class
	 * @param lower
	 * @param upper
	 */
  	 public IntegerRange(int lower, int upper) { 	// Constructor
 		this.lower = lower;
 		this.upper = upper;
  	 }
	
	/**
	 * Getter method for the lower private variable
	 * @return lower
	 */
    public int getLower() {
        return lower;
    }
    
	/**
	 * Getter method for the upper private variable
	 * @return upper
	 */
    public int getUpper() {
        return upper;
    }
    
    /**
     * This method checks whether the value lies in the range or not!
     * @param value: integer value to check
     * @return boolean: (true if the range contains the value, else false)
     */
	public boolean contains(int value) {
		if ((value >= lower) && (value <= upper)){
			return true;
		}
		return false;
	}

	/**
	 * This method checks if there are some common values in the two ranges or not
	 * @param other: the Range object
	 * @return boolean: (true if common else false)
	 * @throw EmptyRangeException: if the range is null
	 */
	public boolean overlaps(Range other) throws EmptyRangeException {
        if (other == null) {
            throw new EmptyRangeException("Range is Null!");
        }
        
        if ((other.getUpper() < this.lower) || (other.getLower() > this.upper)){
        	return false;
        }
        return true;
        
	}
	
	/**
	 * This method returns the size of the range
	 * @return total number of integers in the range
	 */
	public int size() {
		return this.upper - this.lower + 1;
	}
    
    
	
}
