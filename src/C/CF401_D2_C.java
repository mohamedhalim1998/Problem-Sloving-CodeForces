package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF401_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        int last = -1;
        while (n > 0 && m > 0) {
            if (m > n) {
                if (m / (n * 1.0) >= 2) {
                    out.append(110);
                    n--;
                    m -= 2;
                    last = 0;
                } else {
                    out.append(10);
                    n--;
                    m--;
                    last = 1;
                }
            } else {
                out.append(0).append(1);
                n--;
                m--;
                last = 2;
            }
        }
        if(m > 0 || n > 0) {
            if (m == 2 && last != 2) {
                out.append(11);
            } else if (m == 1) {
                out.append(1);
            } else if (n == 1 && last == 2) {
                out.append(0);
            } else {
                System.out.println(-1);
                return;
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
    }
}