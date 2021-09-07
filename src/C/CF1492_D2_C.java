package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1492_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s = scanner.next();
        String t = scanner.next();
        int[] mins = new int[m];
        int[] maxs = new int[m];
        for (int i = 0, j = 0; j < m; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(j);
            if (c1 == c2) {
                mins[j] = i;
                j++;
            }
        }
        for (int i = n - 1, j = m - 1; j >= 0; i--) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(j);
            if (c1 == c2) {
                maxs[j] = i;
                j--;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < m - 1; i++) {
            int diff = maxs[i + 1] - mins[i];
            max = Math.max(max, diff);
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