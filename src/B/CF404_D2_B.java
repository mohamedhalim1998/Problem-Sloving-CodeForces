package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF404_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        double a = scanner.nextDouble();
        double d = scanner.nextDouble();
        int n = scanner.nextInt();
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {

            long c = (long) (i * d / (4 * a));
            double l = i * d - 4 * a * c;
            if (l <= a) {
                list.add(new Pair(l, 0));
            } else if (l < 2 * a) {
                list.add(new Pair(a, l - a));
            } else if (l < 3 * a) {
                list.add(new Pair(3 * a - l, a));
            } else {
                list.add(new Pair(0, 4 * a - l));
            }
        }

        StringBuilder out = new StringBuilder();
        for (Pair p : list) {
            out.append(p).append('\n');
        }


        System.out.println(out);

    }

    static class Pair {
        double x, y;

        public Pair(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("%.4f %.4f", x, y);
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
