package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1245_D2_C {
    static long[] mem;
    static long mod = 1000000000 + 7;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        if (s.indexOf('m') != -1 || s.indexOf('w') != -1) {
            System.out.println(0);
            return;
        }
        mem = new long[s.length()];
        System.out.println(solve(s, 0));
    }

    private static long solve(String s, int i) {
        if (i >= s.length() - 1) {
            return 1;
        }
        if (mem[i] != 0) {
            return mem[i];
        }
        long count = mem[i];
        if (s.charAt(i) == 'n' && s.charAt(i + 1) == 'n') {
            count += (solve(s, i + 1) % mod) + (solve(s, i + 2) % mod);
        } else if (s.charAt(i) == 'u' && s.charAt(i + 1) == 'u') {
            count += (solve(s, i + 1) % mod) + (solve(s, i + 2) % mod);
        } else {
            count += (solve(s, i + 1) % mod);
        }
        mem[i] = count;
        return count % mod;
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