package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF724_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            mat[i] = scanner.nextArray(m);
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int[][] copy = new int[n][m];
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        copy[k][l] = mat[k][l];
                    }
                }
                for (int k = 0; k < n; k++) {
                    int temp = copy[k][i];
                    copy[k][i] = copy[k][j];
                    copy[k][j] = temp;
                }
                boolean found = true;
                for (int k = 0; k < n; k++) {
                    int count = 0;
                    for (int l = 0; l < m; l++) {
                        if (copy[k][l] != l + 1) {
                            count++;
                        }
                    }
                    if (count > 2) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        boolean found = true;
        for (int k = 0; k < n; k++) {
            int count = 0;
            for (int l = 0; l < m; l++) {
                if (mat[k][l] != l + 1) {
                    count++;
                }
            }
            if (count > 2) {
                found = false;
                break;
            }
        }
        if (found) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");


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