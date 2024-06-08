import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionMatchingTest {

    @Test
    public void test1() {
        assertFalse(new RegularExpressionMatching().isMatch("aa","a"));
    }

    @Test
    public void test2() {
        assertTrue(new RegularExpressionMatching().isMatch("aa","a*"));
    }

    @Test
    public void test3() {
        assertTrue(new RegularExpressionMatching().isMatch("ab",".*"));
    }

}