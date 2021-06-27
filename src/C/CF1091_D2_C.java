package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1091_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        long n = scanner.nextInt();
        ArrayList<Long> list = new ArrayList<>();
        HashSet<Long> set = new HashSet<>();
        ArrayList<Long> divs = divisors(n);
        for (long i : divs) {
            long s = n / i * (1 + 1 - i + n) / 2;
            if (!set.contains(s)) {
                list.add(s);
                set.add(s);
            }

        }
        StringBuilder out = new StringBuilder();
        Collections.sort(list);
        for (long x : list) {
            out.append(x).append(' ');
        }
        System.out.println(out);
    }

    static ArrayList<Long> divisors(long n) {
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    list.add(i);
                } else {
                    list.add(i);
                    list.add(n / i);
                }
            }
        }
        return list;
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
    }
}