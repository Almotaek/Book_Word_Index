import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * The test class HashIndexTest.
 *
 * @author Tafita Rakotozandry & Taylor Strong & Khalid Al-Motaery
 * @version 11/28/2020
 */
public class HashIndexTest {
    HashIndex t;

    /**
     * Default constructor for test class ListIndexTest
     */
    public HashIndexTest() {
        t = new HashIndex();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        t = new HashIndex();
    }

    /**
     * Testing class for add
     */
    @Test
    public void addTreeTest1() {
        t.readDictionary();
        assertEquals(true, t.add("Love", 100));
    }

    /**
     * Testing class for add
     */   
    @Test
    public void addTreeTest2() {
        t.readDictionary();
        assertEquals(false, t.add("fifa", 100));
    }

    /**
     * Testing class for add
     */ 
    @Test
    public void addTreeTest3() {
        t.readDictionary();
        t.add("love", 100);
        assertEquals(true, t.add("love", 101));
    }

    /**
     * Testing class for add
     */   
    @Test
    public void addTreeTest4() {
        t.readDictionary();
        t.add("love", 100);
        assertEquals(false, t.add("love", 100));
    }

    /**
     * Testing class for add
     */     
    @Test
    public void isEnglishTreeTest1() {
        t.readDictionary();
        assertEquals(true, t.isEnglish("apple"));
    }

    /**
     * Testing class for add
     */     
    @Test
    public void isEnglishTreeTest2() {
        t.readDictionary();
        assertEquals(false, t.isEnglish("assdffghj"));
    }
}