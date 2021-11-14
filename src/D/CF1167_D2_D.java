package D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF1167_D2_D {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        String s = scanner.next();
        Stack<Character> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.add('(');
            } else {
                stack.pop();
            }
            max = Math.max(max, stack.size());
        }
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        int[] depth = new int[max];
        for (int i = 0; i < max; i++) {
            if (i % 2 == 1) {
                depth[i] = 1;
            }
        }
        stack = new Stack<>();
        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(') {
                ans[i] = depth[stack.size()];
                stack.add('(');
            } else {
                stack.pop();
                ans[i] =  depth[stack.size()];
            }

        }

       // System.out.println(max);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            out.append(ans[i]);
        }
        System.out.println(out);
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