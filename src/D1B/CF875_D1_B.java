package D1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF875_D1_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        boolean[] coins = new boolean[n];
        int last = n - 1;
        StringBuilder out = new StringBuilder();
        out.append("1 ");
        for (int i = 0; i < n; i++) {
            int index = arr[i] - 1;
            coins[index] = true;
            while (last >= 0 && coins[last]) {
                last--;
            }
            int count = i + 1;
            count -= n - last - 1;
            count++;
            out.append(count).append(' ');
        }
        System.out.println(out);
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