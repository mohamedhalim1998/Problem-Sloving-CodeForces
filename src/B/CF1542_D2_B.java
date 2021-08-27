package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF1542_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);

        }

    }

    private static void solve(FastScanner scanner) {
        long n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        long x = 1;
        if(a == 1){
            if((n - 1) % b == 0){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            return;
        }
        while (x <= n) {
            if (x % b == n % b) {
                System.out.println("YES");
                return;
            }
            x *= a;
        }
        System.out.println("NO");
//        HashSet<Long> set = new HashSet<>();
//        long min = 1;
//        set.add(1L);
//        while (min < n && !set.contains(n)) {
//            HashSet<Long> add = new HashSet<>();
//            for (long x : set) {
//                long l = x * a;
//                long r = x + b;
//                if (l < Integer.MAX_VALUE) {
//                    add.add(l);
//                }
//                if (r < Integer.MAX_VALUE) {
//                    add.add(r);
//                }
//            }
//            set = add;
//            min = Integer.MAX_VALUE;
//            for (long x : set) {
//                min = Math.min(min, x);
//            }
//        }
//        if (set.contains(n)) {
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }
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