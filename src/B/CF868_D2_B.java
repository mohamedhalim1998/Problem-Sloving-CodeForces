package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF868_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int h = scanner.nextInt() * 60 / 12;
        h = h % 60;
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int t1 = scanner.nextInt() * 60 / 12;
        t1 = t1 % 60;
        int t2 = scanner.nextInt() * 60 / 12;
        t2 = t2 % 60;
        if (t1 > t2) {
            int temp = t1;
            t1 = t2;
            t2 = temp;
        }

        boolean stuck = false;
        for (int i = t1; i < t2; i++) {
            if (i == m || i == s || i == h) {
                stuck = true;
                break;
            }
        }
        if (!stuck) {
            System.out.println("YES");
            return;
        }
        stuck = false;
        for (int i = t2; i < 60; i++) {
            if (i == m || i == s || i == h) {
                stuck = true;
                break;
            }
        }
        for (int i = 0; i < t1; i++) {
            if (i == m || i == s || i == h) {
                stuck = true;
                break;
            }
        }


        if (!stuck) {
            System.out.println("YES");
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
