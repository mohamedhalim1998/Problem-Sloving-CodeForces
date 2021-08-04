package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF1004_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        HashSet<Integer> set = new HashSet<>();
        int[] sums = new int[n];
        set.add(arr[0]);
        sums[0] = 1;
        for (int i = 1; i < n; i++) {
            if (set.contains(arr[i])) {
                sums[i] = sums[i - 1];
            } else {
                set.add(arr[i]);
                sums[i] = sums[i - 1] + 1;
            }
        }
        set = new HashSet<>();
        long count = 0;
        for (int i = n - 1; i > 0; i--) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                count += sums[i - 1];
            }
        }
        System.out.println(count);

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