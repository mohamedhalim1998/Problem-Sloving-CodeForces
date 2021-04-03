package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1443_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        char[] arr = scanner.next().toCharArray();
        int count = 0;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (Character.getNumericValue(arr[i]) == 1) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println(0);
            return;
        }
        int sum = a;
        for (int i = index + 1; i < arr.length; i++) {
            if (Character.getNumericValue(arr[i]) == 0) {
                count++;
            } else if (Character.getNumericValue(arr[i]) == 1 && count > 0) {

                sum += Math.min(b * count, a);
                count = 0;
            }

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