package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1037_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        char[] a = scanner.next().toCharArray();
        char[] b = scanner.next().toCharArray();

        int cost = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] != b[i] && a[i] == b[i + 1] && a[i + 1] != b[i + 1]) {
                cost++;
                char temp = b[i];
                b[i] = b[i + 1];
                b[i + 1] = temp;
                continue;
            }
            if (a[i] != b[i]) {
                cost++;
                b[i] = a[i];
            }
        }
        if (a[n - 1] != b[n - 1]) {
            cost++;
            b[n - 1] = a[n - 1];
        }
        System.out.println(cost);


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