package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class CF1141_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n - 1);
        LinkedHashSet<Long> set = new LinkedHashSet<>();
        long sum = 0;
        long min = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += arr[i];
            if (sum < min) {
                min = sum;
            }
        }

        long prev = 1 - min;
        set.add(prev);
        if (prev > n || prev <= 0) {
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            long curr = prev + arr[i];
            set.add(curr);
            prev = curr;
            if (curr > n || curr <= 0) {
                System.out.println(-1);
                return;
            }
        }
        if (set.size() != n) {
            System.out.println(-1);
            return;
        }
        for (long x : set) {
            System.out.print(x + " ");
        }
        System.out.println();

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