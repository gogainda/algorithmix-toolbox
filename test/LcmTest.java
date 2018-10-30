import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LcmTest {
    @Test
    public void lcmTestcase1() {
        assertEquals(24, Lcm.calc(6, 8));
    }

    @Test
    public void lcmTestcase2() {
        assertEquals(1933053046, Lcm.calc(28851538, 1183019));
    }

    @Test
    public void lcmTestcase3() {
        assertEquals(630, Lcm.calc(18, 35));
    }
    @Test
    public void lcmTestcase8() {
        assertEquals(72, Lcm.calc(18, 24));
    }

    @Test
    public void lcmTestcase4() {
        assertEquals(226436590403296L, Lcm.calc(14159572, 63967072));
    }

    @Test
    public void lcmTestcase5() {
        assertEquals(1999999998000000000L, Lcm.calc(2000000000, 1999999998));
        //                    1000000000000000000                500000000       999999999
    }

    @Test
    public void lcmTestcase7() {
        assertEquals(3999999998000000000l, Lcm.calc(2000000000, 1999999999));
        //                    1000000000000000000                500000000       999999999
    }
    @Test
    public void lcmTestcase6() {
        assertEquals(2000000000, Lcm.calc(1, 2000000000));


    }



}
