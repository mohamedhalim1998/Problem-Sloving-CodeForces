package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1400_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        String s = scanner.next();
        int x = scanner.nextInt();

        int n = s.length();
        char[] arr = new char[n];
        Arrays.fill(arr, '1');
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (i + x < n) {
                    arr[i + x] = '0';
                }
                if (i - x >= 0) {
                    arr[i - x] = '0';
                }
            }
        }
        char[] res = new char[n];
        Arrays.fill(res, '0');
        for (int i = 0; i < n; i++) {
            if (i - x >= 0 && arr[i - x] == '1') {
                res[i] = '1';
            } else if (i + x < n && arr[i + x] == '1') {
                res[i] = '1';
            }
        }
        if (String.valueOf(res).equals(s)) {
            System.out.println(String.valueOf(arr));
        } else {
            System.out.println(-1);
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
    }
}