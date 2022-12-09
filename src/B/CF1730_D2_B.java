package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class CF1730_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }


    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int[] pos = scanner.nextArray(n);
        int[] dress = scanner.nextArray(n);
        double start = 0;
        double end = (int) 1e9;
        double ans = Integer.MAX_VALUE;
        while (end - start > .000001) {
            double mid = (start + end) / 2;
            double check = check(pos, dress, mid);
            if (check > -1) {
                ans = check;
                end = mid - .00000001;
            } else {
                start = mid + .00000001;
            }

        }
        System.out.println(new DecimalFormat("#.00000").format(ans));

    }

    private static double check(int[] pos, int[] dress, double mid) {
        double[] diff = new double[pos.length];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = mid - dress[i];
            if (diff[i] < 0)
                return -1;
        }
        Pair p = new Pair(Math.max(0 , pos[0] - diff[0]), pos[0] + diff[0]);
        for (int i = 1; i < pos.length; i++) {
            p = p.intersect(new Pair(Math.max(0 , pos[i] - diff[i]), pos[i] + diff[i]));
            if (p == null)
                return -1;
        }
        return p.a;

    }

    static int min(int[] arr) {
        int min = arr[0];
        for (int x : arr) {
            min = Math.min(min, x);
        }
        return min;
    }

    static int max(int[] arr) {
        int max = arr[0];
        for (int x : arr) {
            max = Math.max(max, x);
        }
        return max;
    }

    static class Pair {
        double a, b;

        public Pair(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public Pair intersect(Pair pair) {
            double min = Math.max(pair.a, a);
            double max = Math.min(pair.b, b);
            if (min > max) {
                return null;
            }
            return new Pair(min, max);
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
