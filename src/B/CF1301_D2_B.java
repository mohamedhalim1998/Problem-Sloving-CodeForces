package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1301_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.println(out);
    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        long m = Integer.MAX_VALUE;
        int k = 0;
        int l = 0;
        int r = (int) 1e9;

        while (Math.abs(l - r) > 500) {
            int mid = l + (r - l) / 2;
            long mm = 0;
            for (int i = 0; i < n - 1; i++) {
                long a = arr[i];
                long b = arr[i + 1];

                if (a == -1) {
                    a = mid;
                }
                if (b == -1) {
                    b = mid;
                }
                mm = Math.max(mm, Math.abs(a - b));
            }
            long ml = 0;
            for (int i = 0; i < n - 1; i++) {
                long a = arr[i];
                long b = arr[i + 1];

                if (a == -1) {
                    a = l;
                }
                if (b == -1) {
                    b = l;
                }
                ml = Math.max(ml, Math.abs(a - b));
            }
            long mr = 0;
            for (int i = 0; i < n - 1; i++) {
                long a = arr[i];
                long b = arr[i + 1];

                if (a == -1) {
                    a = r;
                }
                if (b == -1) {
                    b = r;
                }
                mr = Math.max(mr, Math.abs(a - b));
            }
            if (ml <= mm) {


                r = mid - 1;
            } else if (mr <= mm) {

                l = mid + 1;

            } else {
                if (ml > mr) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }


        }


        for (int i = l; i <= r; i++) {
            int max = 0;
            for (int j = 0; j < n - 1; j++) {
                int a = arr[j];
                int b = arr[j + 1];
                if (a == -1) {
                    a = i;
                }
                if (b == -1) {
                    b = i;
                }
                max = Math.max(max, Math.abs(a - b));
            }
            if (m > max) {
                m = max;
                k = i;
            } else {
                break;
            }
        }


        out.append(m).append(' ').append(k).append('\n');
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