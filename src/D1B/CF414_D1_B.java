package D1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF414_D1_B {
    static long[][] mem;
    static int mod = 1_000_000_007;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        mem = new long[2001][2001];
        for (int i = 1; i < n+ 1; i++) {
            mem[1][i] = 1;
        }
        int len = Math.max(n , k);
        for (int r = 1; r <= len; r++) {
            for (int i = 1; i <= len; i++) {
                for (int j = i; j <= len; j += i) {
                    mem[r][j] += mem[r - 1][i];
                    mem[r][j] = mem[r][j] % mod;
                }
            }
        }
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += mem[k][i];
            res = res % mod;
        }
        System.out.println(res);
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