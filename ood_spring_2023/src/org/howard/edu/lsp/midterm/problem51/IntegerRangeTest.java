package org.howard.edu.lsp.midterm.problem51;

import static org.junit.Assert.assertTrue;

import org.howard.edu.hw5.IntegerSetException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerRangeTest {
	private IntegerRange range;
	
    @BeforeEach
    public void setUp() {
        range = new IntegerRange(-10, 10);
    }
    
    @Test
    @DisplayName("test contains")
    public void testContains() {
        assertTrue(range.contains(0));
        assertFalse(range.contains(-25));
        assertTrue(range.contains(5));
        assertFalse(range.contains(15));
    }
    
    @Test
    @DisplayName("test overlaps")
    public void testOverlaps() throws EmptyRangeException {
    	
    	// some values overlaps
        IntegerRange otherRange1 = new IntegerRange(-15, 0);
        assertTrue(range.overlaps(otherRange1));
        
    	// all values overlaps
        IntegerRange otherRange2 = new IntegerRange(-10,10);
        assertTrue(range.overlaps(otherRange2));
    	
    	// Upper of other is smaller than lower of this.range
        IntegerRange otherRange3 = new IntegerRange(-20, -15);
        assertFalse(range.overlaps(otherRange3));
        
    	// lower of other is larger than upper of this.range
        IntegerRange otherRange4 = new IntegerRange(11, 25);
        assertFalse(range.overlaps(otherRange4));
    }
    
	@Test
	@DisplayName("test overlaps exception")
	public void testOverlaps_Throws_EmptyRangeException() throws IntegerSetException{
		Throwable exception = assertThrows(EmptyRangeException.class, () -> range.overlaps(null));
		assertEquals("Range is Null!", exception.getMessage());	// exception's message is "Range is Null!"
	}
	
    @Test
    @DisplayName("test size")
    public void testSize() {
        assertEquals(21, range.size());	// upper - lower + 1
        IntegerRange otherRange = new IntegerRange(0, 15);
        assertEquals(16, otherRange.size());
    }
}
