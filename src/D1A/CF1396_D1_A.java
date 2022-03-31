package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1396_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        long[] arr = scanner.nextLongArray(n);
        if(n == 1) {
            System.out.println("1 1\n 0\n1 1\n 0\n1 1\n");
            System.out.println(-arr[0]);
            return;
        }
        StringBuilder out = new StringBuilder();
        out.append("1 1\n");
        out.append(-arr[0]).append("\n");
        out.append(1).append(" ").append(n).append("\n");
        out.append(0).append(" ");

        for (int i = 1; i < n; i++) {
            out.append(- arr[i] * n).append(" ");
        }
        out.append("\n");
        out.append(2).append(" ").append(n).append("\n");
        for (int i = 1; i < n; i++) {
            out.append(arr[i] * (n - 1)).append(" ");
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
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
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

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}
