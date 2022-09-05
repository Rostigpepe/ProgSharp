package robins.galenskaper.main.problem3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class Problem3Test {

    @Test
    void testResult(){
        assertEquals(60, Problem3.calculator("30+30"));
        assertEquals(18, Problem3.calculator("9        +         9"));
        assertEquals(-14, Problem3.calculator("7 - 21"));
        assertEquals(81, Problem3.calculator("9 *9"));


        assertNotEquals(1110, Problem3.calculator("5 / 2"));
    }

}
