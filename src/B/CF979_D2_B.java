package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF979_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        // Kuro, Shiro and Katie
        String kuro = scanner.next();
        String shiro = scanner.next();
        String katie = scanner.next();
        int maxKuro = calculateMax(kuro, n);
        int maxShiro = calculateMax(shiro, n);
        int maxKatie = calculateMax(katie, n);

        if (maxKuro > maxKatie && maxKuro > maxShiro) {
            System.out.println("Kuro");
        } else if (maxKatie > maxKuro && maxKatie > maxShiro) {
            System.out.println("Katie");
        } else if (maxShiro > maxKatie && maxShiro > maxKuro) {
            System.out.println("Shiro");
        } else {
            System.out.println("Draw");
        }
    }

    public static int calculateMax(String s, int n) {
        if (n > s.length()) {
            return s.length();
        }
        int max = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int x : freq.values()) {
            int a = x;
            if (x + n <= s.length()) {
                a = x + n;
            } else {
                if (n > 1)
                    return s.length();
                else
                    return s.length() - 1;
            }
            max = Math.max(a, max);
        }

        return max;
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