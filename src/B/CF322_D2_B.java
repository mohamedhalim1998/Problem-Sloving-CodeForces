package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF322_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int r = scanner.nextInt();
        int g = scanner.nextInt();
        int b = scanner.nextInt();
        int max = 0;
        // r
        int min = min(r % 3, g, b);
        if(min  <= b && min <= g)
        max = Math.max(max, r / 3 + min + (b - min) / 3 + (g - min) / 3);
        // g
        min = min(r, g % 3, b);
        if(min  <= r && min <= b)

            max = Math.max(max, g / 3 + min + (r - min) / 3 + (b - min) / 3);
        // b
        min = min(r, g, b % 3);
        if(min  <= r && min <= g)

            max = Math.max(max, b / 3 + min + (r - min) / 3 + (g - min) / 3);
        // r g
        max = Math.max(max, r / 3 + g / 3 + (b - Math.min(r % 3, g % 3)) / 3);
        // g b
        max = Math.max(max, g / 3 + b / 3 + (r - Math.min(g % 3, b % 3)) / 3);
        // r b
        max = Math.max(max, r / 3 + b / 3 + (g - Math.min(g % 3, b % 3)) / 3);
        int x = r / 3 + g / 3 + b / 3;
        x += Math.min(r % 3, Math.min(g % 3, b % 3));
        max = Math.max(max, x);
        int y = Math.min(r, Math.min(g, b));
        y += (r - y) / 3 + (g - y) / 3 + (b - y) / 3;
        max = Math.max(max, y);
//        System.out.println(Math.max(x,y));
        System.out.println(max);


    }

    static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
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
