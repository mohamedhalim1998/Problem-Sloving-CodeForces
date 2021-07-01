package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1284_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = new int[1000009];
        int[] mins = new int[n];
        int ascent = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int l = scanner.nextInt();
            boolean a = false;
            for (int j = 0; j < l; j++) {
                int x = scanner.nextInt();
                if (!a && x > min) {
                    ascent++;
                    a = true;
                    sum += n;
                }
                min = Math.min(min, x);
                max = Math.max(x, max);
            }
            if (!a) {
                mins[i] = min;
                arr[max]++;
            } else {
                mins[i] = -1;
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i] += arr[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if (mins[i] != -1)
                sum += ascent + arr[mins[i] + 1];
        }
        System.out.println(sum);
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