package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF290_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = "111111101010101111100101001111111\n" +
                "100000100000000001010110001000001\n" +
                "101110100110110000011010001011101\n" +
                "101110101011001001111101001011101\n" +
                "101110101100011000111100101011101\n" +
                "100000101010101011010000101000001\n" +
                "111111101010101010101010101111111\n" +
                "000000001111101111100111100000000\n" +
                "100010111100100001011110111111001\n" +
                "110111001111111100100001000101100\n" +
                "011100111010000101000111010001010\n" +
                "011110000110001111110101100000011\n" +
                "111111111111111000111001001011000\n" +
                "111000010111010011010011010100100\n" +
                "101010100010110010110101010000010\n" +
                "101100000101010001111101000000000\n" +
                "000010100011001101000111101011010\n" +
                "101001001111101111000101010001110\n" +
                "101101111111000100100001110001000\n" +
                "000010011000100110000011010000010\n" +
                "001101101001101110010010011011000\n" +
                "011101011010001000111101010100110\n" +
                "111010100110011101001101000001110\n" +
                "110001010010101111000101111111000\n" +
                "001000111011100001010110111110000\n" +
                "000000001110010110100010100010110\n" +
                "111111101000101111000110101011010\n" +
                "100000100111010101111100100011011\n" +
                "101110101001010000101000111111000\n" +
                "101110100011010010010111111011010\n" +
                "101110100100011011110110101110000\n" +
                "100000100110011001111100111100000\n" +
                "111111101101000101001101110010001";
        String[] arr = s.split("\n");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println(arr[x].charAt(y));

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