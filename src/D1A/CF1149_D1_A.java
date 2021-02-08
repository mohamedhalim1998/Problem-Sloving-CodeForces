package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1149_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = new int[3];
        for (int i = 0; i < n; i++) {
            arr[scanner.nextInt()]++;
        }
        if (n == 1) {
            if (arr[1] == 1) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
            return;
        }
        StringBuilder out = new StringBuilder();
        if (arr[1] == 0) {
            for (int i = 0; i < arr[2]; i++) {
                out.append(2).append(' ');
            }
        } else if (arr[2] == 0) {
            for (int i = 0; i < arr[1]; i++) {
                out.append(1).append(' ');
            }
        } else if (arr[1] >= 3) {
            out.append("1 1 1 ");
            for (int i = 0; i < arr[2]; i++) {
                out.append(2).append(' ');
            }
            for (int i = 0; i < arr[1] - 3; i++) {
                out.append(1).append(' ');
            }
        } else if (arr[1] == 1) {
            out.append("2 1 ");
            for (int i = 0; i < arr[2] - 1; i++) {
                out.append(2).append(' ');
            }
        } else if (arr[1] == 2) {
            out.append("2 1 ");
            for (int i = 0; i < arr[2] - 1; i++) {
                out.append(2).append(' ');
            }
            out.append(1).append(' ');
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