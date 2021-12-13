package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF501_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(i, scanner.nextInt(), scanner.nextInt());
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Pair p : pairs) {
            if (p.x == 1) {
                queue.add(p.index);
            }
        }
        ArrayList<Pair> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (pairs[x].x == 0) {
                continue;
            }
            int y = pairs[x].y;
            list.add(new Pair(x, y));
            pairs[pairs[x].y].x--;
            pairs[pairs[x].y].y ^= x;
            if (pairs[pairs[x].y].x == 1) {
                queue.add(pairs[pairs[x].y].index);
            }
        }
        System.out.println(list.size());
        for (Pair p : list) {
            System.out.println(p);
        }
    }

    static class Pair implements Comparable<Pair> {
        int x, y;
        int index;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair(int index, int x, int y) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return (x == pair.x && y == pair.y)
                    || (x == pair.y && y == pair.x);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x + y);
        }

        @Override
        public int compareTo(Pair pair) {
            return Integer.compare(x, pair.x);
        }

        @Override
        public String toString() {
            return x + " " + y;
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