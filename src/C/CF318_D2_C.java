package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF318_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        long m = scanner.nextLong();
        if (x >= m || y >= m) {
            System.out.println(0);
            return;
        }
        if (x <= 0 && y <= 0) {
            System.out.println(-1);
            return;
        }
        long count = 0;
        if (x < 0) {
            long div = Math.abs(x) / y;
            count = div;
            x = x + div * y;
        }
        if (y < 0) {
            long div = Math.abs(y) / x;
            count = div;
            y = y + div * x;
        }
        while (x < m && y < m) {
            if (x < y) {
                x = x + y;
            } else {
                y = x + y;
            }
            count++;
        }
        System.out.println(count);


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