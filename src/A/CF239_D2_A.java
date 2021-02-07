package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF239_D2_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int y = scanner.nextInt();
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        int x = Integer.MIN_VALUE;
        int i = 1;
        while (x + y <= n) {
            x = i * k - y;
            if (x > 0 && x + y <= n){
                out.append(x).append(' ');
            }
            i++;
        }
        if(out.toString().equals("")){
            System.out.println(-1);
            return;
        }
        System.out.println(out);

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