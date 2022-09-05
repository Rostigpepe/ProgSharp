package robins.galenskaper.main.problem5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class Problem5Test {


    @Test
    void testResult(){
        assertEquals(-10, Problem5.calculator("2 - 3 * 4"));
        assertEquals(10, Problem5.calculator("2 * 3 + 4"));
        assertEquals(122, Problem5.calculator("2+3*40"));
        assertEquals(-10, Problem5.calculator("4*10/-4+0"));

        assertEquals(-991, Problem5.calculator("-123*5-451+-1500/-10/40*20"));
        assertNotEquals(10, Problem5.calculator("123+421-412"));
    }

}
