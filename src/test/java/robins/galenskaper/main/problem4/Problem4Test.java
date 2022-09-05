package robins.galenskaper.main.problem4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class Problem4Test {

    @Test
    void testResult(){
        assertEquals(36, Problem4.calculator("2+30+4"));
        assertEquals(18, Problem4.calculator("2 - 3 + 4 + 15"));
        assertEquals(24, Problem4.calculator("2 * 3 * 4"));
        assertEquals(30, Problem4.calculator("2 * 3 / 4 * 20"));


        assertNotEquals(10, Problem4.calculator("123+421-412"));
    }

}
