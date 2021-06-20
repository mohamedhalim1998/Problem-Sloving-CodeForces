package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF804_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        int mod = (int) (1e9 + 7);
        int[] b = new int[s.length() + 1];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'b') {
                b[i] = b[i + 1] + 1;
            } else {
                b[i] = b[i + 1];
            }
        }
        long sum = 0;
        long acc = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'a' && b[i] != 0) {
                sum += acc + b[i];
                acc = (long) 2*( b[i] + acc) - b[i];
                sum = sum % mod;
                acc = acc % mod;
            }
        }
        sum = sum % mod;

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
    }
}