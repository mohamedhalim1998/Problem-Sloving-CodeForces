package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class CF837_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        Seal[] seals = new Seal[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            seals[i] = new Seal(i,x, y);
        }
        int max = 0;
        for (Seal s1 : seals) {
            for (Seal s2 : seals) {
                if (!s1.equals(s2)) {
                    if (s1.area() + s2.area() <= a * b) {
                        if (s1.x + s2.x <= a && Math.max(s1.y, s2.y) <= b) {
                            max = Math.max(max, s1.area() + s2.area());
                        }
                        if (s1.x + s2.y <= a && Math.max(s1.y, s2.x) <= b) {
                            max = Math.max(max, s1.area() + s2.area());
                        }
                        if (s1.y + s2.x <= a && Math.max(s1.x, s2.y) <= b) {
                            max = Math.max(max, s1.area() + s2.area());
                        }
                        if (s1.y + s2.y <= a && Math.max(s1.x, s2.x) <= b) {
                            max = Math.max(max, s1.area() + s2.area());
                        }
                        if (s1.x + s2.x <= b && Math.max(s1.y, s2.y) <= a) {
                            max = Math.max(max, s1.area() + s2.area());
                        }
                        if (s1.x + s2.y <= b && Math.max(s1.y, s2.x) <= a) {
                            max = Math.max(max, s1.area() + s2.area());
                        }
                        if (s1.y + s2.x <= b && Math.max(s1.x, s2.y) <= a) {
                            max = Math.max(max, s1.area() + s2.area());
                        }
                        if (s1.y + s2.y <= b && Math.max(s1.x, s2.x) <= a) {
                            max = Math.max(max, s1.area() + s2.area());
                        }


                    }
                }
            }

        }
        System.out.println(max);


    }

    static class Seal {
        int index, x, y;

        public Seal(int index,int x, int y) {
            this.x = x;
            this.y = y;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Seal seal = (Seal) o;
            return index == seal.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public int area() {
            return x * y;
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