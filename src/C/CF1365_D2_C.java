package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1365_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] a = scanner.nextArray(n);
        int[] b = scanner.nextArray(n);
        int[] indexA = new int[n + 1];
        int[] indexB = new int[n + 1];
        for (int i = 0; i < n; i++) {
            indexA[a[i]] = i;
            indexB[b[i]] = i;
        }
        int max = Integer.MIN_VALUE;
        int[] diff = new int[n + 9];
        for (int i = 1; i <= n; i++) {
            int d = indexA[i] - indexB[i];
            if (d < 0) {
                d += n;
            }
            diff[d]++;
        }
        for (int value : diff) {
            max = Math.max(max, value);
        }
        System.out.println(max);
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