package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CF1059_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        if (n == 3) {
            System.out.println("1 1 3");
            return;
        }
        int a = 1;
        int o = n / 2 * 2;
        ArrayList<Integer> list = new ArrayList<>();
        while (n > 1) {
            int c = n / 2;
            for (int i = 0; i < n - c; i++) {
                list.add(a);
            }
            a *= 2;
            n = n / 2;
        }
        if (n == 1) {
            if (a > 1) {
                a = a / 2;
                while (o % a != 0) {
                    o--;
                }
                list.add(o);
            } else {
                list.add(1);
            }
        }
        Collections.sort(list);
        printArrayInLine(list.toArray());

    }

    public static void printArrayInLine(Object[] arr) {
        StringBuilder builder = new StringBuilder();
        for (Object value : arr) {
            builder.append(value).append(" ");
        }
        System.out.println(builder);
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
