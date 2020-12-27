import java.util.*;
import java.io.*;

/**
 * Hash Index Implementation 
 *
 * @author Tafita Rakotozandry & Taylor Strong & Khalid Al-Motaery
 * @version 11/28/2020
 */
public class HashIndex  extends IndexAbstract implements Index {
    private static HashMap <String, TreeSet<Integer>> hashMap;
    public static ArrayList <String> list;

    /**
     * Constructor for the HashIndex class
     */
    public HashIndex() {
        hashMap = new HashMap <String, TreeSet<Integer>> ();
    }

    /**
     * Creates and writes the output file  
     */
    public void createOutFile() {
        try {
            //create the output file 
            File outputFile = new File("HashOutput.txt"); 
            outputFile.createNewFile();
            
            //set the key 
            Set <String> s = hashMap.keySet(); 
            
            list = new ArrayList <String> ();//create an arrayList

            for (String key: s) {//add all the key in the arrayList
                list.add(key); 
            }
            
            //sort the list 
            //sort needed to be performed because hasmap is not sorted 
            Collections.sort(list); 

            //write output in the line 
            PrintWriter writeFile = new PrintWriter(outputFile);
            Iterator <String> itr = list.iterator();
            while (itr.hasNext()) {
                String line = itr.next();
                writeFile.println(line + " " + hashMap.get(line));
            }

            writeFile.close();

        } catch (Exception e) {
            System.out.println("An error has occurred " + e);
        }
    }
    
    /**
     * Adds a word in the HashMap 
     * 
     * @param w the word to add to the HashMap
     * @param k the line number of the word
     * @return true or false depending on if the addition was successful or not
     */
    public boolean add(String w, Integer k) {

        if (!isEnglish(w)) { //return false if the word is not in english 
            return false; 
        }

        if (!hashMap.containsKey(w)) {  //if the word is not the hash map  
            hashMap.put(w, new TreeSet <Integer> ()); //put the word in the hashmap 
            hashMap.get(w).add(k); //add the line corresponding to the word in the hashmap 
            return true;

        } else if (hashMap.containsKey(w)) { //if the word is in the hash map  
            if (!hashMap.get(w).contains(k)) {//if the word is in the hash map  
                hashMap.get(w).add(k); //add the line corresponding to the word in the hashmap 
                return true;
            } 
        }

        return false;
    }
}