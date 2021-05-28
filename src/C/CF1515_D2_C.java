package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1515_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.print(out);
    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
//        Arrays.sort(arr);
        int[] res = new int[n];
        PriorityQueue<Tower> towers = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            towers.add(new Tower(i + 1, 0));
        }

        for (int i = 0; i < n; i++) {
            Tower tower = towers.poll();
            tower.h += arr[i];
            towers.add(tower);
            res[i] = tower.i;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Tower tower : towers) {
            min = Math.min(min, tower.h);
            max = Math.max(max, tower.h);
        }
        if (max - min <= x) {
            out.append("YES\n");
            for (int i = 0; i < n; i++) {
                out.append(res[i]).append(" ");
            }
            out.append('\n');
        } else {
            out.append("NO\n");
        }

    }

    private static class Tower implements Comparable<Tower> {
        int i;
        int h;

        public Tower(int i, int h) {
            this.i = i;
            this.h = h;
        }

        @Override
        public int compareTo(Tower tower) {
            return Integer.compare(h, tower.h);
        }

        @Override
        public String toString() {
            return "Tower(" + i +
                    ", " + h +
                    ')';
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        int[] nextArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}