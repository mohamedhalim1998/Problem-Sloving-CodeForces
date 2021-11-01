package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1062_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
//        int count = 0;
        if (n == 1) {
            System.out.println("1 0");
            return;
        }

        HashSet<Pair> set = primeFactors(n);
        int x = 1;
        for (Pair p : set) {
            x *= p.a;
        }
        int u = -1;
        boolean mul = false;
        for (Pair p : set) {
            int e = 1;
            int count = 0;
            while (e < p.i) {
                e *= 2;
                count++;
            }
            if (e !=p.i || (u != -1 && u != count)) {
                mul = true;
            }
            u = Math.max(u, count);
        }
        if (mul) {
            u += 1;
        }
        System.out.println(x + " " + u);



    }

    public static HashSet<Pair> primeFactors(int n) {
        HashSet<Pair> set = new HashSet<>();
        int count = 0;
        while (n % 2 == 0) {
            count++;
            n /= 2;
        }
        if (count > 0) {
            set.add(new Pair(2, count));
        }


        for (int i = 3; i * i <= n; i += 2) {
            count = 0;
            while (n % i == 0) {
                count++;
                n /= i;
            }
            if (count > 0) {
                set.add(new Pair(i, count));
            }
        }
        if (n > 2)
            set.add(new Pair(n, 1));

        return set;
    }

    static int greaterSearch(ArrayList<Long> arr, long target) {
        int start = 0, end = arr.size() - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr.get(mid) <= target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    static class Pair {
        int a, i;

        public Pair(int a, int i) {
            this.a = a;
            this.i = i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a &&
                    i == pair.i;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, i);
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