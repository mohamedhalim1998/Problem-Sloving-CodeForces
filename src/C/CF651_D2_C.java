package C;

import java.util.*;

public class CF651_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Point, Long> map = new HashMap<>();
        HashMap<Long, Long> mapX = new HashMap<>();
        HashMap<Long, Long> mapY = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long x = scanner.nextLong();
            long y = scanner.nextLong();
            Point p = new Point(x, y);
            map.put(p, map.getOrDefault(p, 0L) + 1);
            mapX.put(x, mapX.getOrDefault(x, 0L) + 1);
            mapY.put(y, mapY.getOrDefault(y, 0L) + 1);

        }
        long count = 0;
        for (Map.Entry<Long, Long> e : mapX.entrySet()) {
            count += (e.getValue() * (e.getValue() - 1) / 2);
        }
        for (Map.Entry<Long, Long> e : mapY.entrySet()) {
            count += e.getValue() * (e.getValue() - 1) / 2;
        }
        for (Map.Entry<Point, Long> e : map.entrySet()) {
            count -= e.getValue() * (e.getValue() - 1) / 2;
        }


        System.out.println(count);

    }
    static class Point {
        long x, y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
}
