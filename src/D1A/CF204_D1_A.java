package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF204_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        long l = scanner.nextLong();
        long r = scanner.nextLong();
        System.out.println(count(r) - count(l - 1));

    }
    private static long count(long limit) {
        long result = 0;
        for (int digit=1; digit<=9; digit++) {
            result += count(digit, limit);
        }
        return result;
    }

    private static long count(int digit, long limit) {
        long result = 0;
        if (digit <= limit) {
            result++;
            if (11*digit <= limit) {
                result++;
                long power = 10;
                long max = 1;
                for (int pow=2; pow<=18; pow++) {
                    power *= 10;
                    long base = digit*(power+1);
                    max *= 10;
                    if (base <= limit) {
                        result += Math.min((limit-base)/10+1, max);
                    }
                }
            }
        }
        return result;
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
