package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF282_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        char[] a = scanner.next().toCharArray();
        char[] b = scanner.next().toCharArray();
        if (a.length != b.length) {
            System.out.println("NO");
            return;
        }
        boolean azero = true;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '1') {
                azero = false;
                break;
            }
        }
        boolean bzero = true;
        for (int i = 0; i < a.length; i++) {
            if (b[i] == '1') {
                bzero = false;
                break;
            }
        }
        if (azero || bzero) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println("YES");


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