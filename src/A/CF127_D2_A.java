package A;

import java.util.Scanner;

public class CF127_D2_A {
    public static void main(String[] args) {
        // reading time 3 min
        // think time 2 min
        // implement time 6 min
        // debug time 1 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            pairs[i] = new Pair(x, y);
        }
        double distance = 0d;
        for (int i = 0; i < n - 1; i++) {
            distance += calculateDistance(pairs[i], pairs[i + 1]);
        }
      //  System.out.println(distance);
        distance /= 50;
        distance *= k;
        System.out.println(String.format("%.09f", distance));
    }

    private static double calculateDistance(Pair p1, Pair p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x,2) + Math.pow(p1.y - p2.y,2) );
    }


    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
