package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1452_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        Integer[] arr = scanner.nextArray(n, true);
        if(n == 2){
            System.out.println(0);
            return;
        }
        Arrays.sort(arr);
        int min = arr[0];
        int max = arr[n - 1];
        int i = 1;
        while (i < n && min > 0) {
            if (min > max - arr[i]) {
                min -= max - arr[i];
                arr[i] = max;
            } else {
                arr[i] += min;
                min = 0;
            }
            i++;
        }
        if (min > 0) {
            if(min % (n-1) ==0) {
                System.out.println(0);
                return;
            }
            System.out.println(n - 1 - (min % (n - 1)));

        } else {
            long count = 0;
            for (int j = 1; j < n; j++) {
                count += max - arr[j];
            }
            System.out.println(count);
        }


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