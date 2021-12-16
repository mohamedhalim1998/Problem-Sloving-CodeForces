package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1000_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int[] on = new int[n + 1];
        int[] off = new int[n + 1];

        boolean nextOn = false;
        on[1] = arr[0];
        int j = 2, k = 1;
        for (int i = 1; i < n; i++) {
            if (nextOn) {
                on[j] = on[j - 1] + arr[i] - arr[i - 1];
                j++;
            } else {
                off[k] = off[k - 1] + arr[i] - arr[i - 1];
                k++;
            }
            nextOn = !nextOn;
        }
        if (nextOn) {
            on[j] = on[j - 1] + m - arr[n - 1];
            j++;
        } else {
            off[k] = off[k - 1] + m - arr[n - 1];
            k++;

        }
        for (int i = j; i <= n; i++) {
            on[i] = on[j - 1];
        }
        for (int i = k; i <= n; i++) {
            off[i] = off[k - 1];
        }
        int max = -1;
        for (int i = 1; i <= n; i++) {
            max = Math.max(on[i] + off[n] - off[i - 1] - 1, max);
        }
        System.out.println(Math.max(max, on[n]));


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