package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF719_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        String s = scanner.next();
        boolean isR = s.charAt(0) == 'r';
        int r = 0;
        int b = 0;


        for (int i = 0; i < n; i++) {
            if (!isR && s.charAt(i) == 'r') {
                b++;
            } else if (isR && s.charAt(i) == 'b') {
                r++;
            }
            isR = !isR;
        }
        int min = Math.max(r, b);
        isR = s.charAt(0) != 'r';
        r = 0;
        b = 0;
        for (int i = 0; i < n; i++) {
            if (!isR && s.charAt(i) == 'r') {
                b++;
            } else if (isR && s.charAt(i) == 'b') {
                r++;
            }
            isR = !isR;
        }
        min = Math.min(min ,Math.max(r , b));


        System.out.println(min);
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