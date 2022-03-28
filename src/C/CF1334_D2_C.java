package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1334_D2_C {
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
        Monster[] arr = new Monster[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Monster(scanner.nextLong(), scanner.nextLong());
        }
        long min = Long.MAX_VALUE;
        long[] diff = new long[n];
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                diff[i ] = Math.max(arr[i].a - arr[i - 1].b, 0);
            } else {
                diff[i] = Math.max(arr[i].a - arr[n - 1].b, 0);
            }
        }

        long sum = 0;
        for(long l : diff){
            sum += l;
        }

        for (int i = 0; i < n; i++) {
//            long count = arr[i].a;
//            for (int j = 0; j < n; j++) {
//                if (i == j) {
//                    continue;
//                }
//                if (j > 0) {
//                    count += Math.max(arr[j].a - arr[j - 1].b, 0);
//                } else {
//                    count += Math.max(arr[j].a - arr[n - 1].b, 0);
//                }
//            }

            min = Math.min(min, sum - diff[i] + arr[i].a);
        }
        out.append(min).append("\n");


    }

    static class Monster {
        long a, b;

        public Monster(long a, long b) {
            this.a = a;
            this.b = b;
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
