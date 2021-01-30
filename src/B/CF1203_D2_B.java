package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1203_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int q = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            solve(scanner, out);
        }
        System.out.println(out);
    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(4 * n);
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) {
            if (set.contains(x)) {
                set.remove(x);
            } else {
                set.add(x);
            }
        }
        if (set.size() != 0) {
            out.append("NO\n");
            return;
        }
        if (n == 1) {
            out.append("YES\n");
            return;
        }
        Arrays.sort(arr);
        int area = arr[0] * arr[4 * n - 1];
        for (int i = 1; i <= n; i++) {
            if (arr[2 * i - 2] != arr[2 * i - 1] ||
                    arr[4 * n - 2 * i] != arr[4 * n - 2 * i + 1] ||
                    arr[2 * i-2] * arr[4 * n - 2 * i + 1] != area) {
                out.append("NO\n");
                return;
            }
        }
        out.append("YES\n");

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