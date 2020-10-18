package A;

import java.util.Arrays;
import java.util.Scanner;

public class CF507_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(i + 1, scanner.nextInt());
        }
        Arrays.sort(pairs);
        int count = 0;
        StringBuilder out = new StringBuilder();
        for (int i = 0;i < n &&  k - pairs[i].v >= 0; i++) {
            count++;
            out.append(pairs[i].i).append(" ");
            k -= pairs[i].v;
        }
        System.out.println(count);
        System.out.println(out);
    }

    static class Pair implements Comparable<Pair> {
        int i, v;

        public Pair(int i, int v) {
            this.i = i;
            this.v = v;
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(v, pair.v);
        }
    }
}
