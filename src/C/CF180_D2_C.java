package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF180_D2_C {
    static int[][] memo = new int[(int) (1e5 + 9)][2];


    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        int upper = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                upper++;
            }
        }
        for (int i = 0; i < memo.length; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
//        Arrays.fill(memo, -1);
        int min = s.length();
        min = solve(s, 0, 1);
        System.out.println(Math.min(min, upper));
    }

    private static int solve(String s, int curr, int upper) {
        if (curr == s.length())
            return 0;
        if (memo[curr][upper] != -1) {
            return memo[curr][upper];
        }
        if (upper == 1) {
            if (Character.isUpperCase(s.charAt(curr))) {
                memo[curr][upper] = Math.min(solve(s, curr + 1, 1), solve(s, curr + 1, 0));
            } else {
                int a = 1 + solve(s, curr + 1, 1);
                int b = solve(s, curr + 1, 0);
                memo[curr][upper] = Math.min(a, b);
            }
        } else {
            if (Character.isUpperCase(s.charAt(curr))) {
                memo[curr][0] = 1 + solve(s, curr + 1, 0);
            } else {
                memo[curr][0] = solve(s, curr + 1, 0);
            }
        }
        return memo[curr][upper];
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