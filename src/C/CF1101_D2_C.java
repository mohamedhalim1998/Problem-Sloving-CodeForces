package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF1101_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(i, scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(pairs);
        int[] ans = new int[n];
        Pair c = new Pair(pairs[0].x, pairs[0].y);
        ans[pairs[0].index] = 1;
        boolean found = false;
        for (int i = 1; i < n; i++) {
            if (intersect(pairs[i], c)) {
                ans[pairs[i].index] = 1;
                c.x = Math.min(c.x, pairs[i].x);
                c.y = Math.max(c.y, pairs[i].y);
            } else {
                ans[pairs[i].index] = 2;
                found = true;
            }
        }
        if(!found){
            System.out.println(-1);
            return;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            out.append(ans[i]).append(' ');
        }
        System.out.println(out);


    }

    private static boolean intersect(Pair p1, Pair p2) {
        int[] arr = {p1.x, p1.y, p2.x, p2.y};
        return p1.x <= p2.y && p1.y >= p2.x;

//        Arrays.sort(arr);
//        boolean c1 = (arr[1] == p1.x && arr[2] == p2.y);
//        boolean c2 = (arr[1] == p2.x && arr[2] == p1.y);
//        return c1 || c2;
    }


    static class Pair implements Comparable<Pair> {
        int index;
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair pair) {
            if (pair.x != x) {
                return -Integer.compare(pair.x, x);
            } else {
                return -Integer.compare(pair.y, y);
            }
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

        Integer[] nextArray(int n, boolean object) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        long[] nextArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        Long[] nextArrayLong(int n, boolean object) {
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}