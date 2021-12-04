package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF864_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int f = scanner.nextInt();
        int k = scanner.nextInt();
        int full = b;
        boolean start = true;
        int count = 0;
        if (f > b) {
            System.out.println(-1);
            return;
        }
        int c = 0;
        int prev = k;
        while (k > 0) {
            int min = b / a;
            c += min;
            start = c % 2 == 0;
            b -= a * min;
            prev = k;
            k -= min;
            if (k <= 0) {
                break;
            }
            if (start) {
                b -= f;
                count++;
                if (b < 0) {
                    b = full - f;
                } else {
                    b = full - (a - f);
                    c++;
                    k--;
                }
            } else {
                b -= (a - f);
                count++;
                if (b < 0) {
                    b = full - (a - f);
                } else {
                    b = full - f;
                    c++;
                    k--;
                }
            }

            if (prev == k || b < 0) {
                System.out.println(-1);
                return;
            }
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