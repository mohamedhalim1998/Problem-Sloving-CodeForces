package D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1519_D2_D {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        long[] a = scanner.nextArrayLong(n);
        long[] b = scanner.nextArrayLong(n);
        long max = 0;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            max += a[i] * b[i];
            sums[i + 1] = max;
        }
        for (int i = 0; i < n; i++) {
            long sum = a[i] * b[i];
            for (int l = i - 1, r = i + 1; l >= 0 && r < n; --l, ++r) {
                sum += a[l] * b[r];
                sum += a[r] * b[l];
                max = Math.max(max, sum + sums[l] + (sums[n] - sums[r + 1]));
            }
            sum = 0;
            for (int l = i, r = i + 1; l >= 0 && r < n; --l, ++r) {
                sum += a[l] * b[r];
                sum += a[r] * b[l];
                max = Math.max(max, sum + sums[l] + (sums[n] - sums[r + 1]));
            }
//            for (int j = i + 1; j < n - 1; j++) {
//                long sum = 0;
//                int k = i;
//                sum += sums[i];
//                // al−1∗br+1+ar+1∗bl−1
//                sum += 1L * a[i - 1] * b[j + 1] + 1L * b[i - 1] * a[j + 1];
////                for (int l = j; l >= i; l--, k++) {
////                    sum += 1L * a[l] * b[k];
////                }
//                sum += sums[n] - sums[j + 2];
//                max = Math.max(sum, max);
//            }
        }
        System.out.println(max);
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