package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF260_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int x = scanner.nextInt() - 1;
        long[] arr = scanner.nextArrayLong(n);
        int min = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        long diff = arr[min];
        long count = 0;
        for (int i = 0; i < n; i++) {
            count += diff;
            arr[i] -= diff;
        }
        if (x >= min) {
            for (int i = min + 1; i <= x; i++) {
                count++;
                arr[i]--;
            }
        } else {
            for (int i = min + 1; i < n; i++) {
                count++;
                arr[i]--;
            }
            for (int i = 0; i <= x; i++) {
                count++;
                arr[i]--;
            }
        }
        int old = min;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                min = i;
            }
        }
        for (int i = old + 1; i <= min; i++) {
            arr[i]++;
            count--;
        }
        arr[min] = count;
        printArrayInLine(arr);
    }

    public static void printArrayInLine(long[] arr) {
        StringBuilder builder = new StringBuilder();
        for (long value : arr) {
            builder.append(value).append(" ");
        }
        System.out.println(builder);
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