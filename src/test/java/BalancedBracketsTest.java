import static org.junit.Assert.*;

import org.junit.Test;

public class BalancedBracketsTest {
    BalancedBrackets bb = new BalancedBrackets();

    @Test
    public void testBalancedBrackets_balancedParens() {
        String balancedParens = "(1)";
        assertTrue(bb.balancedBrackets(balancedParens));
    }

    @Test
    public void testBalancedBrackets_tooManyOpenParens() {
        String tooManyOpenParens = "((1";
        assertFalse(bb.balancedBrackets(tooManyOpenParens));
    }

    @Test
    public void testBalancedBrackets_tooManyOpenParens1() {
        String tooManyOpenParens1 = "(1)(";
        assertFalse(bb.balancedBrackets(tooManyOpenParens1));
    }

    @Test
    public void testBalancedBrackets_tooManyClosedParens() {
        String tooManyClosedParens = "(1))";
        assertFalse(bb.balancedBrackets(tooManyClosedParens));
    }

    @Test
    public void testBalancedBrackets_startWithClosedParens() {
        String startClosedParens = ")(";
        assertFalse(bb.balancedBrackets(startClosedParens));
    }

    @Test
    public void testBalancedBrackets_emptyString() {
        String emptyString = "";
        assertTrue(bb.balancedBrackets(emptyString));
    }

    @Test
    public void testBalancedBrackets_balancedComboBrackets() {
        String balancedComboBrackets = "<({})>";
        assertTrue(bb.balancedBrackets(balancedComboBrackets));
    }

    @Test
    public void testBalancedBrackets_mismatchedBrackets() {
        String mismatchedBrackets = "<({)}>";
        assertFalse(bb.balancedBrackets(mismatchedBrackets));
    }

    @Test
    public void testBalancedBrackets_balancedAngleBrackets() {
        String balancedAngleBrackets = "<<>>";
        assertTrue(bb.balancedBrackets(balancedAngleBrackets));
    }

}