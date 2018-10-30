import java.util.*;

public class CoveringSegments {

    public static int[] optimalPoints(Segment[] segments) {
        //write your code here
        List<Integer> points = new ArrayList<>();

        List<Segment> list = Arrays.asList(segments);
        Collections.sort(list);

        Segment leftMost = list.get(0);
        Iterator<Segment> segmentIterator = list.iterator();
        segmentIterator.next();

        int currentPoin = -1;
        while(segmentIterator.hasNext()) {
            Segment nextRight = segmentIterator.next();
            if (nextRight.equals(leftMost)) {
                continue;
            }
            if (leftMost.includes(nextRight)) {
                   points.add(nextRight.start);
                   
                   nextRight = segmentIterator.next();
                   continue;


            }
            if (leftMost.intersect(nextRight)) {

                currentPoin = getCurrentPoint(currentPoin, leftMost, nextRight);
            } else {
                points.add(currentPoin);
                currentPoin = nextRight.start;
                leftMost = nextRight;
            }


        }
        if (!segmentIterator.hasNext()) {
            points.add(currentPoin);
        }
        return points.stream().mapToInt(i->i).toArray();
    }

    private static int getCurrentPoint(int currentPoin, Segment leftMost, Segment nextRight) {
        int firstPoint = 0;
        if (nextRight.end > leftMost.end) {
            firstPoint = leftMost.end;
        } else {
            firstPoint = nextRight.end;
        }
        currentPoin = firstPoint > currentPoin ? firstPoint : currentPoin;
        return currentPoin;
    }

    private static class Segment implements Comparable<Segment>{
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean intersect(Segment nextRight) {
//            if (this.equals(nextRight)) {
//                return false;
//            }
            if (nextRight.start <= this.end) {
                return true;
            } else {
                return false;
            }
        }
        public int lenght() {
            return this.end - this.start;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Segment segment = (Segment) o;
            return start == segment.start &&
                    end == segment.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public int compareTo(Segment o) {
            if (this.start  - o.start == 0) {
                return this.lenght() - o.lenght();
            } else {
                return this.start - o.start;
            }
        }

        public boolean includes(Segment nextRight) {
            if ((nextRight.lenght() == 0) && this.end >nextRight.start) {
                return true;
            }   else  {
                return false;
            }

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 
