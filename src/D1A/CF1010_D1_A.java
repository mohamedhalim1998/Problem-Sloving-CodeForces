package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1010_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        double m = scanner.nextInt();
        int[] a = scanner.nextArray(n);
        int[] b = scanner.nextArray(n);
        double l = 0;
        double r = 1e10;
        double mid = (l + r) / 2;

        while ((r - l) > 1e-6) {
            mid = (l + r) / 2;
            double s = m + mid;
            double f = mid;
            for (int i = 0; i < n - 1; i++) {
                double burn = s / a[i];
                f -= burn;
                s -= burn;
                if (f < 0) {
                    l = mid;
                    break;
                }
                burn = s / b[i + 1];
                f -= burn;
                s -= burn;
                if (f < 0) {
                    l = mid;
                    break;
                }
            }
            double burn = s / a[n - 1];
            f -= burn;
            s -= burn;
            if (f < 0) {
                l = mid;
            }
            burn = s / b[0];
            f -= burn;
            if (f < 0) {
                l = mid;
            } else {
                r = mid;
            }
        }
        if(mid > 1e9+ 1){
            System.out.println(-1);
            return;
        }
        System.out.printf("%.06f\n", mid);

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