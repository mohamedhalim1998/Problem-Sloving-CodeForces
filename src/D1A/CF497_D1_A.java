package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF497_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] mat = new char[n][m];
        for (int i = 0; i < n; i++) {
            mat[i] = scanner.next().toCharArray();
        }
        boolean change = true;
        int count = 0;
        while (change) {
            change = false;
            L1:
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m; j++) {
                    if (mat[i][j] > mat[i + 1][j]) {
                        change = true;
                        count++;
                        for (int l = 0; l < n; l++) {
                            mat[l][j] = ' ';
                        }
                        break L1;
                    } else if (mat[i][j] < mat[i + 1][j]) {
                        break;
                    }
                }
            }
        }
        System.out.println(count);


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
