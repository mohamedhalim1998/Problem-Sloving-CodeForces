package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF354_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int ql = scanner.nextInt();
        int qr = scanner.nextInt();
        long[] arr = scanner.nextArrayLong(n);
        long sum = Long.MAX_VALUE;
        long[] left = new long[n];
        left[0] = arr[0] * l;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + arr[i] * l;
        }
        long[] right = new long[n];
        right[n - 1] = arr[n - 1] * r;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + arr[i] * r;
        }
        sum = right[0]+qr*(n-1);

        for (int i = 0; i < n; i++) {
            long extra = (i + 1) - (n - i - 1);
            long curr;
            if (i == n - 1) curr = left[i];
            else curr = left[i] + right[i + 1];
            if (extra != 0) {
                if (extra < 0) curr += (Math.abs(extra) - 1) * qr;
                else curr += (Math.abs(extra) - 1) * ql;
            }
            sum = Math.min(sum, curr);
        }
        System.out.println(sum);
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