package D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CF1515_D2_D {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        for (int i = 0; i < l; i++) {
            int x = scanner.nextInt();
            left.put(x, left.getOrDefault(x, 0) + 1);
        }
        for (int i = 0; i < r; i++) {
            int x = scanner.nextInt();
            right.put(x, right.getOrDefault(x, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> e : left.entrySet()) {
            if (right.containsKey(e.getKey())) {
                int min = Math.min(e.getValue(), right.get(e.getKey()));
                count += min;
                right.put(e.getKey(), right.get(e.getKey()) - min);
                left.put(e.getKey(), left.get(e.getKey()) - min);
            }
        }
        int l1 = l - count;
        int r1 = r - count;
        int res = 0;
        if (l1 < r1) {
            for (Map.Entry<Integer, Integer> e : right.entrySet()) {
                int extra = r1 - l1;

                int min = Math.min(extra, e.getValue() / 2 * 2);
                res += min / 2;
                r1 -= min;
            }
            res += r1;


        } else if (r1 < l1) {
            for (Map.Entry<Integer, Integer> e : left.entrySet()) {
                int extra = l1 - r1;
                int min = Math.min(extra, e.getValue() / 2 * 2);
                res += min / 2;
                l1 -= min;
            }
            res += l1;

        } else {
            res += l1;
        }
        System.out.println(res);
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