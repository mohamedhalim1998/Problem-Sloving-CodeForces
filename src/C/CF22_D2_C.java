package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF22_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x = scanner.nextInt();
        HashSet<Pair> pairs = new HashSet<>();
        int y = -1;
        if (m < n - 1) {
            System.out.println(-1);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (i != x) {
                y = i;
                break;
            }
        }
   
        for (int i = 1; i <= n; i++) {
            if (i != x) {
                pairs.add(new Pair(x, i));
            }
        }
        if (pairs.size() == m) {
            for (Pair p : pairs) {
                System.out.println(p);
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (i != x && i != y && i - 1 != y) {
                pairs.add(new Pair(i - 1, i));
                if (pairs.size() == m) {
                    for (Pair p : pairs) {
                        System.out.println(p);
                    }
                    return;
                }
            }
        }


        for (int i = 1; i <= n; i++) {
            if (i != x && i != y) {
                for (int j = i + 1; j <= n; j++) {
                    pairs.add(new Pair(i, j));
                    if (pairs.size() == m) {
                        for (Pair p : pairs) {
                            System.out.println(p);
                        }
                        return;
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (i != x) {
                pairs.add(new Pair(x, i));
                if (pairs.size() == m) {
                    for (Pair p : pairs) {
                        System.out.println(p);
                    }
                    return;
                }
            }
        }
        System.out.println(-1);

    }

    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
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
    }
}
