package B;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF1368_D2_B {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner();
        long k = scanner.nextLong();
        int[] primes = {23, 19, 17, 13, 11, 7, 5, 3, 2};
//        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23};
        int[] res = new int[10];
        Arrays.fill(res, 1);
        int index = 0;
        long prod = 1;
        while (prod < k) {
            res[index++]++;
            index %= 10;
            prod = 1;
            for (int i = 0; i < 10; i++) {
                prod *= res[i];
            }

        }
        String s = "codeforces";
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < res[i]; j++) {
                out.append(s.charAt(i));
            }

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

        Integer[] nextArray(int n, boolean object) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}