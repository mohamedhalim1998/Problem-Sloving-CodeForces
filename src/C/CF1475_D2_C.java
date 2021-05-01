package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1475_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int a = scanner.nextInt();
        int[] boys = new int[a + 1];
        int b = scanner.nextInt();
        int[] girls = new int[b + 1];
        int k = scanner.nextInt();
        int[] pboy = new int[k];
        int[] pgirl = new int[k];

        for (int i = 0; i < k; i++) {
            pboy[i] = scanner.nextInt();
            boys[pboy[i]]++;
        }
        for (int i = 0; i < k; i++) {
            pgirl[i] = scanner.nextInt();
            girls[pgirl[i]]++;
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int x = pboy[i];
            int y = pgirl[i];
            sum += (k - boys[x] - girls[y] + 1);
        }
        System.out.println(sum / 2);

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