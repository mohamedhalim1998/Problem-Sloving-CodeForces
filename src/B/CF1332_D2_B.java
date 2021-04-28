package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class CF1332_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 2; i < 32; i++) {
            if (isPrime(i)) {
                set.add(i);
            }
        }
        for (int i = 0; i < t; i++) {
            solve(scanner, set);
        }
    }

    static boolean isPrime(int m) {
        for (int i = 2; i * i <= m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void solve(FastScanner scanner, HashSet<Integer> set) {
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int i = 0;
        int m = 1;
        int[] res = new int[n];
        int[] temp = new int[50];
        for (int x : arr) {
            for (int k : set) {
                if (x % k == 0) {
                    if (temp[k] == 0)
                        temp[k] = m++;
                    res[i++] = temp[k];
                    break;

                }
            }
        }
        System.out.println(--m);
        for (i = 0; i < n; i++) {

            System.out.print((res[i]) + " ");
        }
        System.out.println();
    }

    static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
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