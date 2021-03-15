package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1407_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.println(out);
    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        Arrays.sort(arr);
        boolean[] marked = new boolean[n];
        int gcd = arr[n - 1];
        out.append(arr[n - 1]).append(' ');
        int index = -1;
        marked[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            int max = Integer.MIN_VALUE;
            int lgcd = gcd;
            for (int j = n - 1; j >= 0; j--) {
                if (j != index && !marked[j]) {
                    lgcd = gcd(gcd, arr[j]);
                    if (lgcd > max) {
                        index = j;
                        max = lgcd;
                    }
                }
            }
            marked[index] = true;
            out.append(arr[index]).append(' ');
            gcd = gcd(gcd, arr[index]);

        }
        out.append('\n');
    }

    static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    static class Mod implements Comparable<Mod> {
        int index, mod;

        public Mod(int index, int mod) {
            this.index = index;
            this.mod = mod;
        }

        @Override
        public int compareTo(Mod other) {
            return Integer.compare(mod, other.mod);
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
    }
}