import java.util.*;
import java.io.*;
/**
 * This is the testing class.
 *
 * @author Tafita Rakotozandry & Taylor Strong & Khalid Al-Motaery
 * @version 11/28/2020
 */
public class Controller
{   
    static String[] titles = {"The Yellow Wallpaper","Home-made Electrical Apparatus","The Adventures of Sherlock Holmes","Emma","Whale","Shakespeare"};
    
    public static void main(String[] args) {
        Controller c = new Controller();
        for (int i=0; i<titles.length; i++){
            c.timeHashIndex(titles[i]);
        }
        System.out.println("Hash Index Time");  
        for (int i=0; i<titles.length; i++){
            c.timeTreeIndex(titles[i]);
        }
        System.out.println("Tree Index Time");    
        for (int i=0; i<titles.length; i++){
            c.timeArrayIndex(titles[i]);
        }
        System.out.println("Array Index Time"); 
    }
    
    public void timeHashIndex(String title){
        HashIndex hash = new HashIndex();
        long start = System.currentTimeMillis();
        hash.readFile(title);
        hash.createOutFile();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(time);   
    }
    
    public void timeTreeIndex(String title){
        TreeIndex tree = new TreeIndex();
        long start = System.currentTimeMillis();
        tree.readFile(title);
        tree.createOutFile();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(time);   
    }
    
    public void timeArrayIndex(String title){
        ArrayIndex array = new ArrayIndex();
        long start = System.currentTimeMillis();
        array.readFile(title);
        array.createOutFile();
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println(time);   
    } 
}
