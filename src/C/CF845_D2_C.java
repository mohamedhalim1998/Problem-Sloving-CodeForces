package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF845_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(pairs);
        Pair tv1 = pairs[0];
        Pair tv2 = null;
        for (int i = 1; i < n; i++) {
            if (intersect(pairs[i], tv1)) {
                if (tv2 == null) {
                    tv2 = pairs[i];
                } else {
                    if (intersect(tv2, pairs[i])) {
                        System.out.println("NO");
                        return;
                    } else {
                        tv2 = pairs[i];
                    }
                }
            } else {
                tv1 = new Pair(pairs[i]);
            }
        }
        System.out.println("YES");


    }

    private static boolean intersect(Pair p1, Pair p2) {
        int[] arr = {p1.x, p1.y, p2.x, p2.y};
        return p1.x <= p2.y && p1.y >= p2.x;
    }


    static class Pair implements Comparable<Pair> {
        int index;
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(Pair p) {
            this.x = p.x;
            this.y = p.y;
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