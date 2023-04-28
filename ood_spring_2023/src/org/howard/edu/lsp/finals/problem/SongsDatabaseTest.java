package org.howard.edu.lsp.finals.problem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SongsDatabaseTest {
	private SongsDatabase db;
	
	@BeforeEach
    public void setUp() {
        db = new SongsDatabase();
    }
	
	@Test
	@DisplayName("test AddSong")
    public void testAddSong() {
        db.addSong("Rap", "Savage");
        
		assertAll("Test AddSong() #1",
				  () -> assertEquals(db.getSongs("Rap").size(), 1), 
				  () -> assertTrue(db.getSongs("Rap").contains("Savage")));
		
        db.addSong("Rap", "Gin and Juice");
		assertAll("Test AddSong() #2", 
				  () -> assertEquals(db.getSongs("Rap").size(), 2), 
				  () -> assertTrue(db.getSongs("Rap").contains("Gin and Juice")));
        
        db.addSong("Jazz", "Always There");
		assertAll("Test AddSong() #2", 
				  () -> assertEquals(db.getSongs("Jazz").size(), 1), 
				  () -> assertTrue(db.getSongs("Jazz").contains("Always There")));
    }
	
	
	@Test
	@DisplayName("test GetSongs")
    public void testGetSongs() throws SongsDatabaseException{
		
        db.addSong("Rap", "Savage");
        assertEquals(db.getSongs("Rap").size(), 1);
        assertTrue(db.getSongs("Rap").contains("Savage"));
		
        db.addSong("Rap", "Gin and Juice");
        assertEquals(db.getSongs("Rap").size(), 2);
		assertTrue(db.getSongs("Rap").contains("Gin and Juice"));
        
		db.addSong("Jazz", "Always There");
		assertTrue(db.getSongs("Jazz").contains("Always There"));
		assertEquals(1, db.getSongs("Jazz").size());
    }
	
	@Test
	@DisplayName("test testGetSongs exception")
	public void testLargest_Throws_SongsDatabaseException() throws SongsDatabaseException{
		Throwable exception = assertThrows(SongsDatabaseException.class, () -> db.getSongs("Rap"));
		assertEquals("No Genre Found", exception.getMessage());
	}
	
	
	@Test
	@DisplayName("test getGenreOfSong")
    public void testGetGenreOfSong() {
        SongsDatabase db = new SongsDatabase();
        db.addSong("Rock", "Unforgiven II");
        assertEquals(db.getGenreOfSong("Unforgiven II"), "Rock");
        
        db.addSong("Rock", "B.O.Y.B");
        assertEquals(db.getGenreOfSong("B.O.Y.B"), "Rock");
        
        // Test Empty String
        assertEquals(db.getGenreOfSong("Country Roads"), "");
    }

}
