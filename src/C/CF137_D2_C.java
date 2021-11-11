package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF137_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        Range[] ranges = new Range[n];
        for (int i = 0; i < n; i++) {
            ranges[i] = new Range(scanner.nextInt(), scanner.nextInt());
        }
        Arrays.sort(ranges);
        long count = 0;
        boolean[] included = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(included[i]){
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if(included[j]){
                    continue;
                }
                if(ranges[j].a > ranges[i].a && ranges[j].b < ranges[i].b) {
                    count++;
                    included[j] = true;
                } else {
                    break;
                }
            }
        }
        System.out.println(count);

    }

    static class Range implements Comparable<Range> {
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

        @Override
        public int compareTo(Range range) {
            if (a != range.a) {
                return Long.compare(a, range.a);
            } else {
                return  Long.compare(b, range.b);
            }
        }

        @Override
        public String toString() {
            return a + ":" +b;
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