package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF443_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        int k = scanner.nextInt();
        if (k >= s.length()) {
            int ans = (s.length() + k) / 2 * 2;
            System.out.println(ans);
            return;
        }
        int ans = k;

        int n = s.length();
        for (int i = k + 1; i <= n ; i++) {
            for (int j = 0; j < n; j++) {
                int s1 = j;
                int e1 = s1 + i;
                int s2 = s1 + i;
                int e2 = s2 + i;
                boolean found = true;
                if (e2 > n + k) {
                    break;
                }
                e2 = Math.min(n, e2);
                for (; s1 < e1 && s2 < e2; s1++, s2++) {
                    if (s.charAt(s1) != s.charAt(s2)) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    ans = i;
                    break;
                }
            }
        }

        System.out.println(ans * 2);

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