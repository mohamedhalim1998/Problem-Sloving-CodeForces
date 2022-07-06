package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF740_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Limit[] limits = new Limit[m];
        for (int i = 0; i < m; i++) {
            limits[i] = new Limit(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(limits);
        int max = limits[0].r - limits[0].l + 1;
        int e = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = e++;
            if (e == max) {
                e = 0;
            }
        }
        System.out.println(max);
        printArrayInLine(arr);

    }

    public static void printArrayInLine(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int value : arr) {
            builder.append(value).append(" ");
        }
        System.out.println(builder);
    }

    static class Limit implements Comparable<Limit> {
        int l, r;

        public Limit(int l, int r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Limit o) {
            return Integer.compare(r - l, o.r - o.l);
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
