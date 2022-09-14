package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1_D2_B {
    static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        StringBuilder out = new StringBuilder();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            if (s.matches("R\\d+C\\d+")) {
                int row = Integer.parseInt(s.substring(1, s.indexOf('C')));
                int col = Integer.parseInt(s.substring(s.indexOf('C') + 1));
                StringBuilder builder = new StringBuilder();
                while (col > 0) {
                    int rem = col % 26;
                    col = col / 26;
                    if (rem == 0) {
                        rem = 26;
                        col--;
                    }
                    builder.append(alphabet[rem - 1]);
                }
                out.append(builder.reverse()).append(row);
            } else {
                int row = 0;
                char[] arr = s.toCharArray();
                for (int j = 0; j < s.length(); j++) {
                    if (Character.isDigit(arr[j])) {
                        row = row * 10 + Character.getNumericValue(arr[j]);
                    }
                }
                int col = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (Character.isAlphabetic(arr[j])) {
                        col = col * 26 + (arr[j] - 'A' + 1);
                    }
                }
                out.append("R").append(row).append("C").append(col);
            }
            out.append('\n');
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
