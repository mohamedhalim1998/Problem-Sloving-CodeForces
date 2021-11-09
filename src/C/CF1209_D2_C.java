package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1209_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        char[] arr = scanner.next().toCharArray();
        char[] sorted = Arrays.copyOf(arr, n);
        char[] ans = new char[n];
        Arrays.sort(sorted);

        for (int i = 0, j = 0; i < n; i++) {
            if (sorted[j] == arr[i]) {
                j++;
                ans[i] = '1';
            } else {
                ans[i] = '2';
            }
        }
        char[] copy = new char[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (ans[i] == '1') {
                copy[j++] = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == '2') {
                copy[j++] = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if(copy[i] != sorted[i]){
                System.out.println('-');
                return;
            }
        }
        System.out.println(String.valueOf(ans));

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