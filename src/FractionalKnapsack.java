import java.text.DecimalFormat;
import java.util.*;

public class FractionalKnapsack {
    private static DecimalFormat df2 = new DecimalFormat(".####");

    public static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        int currentCapacity = 0;
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            items.add(new Item(weights[i], values[i]));
        }

        Collections.sort(items);
        for(Iterator<Item> itemIterator = items.iterator();itemIterator.hasNext() && capacity > 0;) {
            Item item = itemIterator.next();
            if (item.left > 0) {
                while(item.left > 0 && capacity > 0) {
                    value += item.takeOne();
                    capacity--;
                }

            } else {
                itemIterator.remove();
            }
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.format(df2.format(getOptimalValue(capacity, values, weights)));
    }

    static class Item implements Comparable<Item> {
        private final int weight;
        private final int values;
        private double cost;
        private int left;

        public Item(int weight, int values) {
            this.weight = weight;
            this.cost = values/(double) weight;
            this.values = values;
            this.left = weight;
        }

        @Override
        public int compareTo(Item o) {
            return Double.compare(o.cost, this.cost);
        }

        public double takeOne() {
            --left;
            return cost;

        }
    }
} 
