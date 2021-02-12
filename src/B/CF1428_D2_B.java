package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1428_D2_B {
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
        String s = scanner.next();
        char[] dir = s.toCharArray();
        int count = 0;
        if (s.contains(">") && s.contains("<")) {
            for (int i = 0; i < n; i++) {
                char dl = dir[(i + n - 1) % n];
                char dr = dir[i];
                if (dr == '-' || dl == '-') {
                    count++;
                }
            }
        } else if (s.contains(">")) {
            for (int i = 0; i < n; i++) {
                char dl = dir[(i + n - 1) % n];
                char dr = dir[i];
                if (dr == '-' || dl == '-') {
                    count++;
                } else if (dr == '>' && dl == '>') {
                    count++;
                }
            }
        } else if (s.contains("<")) {
            for (int i = 0; i < n; i++) {
                char dl = dir[(i + n - 1) % n];
                char dr = dir[i];
                if (dr == '-' || dl == '-') {
                    count++;
                } else if (dr == '<' && dl == '<') {
                    count++;
                }
            }

        } else {
            for (int i = 0; i < n; i++) {
                char dl = dir[(i + n - 1) % n];
                char dr = dir[i];
                if (dr == '-' || dl == '-') {
                    count++;
                }
            }
        }
        out.append(count).append('\n');
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