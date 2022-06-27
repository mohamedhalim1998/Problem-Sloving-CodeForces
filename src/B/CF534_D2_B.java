package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF534_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int v1 = scanner.nextInt();
        int v2 = scanner.nextInt();
        int t = scanner.nextInt();
        int d = scanner.nextInt();
        int[] arr = new int[t];
        arr[0] = v1;
        arr[t - 1] = v2;
        int v = v1 + d;
        for (int i = 1; i < t - 1; i++) {
            arr[i] = v;
            v += d;
        }
        v = v2 + d;
        for (int i = t - 2; i > 0; i--) {
            if (v < arr[i]) {
                int diff = arr[i] - v;
                if (diff <= d) {
                    arr[i] = arr[i] - diff;
                    break;
                } else {
                    arr[i] = v;
                    v += d;
                }
            } else {
                break;
            }
        }
        long sum = 0L;
        for(int x : arr) {
            sum += x;
        }
        System.out.println(sum);

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

        long[] nextArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        Long[] nextArrayLong(int n, boolean object) {
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}