import java.util.*;
import java.io.*; 

/**
 * Tree Index Implementation 
 *
 * @author Tafita Rakotozandry & Taylor Strong & Khalid Al-Motaery
 * @version 11/28/2020
 */
public class TreeIndex  extends IndexAbstract implements Index {
    private static TreeMap <String, TreeSet <Integer>> treeMap;

    /**
     * Constructor for the TreeIndex class
     */
    public TreeIndex() {
        treeMap = new TreeMap <String, TreeSet <Integer>> ();
    }

    /**
     * Creates and writes the output file  
     * 
     */
    public void createOutFile() {
        try {
            //create an output file 
            File outputFile = new File("TreeIndexOut.txt");
            outputFile.createNewFile();

            PrintWriter writeFile = new PrintWriter(outputFile);

            //create an iterator 
            Iterator <Map.Entry<String,TreeSet<Integer>>> iterator = treeMap.entrySet().iterator();
            Map.Entry <String, TreeSet<Integer>> entry = null;

            //go through the treeMap 
            while (iterator.hasNext()) {
                entry = iterator.next();
                writeFile.println(entry.getKey() + " " + entry.getValue());
            }

            //close the write File 
            writeFile.close();

        } catch (Exception e) {
            System.out.println("An error has occurred in createOutFile: " + e);
        }
    }

    /**
     * Adds each word and line to the TreeMap
     * 
     * @param w the word to enter into the TreeMap
     * @param k the line of the word
     * @return  true or false depending on if the addition was successful or not
     */
    public boolean add(String w, Integer k) {
        if (!isEnglish(w)) {//return false if the word is not in english 
            return false; 
        }

        //check if the word is in the treeMap 
        if (!treeMap.containsKey(w)) { //if the word is not the tree map  
            
            treeMap.put(w, new TreeSet <Integer> ()); //Associates the specified word with a new treeset 
            treeMap.get(w).add(k); //Add the line corresponding with the word 
            return true;
        } else if (treeMap.containsKey(w)) { //if the word is in the tree map already 
            if (!treeMap.get(w).contains(k)) { //if the current line is not repeated 
                treeMap.get(w).add(k); //Add the line corresponding with the word 
                return true;
            } 
        }

        return false; // return false if the testing was not successful 
    }
}