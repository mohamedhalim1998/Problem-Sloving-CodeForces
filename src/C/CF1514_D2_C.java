package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1514_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        long p = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (gcd(i, n) == 1) {
                p = p * i;
                p = p % n;
                list.add(i);
            }
        }
        if (p != 1) {
            for (Integer integer : list) {
                if (p != integer) {
                    out.append(integer).append(' ');
                }
            }
            System.out.println(list.size() - 1);
            System.out.println(out);
        } else {
            for (Integer integer : list) {
                out.append(integer).append(' ');
            }
            System.out.println(list.size());
            System.out.println(out);
        }


    }

    static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    static HashSet<Integer> divisors(int n) {
        HashSet<Integer> list = new HashSet<>();
        for (int i = 1; i * i <= n; i++) {
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

    public static LinkedHashSet<Integer> primeFactors(int n) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
//        set.add(1L);
        while (n % 2 == 0) {
            set.add(2);
            n /= 2;
        }


        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
        }
        if (n > 2)
            set.add(n);

        return set;
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
