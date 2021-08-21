package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF812_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        long s = scanner.nextLong();
        long[] arr = scanner.nextLongArray(n);

        int l = 0;
        int r = n + 1;
        while (l < r - 1) {
            long[] a = new long[n];
            int m = (l + r) / 2;
            for (int j = 0; j < n; j++) {
                a[j] = arr[j] + ((j + 1) * (long) m);
            }
            Arrays.sort(a);
            long sum = 0;
            for (int j = 0; j < m; j++) {
                sum += a[j];
            }
            if (sum > s) {
                r = m;
            } else {
                l = m;
            }

        }
        long[] a = new long[n];
        long m = l;
        for (int j = 0; j < n; j++) {
            a[j] = arr[j] + (j + 1) * m;
        }
        Arrays.sort(a);
        long sum = 0;
        for (int j = 0; j < m; j++) {
            sum += a[j];
        }

        if (l == 0) {
            System.out.println("0 0");
            return;
        }
        System.out.println(m + " " + sum);

    }

    static int lessSearch(int[] arr, int x) {
        int start = 0, end = arr.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= x) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
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

        long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}