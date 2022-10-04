package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF1503_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        String s = scanner.next();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        if (s.charAt(0) != '1' || s.charAt(n - 1) != '1' || count % 2 != 0) {
            System.out.println("NO\n");
            return;
        }
        char[] a = new char[n];
        Arrays.fill(a, '?');
        count = count / 2;
        boolean right = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                if(count > 0) {
                    a[i] = '(';
                } else {
                    a[i] = ')';
                }
                count--;
            } else if(right) {
                right = false;
                a[i] = '(';
            } else {
                right = true;
                a[i] = ')';
            }
        }
        char[] b = new char[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                b[i] = a[i];
            } else {
                b[i] = a[i] == '(' ? ')' : '(';
            }
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (b[i] == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    System.out.println("NO");
                    return;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("YES");
            System.out.println(String.valueOf(a));
            System.out.println(String.valueOf(b));
            return;
        }
        System.out.println("NO");


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
