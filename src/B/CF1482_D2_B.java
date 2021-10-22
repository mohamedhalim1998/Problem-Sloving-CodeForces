package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1482_D2_B {
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
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int c = -1;
        boolean same = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] != arr[0]) {
                same = false;
                break;
            }
        }
        if (same) {
            System.out.println(0);
            return;
        }

        int m = -1;

        int mc = -1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] - arr[i] <= 0) {
                if (mc != -1 && -arr[i + 1] + arr[i] != mc) {
                    System.out.println(-1);
                    return;
                }
                mc = -arr[i + 1] + arr[i];
            } else if (arr[i + 1] - arr[i] > 0) {
                if (c != -1 && arr[i + 1] - arr[i] != c) {
                    System.out.println(-1);
                    return;
                }
                c = arr[i + 1] - arr[i];
            }
        }
        if (c == -1 || mc == -1) {
            System.out.println(0);
            return;
        }
        m = c + mc;
        int a = arr[0];
        if (a >= m) {
            System.out.println(-1);
            return;
        }
        for (int i = 1; i < n; i++) {
            int s = a + c;
            s = s % m;
            if (arr[i] != s) {
                System.out.println(-1);
                return;
            }
            a = s;
        }
        System.out.println(m + " " + c);

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