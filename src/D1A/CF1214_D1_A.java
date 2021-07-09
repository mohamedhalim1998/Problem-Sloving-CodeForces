package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF1214_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int[] d = {1, 2, 5, 10, 20, 50, 100};
        int[] e = {5, 10, 20, 50, 100, 200};
        int n = scanner.nextInt();
        int dollar = scanner.nextInt();
        int euro = scanner.nextInt();
        for (int i = 0; i < d.length; i++) {
            d[i] *= dollar;
        }
        for (int i = 0; i < e.length; i++) {
            e[i] *= euro;
        }
        int min = n;
        for (int i = 0; i <= n; i += e[0]) {
            min = Math.min(min, (n - i) % d[0]);
        }



        System.out.println(min);
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