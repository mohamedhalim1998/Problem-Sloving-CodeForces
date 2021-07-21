package C;

import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1088_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        StringBuilder out = new StringBuilder();
        out.append(n + 1).append('\n');
        int sum = 0;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            int mod = j - (arr[j] + sum) % n;
            if (mod < 0) {
                mod += n;
            }
            out.append(1).append(' ').append(j + 1).append(' ').append(mod).append('\n');
            sum += mod;
        }
        out.append(2).append(' ').append(n).append(' ').append(n).append('\n');

        System.out.print(out);


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