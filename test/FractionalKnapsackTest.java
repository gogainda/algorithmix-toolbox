import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionalKnapsackTest {


    @Test
    void name() {
        int[] weights = new int[]{20, 50, 30};
        int[] values = new int[]{60, 100, 120};
        int capacity = 50;
        assertEquals(180.0000, FractionalKnapsack.getOptimalValue(capacity, values, weights));
    }


        @Test
        void name2() {
            int[] weights = new int[]{30};
            int[] values = new int[]{500};
            int capacity = 10;
            assertEquals(166.6667, FractionalKnapsack.getOptimalValue(capacity, values, weights), 0.0001);
        }
}