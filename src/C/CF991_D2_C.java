package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF991_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        long n = scanner.nextLong();
        if (n <10) {
            System.out.println(1);
            return;
        }
        long l = 0;
        long r = n;
        long ans = l;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long a = 0;
            long o = n;
            if (mid == 0) {
                break;
            }
            while (o > 0) {
                a += Math.min(mid, o);
                o -= Math.min(mid, o);
                o -= o / 10;
            }
            if (a >= (n + 1) / 2) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ans);


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