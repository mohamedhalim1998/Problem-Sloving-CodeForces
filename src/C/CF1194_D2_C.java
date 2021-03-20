package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1194_D2_C {
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
        String s = scanner.next();
        String t = scanner.next();
        String p = scanner.next();
        int[] freq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            freq[p.charAt(i) - 'a']++;
        }
        int i = 0, j = 0;
        for (; i < t.length() && j < s.length(); i++) {
            if (s.charAt(j) != t.charAt(i)) {
                int index = t.charAt(i) - 'a';
                if (--freq[index] < 0) {
                    out.append("NO\n");
                    return;
                }
            } else {
                j++;
            }
        }
        if (j == s.length()) {
            while (i < t.length()) {
                int index = t.charAt(i) - 'a';
                if (--freq[index] < 0) {
                    out.append("NO\n");
                    return;
                }
                i++;
            }
        } else {
            out.append("NO\n");
            return;
        }
        out.append("YES\n");

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