package robins.galenskaper.main.problem1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    @Test
    void testIfAnagram(){
        assertTrue(Problem1.isAnagram("TomMarvoloRiddle", "IAmLordVoldemort"));
        assertTrue(Problem1.isAnagram("Ooga", "aOgo"));
        assertTrue(Problem1.isAnagram("Robin", "nibOr"));
        assertFalse(Problem1.isAnagram("Mer", "MEEEER"));
    }

}
