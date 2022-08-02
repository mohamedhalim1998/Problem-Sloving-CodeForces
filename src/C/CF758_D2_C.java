package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF758_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long k = scanner.nextLong();
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;

        if (n <= 2) {
            long count = k / (n * m);
            k -= count * (n * m);
            long min = count;
            long s = count;
            long max = min;
            if (k >= 1) {
                max++;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (k == 0) {
                        System.out.println(max + " " + min + " " + s);
                        return;
                    }
                    if (x == i && y == j) {
                        s++;
                    }
                    k--;

                }
            }

        }
        long min = 0;
        long max = 0;
        long s = 0;
        if (k >= n * m) {
            k -= n * m;
            max = 1;
            min = 1;
        } else {
            max = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (k == 0) {
                        System.out.println(max + " " + min + " " + s);
                        return;
                    }
                    if (x == i && y == j) {
                        s++;
                    }
                    k--;

                }
            }
        }
        if (k == 0) {
            System.out.println(min + " " + min + " " + min);
            return;
        }
        long count = 0;
        count = k / ((n - 1) * m);
        k -= count * ((n - 1) * m);
        if (count == 0) {
            max = min;
            if (x == 0 || x == n - 1) {
                s = min;
            } else {
                s = max;
            }
            if (k > 0) {
                max++;
            }
            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j < m; j++) {
                    k--;
                    if (x == i && y == j) {
                        s++;
                    }
                    if (k == 0) {
                        System.out.println(max + " " + min + " " + s);
                        return;
                    }
                }

            }
        }

        max += count;
        min += (count / 2);
        if (x == 0 || x == n - 1) {
            s = min;
        } else {
            s = max;
        }
        if (k > 0) {
            max++;
        }
        if (count % 2 == 0) {

            for (int i = n - 2; i >= 0; i--) {
                for (int j = 0; j < m; j++) {
                    if (k == 0) {
                        System.out.println(max + " " + min + " " + s);
                        return;
                    }
                    k--;
                    if (x == i && y == j) {
                        s++;
                    }

                }

            }
        } else {
            if(x == 0) {
                s++;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    k--;
                    if (x == i && y == j) {
                        s++;
                    }
                    if (k == 0) {
                        System.out.println(max + " " + min + " " + s);
                        return;
                    }
                }
            }
        }


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
