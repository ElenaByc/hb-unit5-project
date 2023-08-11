import org.junit.Test;

public class MissingNumberPerformanceTest {

    private final int[] missingMax = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final int[] missingNone = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private final int[] missingSeven = {1, 2, 3, 4, 5, 6, 8, 9, 10};
    private final int max = 10;
    private final MissingNumber mn = new MissingNumber();

    @Test(timeout = 100)
    public void testMissingNumber1_Performance() {
        for (int i = 0; i < 1000000; i++) {
            mn.missingNumber1(missingMax, max);
            mn.missingNumber1(missingNone, max);
            mn.missingNumber1(missingSeven, max);
        }
    }

    @Test(timeout = 100)
    public void testMissingNumber2_Performance() {
        for (int i = 0; i < 1000000; i++) {
            mn.missingNumber2(missingMax, max);
            mn.missingNumber2(missingNone, max);
            mn.missingNumber2(missingSeven, max);
        }
    }

    @Test(timeout = 100)
    public void testMissingNumber3_Performance() {
        for (int i = 0; i < 1000000; i++) {
            mn.missingNumber3(missingMax, max);
            mn.missingNumber3(missingNone, max);
            mn.missingNumber3(missingSeven, max);
        }
    }
}