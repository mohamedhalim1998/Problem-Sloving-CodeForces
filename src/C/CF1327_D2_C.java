package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF1327_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        Pair[] arr = new Pair[k];
        Pair[] tar = new Pair[k];
        for (int i = 0; i < k; i++) {
            arr[i] = new Pair(i, scanner.nextInt(), scanner.nextInt());
            tar[i] = new Pair(scanner.nextInt(), scanner.nextInt());
        }
        int actions = 2 * n * m;
//        Pair[] diff = new Pair[k];
//        for (int i = 0; i < k; i++) {
//            diff[i] = tar[i].diff(arr[i]);
//        }
        int count = 0;
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < m - 1; i++) {
            count++;
            out.append("L");
        }
        for (int i = 0; i < n - 1; i++) {
            count++;
            out.append("U");
        }

        for (int i = 1; i <= n; i++) {
            if(i != 1){
                count++;
                out.append("D");
            }
            if (i% 2 == 1) {
                for (int j = 1; j < m; j++) {
                    count++;
                    out.append("R");
                }

            } else {
                for (int j = 1; j < m; j++) {
                    count++;
                    out.append("L");
                }
            }

        }
        System.out.println(count);
        System.out.println(out);

    }

    static class Pair {
        int x, y;
        boolean done;
        int index;

        public Pair(int index, int x, int y) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair diff(Pair other) {
            return new Pair(x - other.x, y - other.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
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