package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF962_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String n = scanner.next();
        int len = ("" + n).length();
        int min = Integer.MAX_VALUE;
        for (int i = (1 << len) - 1; i > 0; i--) {

            StringBuilder builder = new StringBuilder();
            int c = 0;
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) {
                    builder.append(Character.getNumericValue(n.charAt(j)));
                    c++;
                }
            }
            long x = Long.parseLong(builder.toString());
            if (x > 0 && builder.charAt(0) != '0') {
                long sqr = (long) Math.sqrt(x);
                if (sqr * sqr == x) {
                   // System.out.println(x);
                    // System.out.println(len - c);
                    // return;
                    min = Math.min(min, len - c);
                }
            }
        }
        if(min == Integer.MAX_VALUE)
            min = -1;
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
    }
}