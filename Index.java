import java.util.*;
import java.io.*;

/**
 * Index Interface
 *
 * @author Tafita Rakotozandry & Taylor Strong & Khalid Al-Motaery
 * @version 11/28/2020
 */
public interface Index
{
    /**
     * Creates an Output File 
     */
    public  void createOutFile();

    /**
     * Adds a word and its respective line to the data structure
     * 
     * @param k the line number of the word
     * @param w the word to add 
     * @return boolean
     */
    public  boolean add(String w, Integer k);

    /**
     * Reads the provided file 
     * 
     * @param fileName the name of the file 
     */
    public void readFile(String fileName) ;

}