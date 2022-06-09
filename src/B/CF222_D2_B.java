package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF222_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            mat[i] = scanner.nextArray(m);
        }
        HashMap<Integer, Integer> rows = new HashMap<>();
        HashMap<Integer, Integer> cols = new HashMap<>();
        for (int i = 0; i < n; i++) {
            rows.put(i, i);
        }
        for (int i = 0; i < m; i++) {
            cols.put(i, i);
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < k; i++) {
            char c = scanner.next().charAt(0);
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;


            switch (c) {
                case 'c':
                    int temp = cols.get(a);
                    cols.put(a, cols.get(b));
                    cols.put(b, temp);
                    break;
                case 'r':
                    temp = rows.get(a);
                    rows.put(a, rows.get(b));
                    rows.put(b, temp);
                    break;
                case 'g':
                    out.append(mat[rows.get(a)][cols.get(b)]).append('\n');
                    break;
            }
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
    }
}
