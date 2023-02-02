package org.howard.edu.hw2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


// Name: Manish Bhurtel (@02964727)

public class WordCounter {
	public static void main(String[] args) throws IOException {
		
		// Creating the HashMap object to store the word as key and count as value
		Map<String, Integer> wordsMap = new HashMap<>();
		
		// Specifying the location of the file
		String filepath = "src/main/resources/file.txt";
		
		System.out.println("The input text in the file is as follows:\n");
		System.out.println("--------------------------------------------------------------------------------------------");
		
		// In order to use readLine command, we create the BufferedReader object
		try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
			String line;
			
			// Reading each line from the text file
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				
				// Splitting the string 'line' to lower case and splitting using a space
				String[] splitLine = line.toLowerCase().split(" ");
				
				// Now we loop over each word in the split line
				for (String word : splitLine) {
					
					// We exclude the word that does not contain alphabet or has length <= 3
					if (word.matches("[^a-zA-Z]*") || (word.length() <= 3)) {
						continue;
					}
					
					// Here we check whether the word is already present in the HashMap or not
					if (!wordsMap.containsKey(word)) {
						wordsMap.put(word, 1);	// Put value = 1 if the word is not in HashMap
						} else {
							wordsMap.put(word, wordsMap.get(word) + 1);
						}	// If word is present in the HashMap, then increase the count by 1
					}
				}
			}
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("\nThe count of each unique word is shown below:");
		
		// Printing the count of each word by extracting the keys and values from the HashMap
		for (String name: wordsMap.keySet()) {
		    System.out.println(name + " " + wordsMap.get(name));
		}
	}
}
