package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF713_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char q = scanner.next().charAt(0);
            long x = scanner.nextLong();
            StringBuilder builder = new StringBuilder(19);
            for (int j = 0; j < 19; j++) {
                long d = x % 10;
                if (d % 2 == 0) {
                    builder.append(0);
                } else {
                    builder.append(1);
                }
                x = x / 10;
            }
            String s = builder.reverse().toString();
            if(q == '+'){
                map.put(s, map.getOrDefault(s, 0) + 1) ;
            } else if(q == '-'){
                map.put(s, map.getOrDefault(s, 0) - 1) ;
            } else {
                out.append(map.getOrDefault(s, 0)).append('\n');
            }
        }
        System.out.print(out);

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