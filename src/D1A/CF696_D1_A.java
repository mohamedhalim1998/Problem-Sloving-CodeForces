package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF696_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int q = scanner.nextInt();
        HashMap<Pair, Long> map = new HashMap<>();
        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            long u = scanner.nextLong();
            long v = scanner.nextLong();
            ArrayList<Pair> path = findPath(u, v);
            if (a == 1) {
                long w = scanner.nextLong();
                for (Pair p : path) {
                    map.put(p, map.getOrDefault(p, 0L) + w);
                }
            } else {
                long count = 0L;
                for (Pair p : path) {
                    count += map.getOrDefault(p, 0L);
                }
                System.out.println(count);
            }

        }


    }

    private static ArrayList<Pair> findPath(long u, long v) {
        ArrayList<Pair> path = new ArrayList<>();
        while (u != v) {
            if (log2(v) < log2(u)) {
                long temp = u;
                u = v;
                v = temp;
            }
            path.add(new Pair(v, v / 2));
            v = v / 2;
        }
        return path;
    }

    public static int log2(long n) {

        return (int) (Math.log(n) / Math.log(2));
    }

    static class Item implements Comparable<Item> {
        long x, diff;

        public Item(long x, long diff) {
            this.x = x;
            this.diff = diff;
        }

        @Override
        public int compareTo(Item item) {
            return Long.compare(diff, item.diff);
        }
    }

    static class Pair implements Comparable<Pair> {
        int index;
        long x, y;

        public Pair(long x, long y) {
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
                return -Long.compare(pair.x, x);
            } else {
                return Long.compare(pair.y, y);
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