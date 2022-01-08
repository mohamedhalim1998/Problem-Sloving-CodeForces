package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF342_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        Time[] arr = new Time[m];
        for (int i = 0; i < m; i++) {
            arr[i] = new Time(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }
        StringBuilder out = new StringBuilder();
        int t = 1;
        int index = 0;
        if (a <= b) {
            for (int i = a; i < b; ) {
                if (index < m && arr[index].t == t) {
                    int l = arr[index].l;
                    int r = arr[index].r;
                    if ((i >= l && i <= r) || (i + 1 >= l && i + 1 <= r)) {
                        out.append("X");
                    } else {
                        out.append("R");
                        i++;
                    }
                    index++;
                } else {
                    out.append("R");
                    i++;
                }
                t++;
            }
        } else {
            for (int i = a; i > b; ) {
                if (index < m && arr[index].t == t) {
                    int l = arr[index].l;
                    int r = arr[index].r;
                    if ((i >= l && i <= r) || (i - 1 >= l && i - 1 <= r)) {
                        out.append("X");
                    } else {
                        out.append("L");
                        i--;
                    }
                    index++;
                } else {
                    out.append("L");
                    i--;
                }
                t++;
            }
        }
        System.out.println(out);

    }

    static class Time {
        int t, l, r;

        public Time(int t, int l, int r) {
            this.t = t;
            this.l = l;
            this.r = r;
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

        long[] nextArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        Long[] nextArrayLong(int n, boolean object) {
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}