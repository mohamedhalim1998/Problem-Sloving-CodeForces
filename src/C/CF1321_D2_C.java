package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1321_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        char[] arr = scanner.next().toCharArray();

        int count = 0;
        for (int k = 0; k < 2; k++) {


            char curr = 'z';
            char prev = 'y';

            while (prev >= 'a') {
                int last = n - 1;
                while (last >= 0 && arr[last] == '?') {
                    last--;
                }
                for (int i = last - 1; i >= 0 && last < n; ) {
                    if (arr[i] == '?') {
                        i--;
                        continue;
                    }
                    if (arr[i] == curr && arr[last] == prev) {
                        arr[i] = '?';
                        i--;
                        count++;

                    } else if (arr[last] == curr && arr[i] == prev) {
                        arr[last] = '?';
                        if (last == n - 1) {
                            last = i;
                            i--;
                        } else {
                            last++;
                            while (last < n && arr[last] == '?') {
                                last++;
                            }
                        }
                        count++;
                    } else {
                        last = i;
                        i--;
                    }
                }
                prev--;
                curr--;

            }
        }
        System.out.println(count);

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