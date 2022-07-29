package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1047_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int gcd = arr[0];
        for (int i = 1; i < n; i++) {
            gcd = gcd(gcd, arr[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / gcd;
            max = Math.max(max, arr[i]);

        }

        linearSieve = new int[max + 1];
        calculateLinearSieve();
        for (int i : arr) {
            HashSet<Integer> temp = new HashSet<>();
            while (i > 1) {
                temp.add(linearSieve[i]);
                i /= linearSieve[i];
            }
            for (int j : temp) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }
        max = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            max = Math.max(max, e.getValue());
        }
        if (max == 0) {
            System.out.println(-1);
        } else {
            System.out.println(n - max);
        }


    }

    private static int[] linearSieve;

    private static void calculateLinearSieve() {
        ArrayList<Integer> compressedPrimes = new ArrayList<>();
        linearSieve[0] = 1;
        linearSieve[1] = 1;
        for (int i = 2; i < linearSieve.length; i++) {
            if (linearSieve[i] == 0) {
                linearSieve[i] = i;
                compressedPrimes.add(i);
            }
            for (int j : compressedPrimes) {
                if (i * j >= linearSieve.length) {
                    break;
                }
                linearSieve[i * j] = j;
                if (i % j == 0) {
                    break;
                }
            }
        }
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