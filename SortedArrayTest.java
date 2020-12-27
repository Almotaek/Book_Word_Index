import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SortedArrayTest.
 *
 * @author Tafita Rakotozandry & Taylor Strong & Khalid Al-Motaery
 * @version 11/28/2020
 */
public class SortedArrayTest
{
    ArrayIndex a;
    
    /**
     * Default constructor for test class ListIndexTest
     */
    public SortedArrayTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        a = new ArrayIndex();
    }
    
     /**
     * Testing class for add
     */    
    @Test
    public void addArrayTest1() {
        a.readDictionary();
        assertEquals(true, a.add("Love", 100));
    }
    
     /**
     * Testing class for add
     */   
    @Test
    public void addArrayTest2() {
        a.readDictionary();
        assertEquals(false, a.add("fifa", 100));
    }
    
     /**
     * Testing class for add
     */     
    @Test
    public void addArrayTest3() {
        a.readDictionary();
        a.add("love", 100);
        assertEquals(true, a.add("love", 101));
    }
    
     /**
     * Testing class for add
     */    
    @Test
    public void addArrayTest4() {
        a.readDictionary();
        a.add("love", 100);
        assertEquals(false, a.add("love", 100));
    }
    
     /**
     * Testing class for add
     */     
    @Test
    public void isEnglishArrayTest1() {
        a.readDictionary();
        assertEquals(true, a.isEnglish("apple"));
    }
    
     /**
     * Testing class for add
     */    
    @Test
    public void isEnglishArrayTest2() {
        a.readDictionary();
        assertEquals(false, a.isEnglish("assdffghj"));
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {}
}
