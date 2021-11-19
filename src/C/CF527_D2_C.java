package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF527_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int n = scanner.nextInt();
        PriorityQueue<Integer> ver = new PriorityQueue<>();
        PriorityQueue<Integer> hor = new PriorityQueue<>();
        ver.add(-w);
        hor.add(-h);
        TreeSet<Integer> verSet = new TreeSet<>();
        TreeSet<Integer> horSet = new TreeSet<>();
        verSet.add(0);
        verSet.add(w);
        horSet.add(0);
        horSet.add(h);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String op = scanner.next();
            int a = scanner.nextInt();
            if (op.equals("H")) {
                int l = horSet.floor(a);
                int r = horSet.ceiling(a);
                hor.remove(-r + l);
                hor.add(-r + a);
                hor.add(-a + l);
                horSet.add(a);
            } else {
                int l = verSet.floor(a);
                int r = verSet.ceiling(a);
                ver.remove(-r + l);
                ver.add(-r + a);
                ver.add(-a + l);
                verSet.add(a);
            }
            out.append(((long) ver.peek()) * hor.peek()).append('\n');
        }
        System.out.println(out);
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

        public int len() {
            return Math.abs(x - y);
        }

        @Override
        public int compareTo(Pair pair) {
            return -Integer.compare(Math.abs(x - y), Math.abs(pair.x - pair.y));
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
        public String toString() {
            return "Pair{" +
                    "index=" + index +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
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