import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GcdTest {
    @Test
    public void gcdExm() {
        assertEquals(7, Gcd.calc(18, 35));
    }


    @Test
    public void gcdExm1() {
        assertEquals(1, Gcd.calc(18, 35));
    }

    @Test
    public void gcdSameInput() {
        assertEquals(18, Gcd.calc(18, 18));
    }


}
