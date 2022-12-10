package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class CF1175_D2_B {
    static long OVERFLOW = (long) (Math.pow(2, 32));

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        long x = 0;
        int n = scanner.nextInt();
        Stack<Integer> loopStack = new Stack<>();
        Stack<Long> addStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            switch (s) {
                case "add":
                    if (loopStack.isEmpty()) {
                        x++;
                    } else {
                        long add = addStack.pop();
                        add++;
                        addStack.push(add);
                    }
                    break;
                case "for":
                    loopStack.push(scanner.nextInt());
                    addStack.push(0L);
                    break;
                case "end":
                    int loop = loopStack.pop();
                    long add = addStack.pop();
                    if (loopStack.isEmpty()) {
                        x += (long) loop * add;
                    } else {
                        add = loop * add;
                        add += addStack.pop();
                        addStack.push(add);
                        if (add >= OVERFLOW) {
                            System.out.println("OVERFLOW!!!");
                            return;
                        }
                    }
                    break;
            }
            if (x >= OVERFLOW) {
                System.out.println("OVERFLOW!!!");
                return;
            }
        }
        System.out.println(x);

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