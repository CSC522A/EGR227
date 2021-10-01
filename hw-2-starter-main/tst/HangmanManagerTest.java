import org.junit.*;     // JUnit tools

import java.util.*;     // Collections
import java.io.*;       // File access

/**
 * Modify this comment
 */
public class HangmanManagerTest {

    /* Loads the words in fileName and returns the set of all words in that file*/
    private Set<String> getDictionary(String fileName) {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            Set<String> dictionary = new HashSet<>();
            while(fileScanner.hasNext()) {
                dictionary.add(fileScanner.next());
            }
            return dictionary;
        } catch(FileNotFoundException e) {
            Assert.fail("Something went wrong.");      //Something went wrong
        }
        /* Should never be reached. */
        return new HashSet<>();
    }

    /**
     * Add comments
     */
    @Test
    public void test1(){
        //Implement your test code
    }

    //Add more tests here
}
