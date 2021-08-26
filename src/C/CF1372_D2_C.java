package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1372_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int l = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == i + 1) {
                l++;
            } else {
                break;
            }
        }
        if(l == n){
            System.out.println(0);
            return;
        }
        int r = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == i + 1) {
                r--;
            } else {
                break;
            }
        }
        int count = 0;
        for (int i = l; i < r; i++) {
            if (arr[i] == i + 1) {
                count = 1;
                break;
            }
        }

        System.out.println(count + 1);
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