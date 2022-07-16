package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1220_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        char[] arr = scanner.next().toCharArray();
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (alpha[c - 'a'] == -1) {
                alpha[c - 'a'] = i;
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            int min = Integer.MAX_VALUE;

            for (int j = c - 'a' - 1; j >= 0; j--) {
                if (alpha[j] > -1 && alpha[j] < min) {
                    min = alpha[j];
                }
            }
            if (min < i) {
                out.append("Ann\n");
            } else {
                out.append("Mike\n");
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