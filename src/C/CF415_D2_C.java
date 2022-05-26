package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF415_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if (n == 1) {
            if (k == 0) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
            return;
        }
        if (n / 2 > k) {
            System.out.println(-1);
            return;
        } else if (n / 2 == k) {
            StringBuilder out = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                out.append(i).append(' ');

            }
            System.out.println(out);
            return;
        }
        StringBuilder out = new StringBuilder();
        int a = 2 * (k - n / 2 + 1);
        out.append(a / 2).append(' ');
        out.append(a).append(' ');
        int count = 2;
        for (int i = 1; i < a / 2 - 1 &&count +1< n; i += 2) {
            out.append(i).append(' ').append(i + 1).append(' ');
            count += 2;
        }
        for (int i = a / 2 + 1; i < a - 1&&count +1< n; i += 2) {
            out.append(i).append(' ').append(i + 1).append(' ');
            count += 2;
        }
        for (int i = a + 1; count < n; i++, count++) {
            out.append(i).append(' ');
        }
        System.out.println(out);
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