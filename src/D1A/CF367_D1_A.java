package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF367_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        int[] x = new int[s.length() + 1];
        int[] y = new int[s.length() + 1];
        int[] z = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            x[i + 1] = x[i];
            y[i + 1] = y[i];
            z[i + 1] = z[i];

            switch (s.charAt(i)) {
                case 'x':
                    x[i + 1] += 1;
                    break;
                case 'y':
                    y[i + 1] += 1;
                    break;
                case 'z':
                    z[i + 1] += 1;
                    break;
            }
        }
        int n = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (r - l + 1 < 3) {
                out.append("YES\n");
            } else {
                l--;
                int max = max(x[r] - x[l], y[r] - y[l], z[r] - z[l]);
                int min = min(x[r] - x[l], y[r] - y[l], z[r] - z[l]);
                if (max - min > 1) {
                    out.append("NO\n");
                } else {
                    out.append("YES\n");
                }
            }
        }
        System.out.print(out);
    }

    public static int max(int x, int y, int z) {
        return Math.max(Math.max(x, y), z);
    }

    public static int min(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
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