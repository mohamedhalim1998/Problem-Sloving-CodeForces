package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF381_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int m = scanner.nextInt();
        Input[] input = new Input[m];
        int[] cnt = new int[m];
        int[] a = new int[100000];
        int k = 0;
        for (int i = 0; i < m; ++i) {
            int t = 0, x = 0, y = 0;
            t = scanner.nextInt();
            if (t == 1) {
                x = scanner.nextInt();
                cnt[i] = 1;
                if (k < 100000)
                    a[k++] = x;
            } else {
                x = scanner.nextInt();
                y = scanner.nextInt();
                cnt[i] = x * y;
                c:
                for (int c = 0; c < y; ++c) {
                    for (int j = 0; j < x; ++j) {
                        if (k >= 100000)
                            break c;
                        a[k++] = a[j];
                    }
                }
            }
            input[i] = new Input(t, x, y);
        }
        long[] sum = new long[m];
        for (int i = 0; i < m; ++i)
            sum[i] = (i == 0 ? 0 : sum[i - 1]) + cnt[i];
        int n = scanner.nextInt();
        int i = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (n-- > 0) {
            long idx = scanner.nextLong() - 1;
            while (idx >= sum[i]) {
                i++;
            }
            if (input[i].t == 1) {
                ans.add(input[i].x);
            } else {
                long pi = idx - (i == 0 ? 0 : sum[i - 1]);
                pi %= input[i].x;
                ans.add(a[(int) pi]);
            }
        }

        printArrayInLine(ans);


    }

    public static void printArrayInLine(ArrayList<Integer> arr) {
        StringBuilder builder = new StringBuilder();
        for (Object value : arr) {
            builder.append(value).append(" ");
        }
        System.out.println(builder);
    }


    static class Input {
        int t, x, y;

        public Input(int t, int x, int y) {
            super();
            this.t = t;
            this.x = x;
            this.y = y;
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