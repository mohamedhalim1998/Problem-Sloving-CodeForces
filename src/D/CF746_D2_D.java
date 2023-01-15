package D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF746_D2_D {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        StringBuilder out = new StringBuilder();
        int countLast = 0;
        char last = ' ';
        while (a > 0 || b > 0) {
            if (a > b) {
                if (last != 'a') {
                    last = 'a';
                    countLast = 1;
                    out.append('G');

                    a--;
                } else if (countLast < k) {
                    countLast++;
                    out.append('G');

                    a--;
                } else if (countLast == k && b == 0) {
                    System.out.println("NO");
                    return;
                } else {
                    last = 'b';
                    countLast = 1;
                    out.append('B');
                    b--;
                }
            } else {
                if (last != 'b') {
                    last = 'b';
                    countLast = 1;
                    b--;
                    out.append('B');
                } else if (countLast < k) {
                    countLast++;
                    b--;
                    out.append('B');
                } else if (countLast == k && a == 0) {
                    System.out.println("NO");
                    return;
                } else {
                    last = 'a';
                    countLast = 1;
                    out.append('G');
                    a--;
                }
            }
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
