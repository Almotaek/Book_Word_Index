import java.io.*;
import java.util.*;

/**
 * Abstract plan implementing methods that the three different classes have in common
 *
 * @author Tafita Rakotozandry & Taylor Strong & Khalid Al-Motaery
 * @version 11/28/2020
 */
public abstract class IndexAbstract  {
    public ArrayList <String> dictionary;

    /**
     * Writes all the words and their sets to a newly created output file
     */
    public abstract void createOutFile();

    /**
     * Adds the word and its line to the respective data structure being used
     * 
     * @param line Integer
     * @param w String
     * @return boolean
     */
    public abstract boolean add(String w, Integer line);

    /**
     * Reads the file provided, splits the lines into words, and has each word added to the data structure
     * 
     * @param fileName String
     */
    public void readFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName+".txt"));
            readDictionary();
            int lineCount = 1;

            String line = "";

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[^A-Za-z]+"); // Splits the line into individual words
                
                for (int i = 0; i < words.length; i++) {
                    words[i] = words[i].toLowerCase(); // Converts the word to lowercase
                    
                    add(words[i], lineCount); // Adds the word and the line it was found on the data structure
                }

                lineCount++; // Increments the line number being read
            }

        } catch (Exception e) {
            System.out.println("An error has occurred in readFile: " + e);
        }
    }

    /**
     * Reads the dictionary and add the words in a list. 
     */
    public void readDictionary() {
        try{ 
            BufferedReader reader = new BufferedReader(new FileReader("English.txt")); // read the dictionary 
            dictionary = new ArrayList <String> (); 
            String line = "";
            line = reader.readLine();
            
            
            while (line != null) {//as long as the line is not empty
                dictionary.add(line); //add the line in the dictionary
                line = reader.readLine();
            }

        } catch (Exception e) {
            System.out.println("An error has occured in createDictionary(): " + e);
        }
    }

    /**
     * Checks if the word is an english word 
     * 
     * @param w the word to check
     * @return true or false based on whether or not the word is an English word
     */
    public boolean isEnglish(String w) {
        int index = Collections.binarySearch(dictionary, w.toLowerCase());

        if (index < 0) { // Returns false if word not found
            return false;
        } else { // Returns true otherwise
            return true;
        }
    }


}