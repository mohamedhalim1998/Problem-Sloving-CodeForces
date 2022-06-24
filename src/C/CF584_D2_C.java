package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class CF584_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        String s1 = scanner.next();
        String s2 = scanner.next();
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                set.add(i);
            }
        }

        char[] res = new char[n];

        for (int i = 0; i < n; i++) {
            char c = 'a';
            while (c == s1.charAt(i) || c == s2.charAt(i)) {
                c++;
            }
            res[i] = c;
        }
        int diff = n;
        for (int x : set) {
            if (diff > t) {
                diff--;
                res[x] = s1.charAt(x);
            } else {
                break;
            }
        }
        if (diff > t) {
            int i = 0;
            int d = diff;
            for (; i < n && d > t; i++) {
                if (set.contains(i))
                    continue;
                res[i] = s1.charAt(i);
                d--;
            }
            d = diff;
            for (; i < n && d > t; i++) {
                if (set.contains(i))
                    continue;
                res[i] = s2.charAt(i);
                d--;
            }

            if(d > t) {
                System.out.println(-1);
                return;
            }
        }
            System.out.println(String.valueOf(res));


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