import java.util.*;

/**
 * This class holds the words and their lines that will be added to ArrayList
 *
 * @author Tafita Rakotozandry & Taylor Strong & Khalid Al-Motaery
 * @version 11/28/2020
 */
public class Entry
{
    private String word;
    private TreeSet<Integer> lines;

    /**
     * Constructor for objects of class Entry
     */
    public Entry(String theWord, Integer theLine)
    {
        word = theWord;
        lines = new TreeSet<Integer>();
        lines.add(theLine);
    }

    /**
     * Adds a line to the word's TreeSet of lines
     *
     * @param  newLine  the line that is being added to the word's TreeSet of lines
     * @return  true or false based on whether the line addition was successful or not
     */
    public boolean addLine(Integer newLine)
    {
        return lines.add(newLine);
    }

    /**
     * Returns the Entry's word
     *
     * @return  the Entry's word
     */
    public String getWord()
    {
        return word;
    }

    /**
     * Returns the word's TreeSet of lines
     *
     * @return  the word's TreeSet of lines
     */
    public TreeSet getLines()
    {
        return lines;
    }
}
