package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF353_D2_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int sTop = 0;
        int sBottom = 0;
        int[] top = new int[n];
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            top[i] = x;
            bottom[i] = y;
            sTop += x;
            sBottom += y;
        }
        if (sTop % 2 == 0 && sBottom % 2 == 0) {
            System.out.println(0);
            return;
        }
        if (sTop % 2 == 1 && sBottom % 2 == 1) {
            for (int i = 0; i < n; i++) {
                if (top[i] % 2 == 0 && bottom[i] % 2 == 1) {
                    System.out.println(1);
                    return;
                }
            }
            for (int i = 0; i < n; i++) {
                if(top[i] % 2 == 1 && bottom[i] % 2 == 0){
                    System.out.println(1);
                    return;
                }
            }
        }
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
    }
}