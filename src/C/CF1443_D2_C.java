package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1443_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.println(out);
    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        int n = scanner.nextInt();
        Restaurant[] arr = new Restaurant[n];
        for (int i = 0; i < n; i++)
            arr[i] = new Restaurant();
        for (int i = 0; i < n; i++) {
            arr[i].a = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[i].b = scanner.nextInt();
        }
        Arrays.sort(arr);
        long sum = 0;
        long max = -1;
        for (int i = 0; i < n; i++) {

            if (arr[i].a > sum + arr[i].b) {
                sum += arr[i].b;
            } else {
                max = arr[i].a;
                break;
            }
        }
        out.append(Math.max(max, sum)).append('\n');


    }

    static class Restaurant implements Comparable<Restaurant> {
        int a, b;


        @Override
        public int compareTo(Restaurant restaurant) {
            return Integer.compare(restaurant.a, a);
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
    }
}