package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF1322_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        char[] arr = scanner.next().toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int sum = 0;
        int start = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    if (count == 0)
                        start = i;
                    count++;
                } else {
                    stack.pop();
                }
            }
            if (count != 0 && stack.size() == count) {
                sum += i - start + 1;
                stack = new Stack<>();
                count = 0;
            }
        }
        if (stack.isEmpty() && count == 0)
            System.out.println(sum);
        else
            System.out.println(-1);

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