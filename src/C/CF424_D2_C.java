package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF424_D2_C {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int[] p = nextArray(scanner, n);
        int[] q = new int[n];
        int[] f = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            f[i] = f[i - 1] ^ i;
        }
        for (int i = 0; i < n; i++) {
            if ((n / (i + 1)) % 2 == 1) {
                q[i] = p[i] ^ f[i] ^ f[n % (i + 1)];
            } else {
                q[i] = p[i] ^ f[n % (i + 1)];
            }
        }
        int ans = q[0];
        for (int i = 1; i < n; i++) {
            ans = ans ^ q[i];
        }
        System.out.println(ans);
    }

    public static int[] nextArray(FastReader scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
    }

}
