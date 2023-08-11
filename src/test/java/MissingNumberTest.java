import static org.junit.Assert.*;

import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;

public class MissingNumberTest {
    private final MissingNumber mn = new MissingNumber();

//    @BeforeEach
//    public void initTest() {
//        mn = new MissingNumber();
//    }

    @Test
    public void testMissingNumber_MissingMax() {
        int[] missingMax = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(10, mn.missingNumber3(missingMax, 10));
    }

    @Test
    public void testMissingNumber_NoneMissing() {
        int[] missingNone = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(0, mn.missingNumber3(missingNone, 10));
    }

    @Test
    public void testMissingNumber_MissingSeven() {
        int[] missingSeven = { 1, 2, 3, 4, 5, 6, 8, 9, 10 };
        assertEquals(7, mn.missingNumber3(missingSeven, 10));
    }

}

