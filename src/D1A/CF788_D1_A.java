package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF788_D1_A {
    static int[][] mem;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        long max = Integer.MIN_VALUE;
        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = Math.abs(arr[i] - arr[i + 1]);
        }

        long sum = 0;
        boolean plus = true;
        for (int i = 0; i < n - 1; i++) {
            int curr = plus ? diff[i] : -diff[i];
            sum = sum + curr;
            if(sum < curr) {
                sum = curr;
            }
            max = Math.max(max, sum);
            plus = !plus;
        }
        plus = true;
        sum = 0;
        for (int i = 1; i < n - 1; i++) {
            int curr = plus ? diff[i] : -diff[i];
            sum = sum + curr;
            if(sum < curr) {
                sum = curr;
            }
            max = Math.max(max, sum);
            plus = !plus;
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                int sum = 0;
//                boolean pos = true;
//                for (int k = i; k < j; k++) {
//                    if (pos) {
//                        sum += Math.abs(arr[k] - arr[k + 1]);
//                    } else {
//                        sum -= Math.abs(arr[k] - arr[k + 1]);
//                    }
//                    pos = !pos;
//                }
//                max = Math.max(sum, max);
//            }
//        }
        System.out.println(max);


    }

    /*
    1 -> not taken
    2 -> pos
    3 -> neg
     */
//    private static int solve(int[] diff, int i, boolean pos) {
//        if (i > diff.length)
//            return 0;
//        if (pos) {
//
//        }
//
//
//    }

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
