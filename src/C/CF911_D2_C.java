package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF911_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int k1 = scanner.nextInt();
        int k2 = scanner.nextInt();
        int k3 = scanner.nextInt();
        for (int x1 = Math.max(k1  - 10, 1); x1 <= k1; x1++) {
            for (int x2 = Math.max(k2  - 10, 1); x2 <= k2; x2++) {
                for (int x3 = Math.max(k3  - 10, 1); x3 <= k3; x3++) {
                    if (check(x1, x2, x3, k1, k2, k3)) {
//                        System.out.println(x1);
//                        System.out.println(x2);
//                        System.out.println(x3);
                        System.out.println("YES");
                        return;
                    }

                }
            }
        }
        System.out.println("NO");
    }

    private static boolean check(int x1, int x2, int x3, int k1, int k2, int k3) {
        int s = 2000;
        boolean[] on = new boolean[s];
        int max = Math.max(x1, Math.max(x2, x3));
        for (int i = x1; i < s; i += k1) {
            on[i] = true;
        }
        for (int i = x2; i < s; i += k2) {
            on[i] = true;
        }
        for (int i = x3; i < s; i += k3) {
            on[i] = true;
        }
        for (int i = max; i < s; i++) {
            if (!on[i]) {
                return false;
            }
        }
        return true;
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