package org.howard.edu.lsp.finals.problem;

import java.util.*;

public class SongsDatabase {
		
		/* Key is the genre, HashSet contains associated songs */
	    private Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();
		
	    
	    /**
	     * Add a song title to a genre
	     * @param genre
	     * @param songTitle
	     */
	    public void addSong(String genre, String songTitle) {
	    	
	    	HashSet<String> genreSet;
	    	// Here we check if the genre is present in our HashMap or not, and if not we add it
	        if (!map.containsKey(genre)) {
	            map.put(genre, new HashSet<String>());
	        }
	        
	        // Then, we can add the songTitle to our HashSet
	        genreSet = map.get(genre);
	        genreSet.add(songTitle);
	        
	        // Finally put the genreSet to the Map
	        map.put(genre, genreSet);
	    }

	    
	    /**
	     * Return the Set that contains all songs for a genre
	     * @param genre
	     * @return
	     */
	    public Set<String> getSongs(String genre) throws SongsDatabaseException {
	    	
	    	// First, we check if the genre is present in the HashMap or not
	    	if (!map.containsKey(genre)) {
	    		throw new SongsDatabaseException("No Genre Found");
	    	}

	    	// if genre found, then get the songs
	    	return map.get(genre);
	    }

	    
	    /**
	     * Return genre, i.e., jazz, given a song title
	     * @param songTitle
	     * @return genre if genre else null
	     */
	    public String getGenreOfSong(String songTitle) {
	    	HashSet<String> songSet;
	    	// We loop over the genre names and check if the songTitle is present in that genre
	        for (String genre : map.keySet()) {
	        	songSet = map.get(genre);
	            if (songSet.contains(songTitle)) {
	                return genre;
	            }
	        }
	        // If no genre match the songTitle, then return empty string
	        return "";
	    }
	}
