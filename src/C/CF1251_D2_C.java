package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CF1251_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        char[] num = scanner.next().toCharArray();
        if (num.length == 1) {
            System.out.println(String.valueOf(num));
            return;
        }
        LinkedList<Integer> even = new LinkedList<>();
        LinkedList<Integer> odd = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            int x = Character.getNumericValue(num[i]);
            if (x % 2 == 0) {
                even.add(x);
            } else {
                odd.add(x);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; !even.isEmpty() || !odd.isEmpty(); i++) {
            if (even.isEmpty()) {
                builder.append(odd.poll());
                continue;
            }
            if (odd.isEmpty()) {
                builder.append(even.poll());
                continue;
            }
            int e = even.peek();
            int o = odd.peek();
            if (e < o) {
                builder.append(e);
                even.poll();
            } else {
                builder.append(o);
                odd.poll();
            }
        }
        System.out.println(builder);
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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