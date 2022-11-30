package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1623_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int l = 0;
        int r = (int) 1e9;
        int m = l + (r - l) / 2;
        int ans = -1;
        while (l <= r) {
            m = l + (r - l) / 2;
            if (test(arr, m)) {
                l = m + 1;
                ans = m;
            } else {
                r = m - 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean test(int[] arr, int m) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        for (int i = arr.length - 1; i > 1; i--) {
            if (copy[i] < m) {
                return false;
            }
            int min = Math.min(copy[i]-m, arr[i]);
//            int diff = min - m;
            int div = min / 3;
//            copy[i] -= 3 * div;
            copy[i - 1] += div;
            copy[i - 2] += div * 2;
        }
        return copy[0] >= m && copy[1] >= m;
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
