package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF702_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] cities = scanner.nextArray(n);
        int[] towers = scanner.nextArray(m);
        long r = (long) 2e9;
        long l = (long) 2e-9;
        long mid = l + (r - l) / 2;
        long res = r;
        while (l <= r) {
            mid = l + (r - l) / 2;
            ArrayList<Range> list = new ArrayList<>();
            for (int x : towers) {
                list.add(new Range(x - mid, x + mid));
            }
            int i = 0;
            int j = 0;
            for (i = 0, j = 0; i < n && j < list.size(); i++) {
                if (!(cities[i] >= list.get(j).a && cities[i] <= list.get(j).b)) {
                    j++;
                    i--;
                }
            }
            if (i == n) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(res);

    }

    static class Range {
        long a, b;

        public Range(long a, long b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Range range = (Range) o;
            return (a == range.a && b == range.b) || (a == range.b && b == range.a);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a + b);
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