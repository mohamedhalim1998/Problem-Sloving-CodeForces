package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF111_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        long[] arr = new long[n];
        Arrays.fill(arr, 1);
        arr[0] = y - n + 1;
//        long a = arr[0] * n;
//        int i = 0;
//        while (a > y){
//            a--;
//            arr[i++]--;
//        }
        long sum = arr[0] * arr[0];
        sum += n - 1;

        if (arr[0] > 0 && sum >= x) {
            StringBuilder out = new StringBuilder();
            for (int j = 0; j < n; j++) {
                out.append(arr[j]).append('\n');
            }
            System.out.println(out);
        } else {
            System.out.println(-1);
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
