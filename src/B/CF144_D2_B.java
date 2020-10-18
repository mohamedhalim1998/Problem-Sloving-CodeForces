package B;

import java.util.*;

public class CF144_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int n = scanner.nextInt();
        Radiator[] radiators = new Radiator[n];
        for (int i = 0; i < n; i++) {
            radiators[i] = new Radiator(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        HashSet<Pair> generals = new HashSet<>();
        for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
            generals.add(new Pair(i, y1));
            generals.add(new Pair(i, y2));

        }
        for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
            generals.add(new Pair(x1, i));
            generals.add(new Pair(x2, i));

        }

        int count = 0;
        for (Pair p : generals) {
            for (int i = 0; i < n; i++) {
                double d = calculateDistance(p, new Pair(radiators[i].x, radiators[i].y));
                if (d <= radiators[i].r) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(generals.size() - count);

    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public int compareTo(Pair o) {
            return (this.x - o.x) + (this.y - o.y);
        }

        @Override
        public String toString() {
            return "Pair(" + "x=" + x + ", y=" + y + ')';
        }
    }

    static class Radiator {
        int x;
        int y;
        int r;

        public Radiator(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    private static double calculateDistance(Pair p1, Pair p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
}
