import java.util.*;
import java.io.*; 
import java.util.List; 
import java.util.ArrayList; 
import java.util.Collections;

/**
 * Sorted ArrayList Index Implementation
 *
 * @author Tafita Rakotozandry & Taylor Strong & Khalid Al-Motaery
 * @version 11/28/2020
 */
public class ArrayIndex extends IndexAbstract implements Index 
{
    private static ArrayList<Entry> theArray;
    private static ArrayList<String> arrayOfWords;
    Comparator<Entry> c;

    /**
     * Constructor for objects of class SortedArray
     */
    public ArrayIndex()
    {
        theArray = new ArrayList<Entry>();
        arrayOfWords = new ArrayList<String>();

        c = new Comparator<Entry>()
        {
            public int compare(Entry e1, Entry e2){
                return e1.getWord().compareTo(e2.getWord());
            }
        };
    }

    /**
     * Adds a word to the ArrayList
     *
     * @param  w  the word that is being added to the ArrayList
     * @param  k  the line that the word is on
     * @return  true or false depending on if the addition was successful or not
     */
    public boolean add(String w, Integer k)
    {
        String word = w.toLowerCase();
        
        if (!isEnglish(word)) {
            return false; 
        }
        
        if (theArray.size() == 0){
            Entry newEntry = new Entry(word, k);
            theArray.add(newEntry);
            arrayOfWords.add(word);
            return true;
        }
        else{
            int index = Collections.binarySearch(arrayOfWords, word);

            if (index < 0){
                Entry newEntry = new Entry(word, k);
                theArray.add(-index - 1, newEntry);
                arrayOfWords.add(-index - 1, word);
                return true;
            }
            else {
                return theArray.get(index).addLine(k);
            }
        }
    }

    /**
     * Creates and writes the output file 
     */
    public void createOutFile(){
        try{
            //create the output file 
            File outputFile = new File("ArrayOutput.txt"); 
            outputFile.createNewFile();

            PrintWriter writeFile = new PrintWriter(outputFile);
            Iterator <Entry> itr = theArray.iterator();
            Entry entry = null;
            while (itr.hasNext()) {
                entry = itr.next();
                writeFile.println(entry.getWord() + " " + entry.getLines());
            }
            
            writeFile.close();
        } catch (Exception e) {
            System.out.println("An error has occurred in createOutFile: " + e);
        }
    }
}
