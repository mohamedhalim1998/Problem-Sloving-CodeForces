package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF1370_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.println(out);
    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        int n = scanner.nextInt();
        if (n == 1) {
            out.append("FastestFinger\n");
            return;
        }
        if (n == 2) {
            out.append("Ashishgup\n");
            return;
        }
        if (n % 2 == 1) {
            out.append("Ashishgup\n");
        } else {

            if (isPowerOfTwo(n)) {
                out.append("FastestFinger\n");
            } else if (n / 2 >= 3 && isPrime(n / 2)) {
                out.append("FastestFinger\n");

            } else {
                out.append("Ashishgup\n");
            }
        }
    }

    static boolean isPrime(int m) {
        for (int i = 2; i * i <=  m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPowerOfTwo(long n) {
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
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