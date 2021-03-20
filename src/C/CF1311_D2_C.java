package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1311_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.print(out);
    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s = scanner.next();
        int[] p = scanner.nextArray(m);
        int[] ans = new int[26];
        int[] sums = new int[n + 9];
        for (int i = 0; i < p.length; i++) {
            sums[0]++;
            sums[p[i]]--;
        }
        sums[0]++;
        sums[n]--;
        for (int i = 0; i < sums.length - 1; i++) {
            sums[i + 1] += sums[i];
        }
        for (int i = 0; i < s.length(); i++) {
            ans[s.charAt(i) - 'a'] += sums[i];
        }
        for (int i = 0; i < 26; i++) {
            out.append(ans[i]).append(' ');
        }
        out.append('\n');
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