package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class CF1181_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int l = scanner.nextInt();
        String s = scanner.next();
        boolean zero = false;
        int split = l / 2;
        if (l % 2 == 0) {
            if (s.charAt(split) != '0') {
                BigInteger n1 = new BigInteger(s.substring(0, split));
                BigInteger n2 = new BigInteger(s.substring(split));
                BigInteger sum = n1.add(n2);
                System.out.println(sum);
            } else {
                zero = true;
            }
        } else {
            if (s.charAt(split) != '0' && s.charAt(split + 1) != '0') {
                BigInteger n1 = new BigInteger(s.substring(0, split));
                BigInteger n2 = new BigInteger(s.substring(split));
                BigInteger sum1 = n1.add(n2);
                n1 = new BigInteger(s.substring(0, split + 1));
                n2 = new BigInteger(s.substring(split + 1));
                BigInteger sum2 = n1.add(n2);
                if (sum1.compareTo(sum2) < 0) {
                    System.out.println(sum1);
                } else {
                    System.out.println(sum2);
                }

            } else {
                zero = true;
            }
        }
        if (zero) {
            int start = split;
            int end = split;
            while (start > 1 && s.charAt(start) == '0') {
                start--;
            }
            while (end < l - 1 && s.charAt(end) == '0') {
                end++;
            }
            if (s.charAt(start) == '0') {
                BigInteger n1 = new BigInteger(s.substring(0, end));
                BigInteger n2 = new BigInteger(s.substring(end));
                BigInteger sum = n1.add(n2);
                System.out.println(sum);
                return;
            }
            if (s.charAt(end) == '0') {
                BigInteger n1 = new BigInteger(s.substring(0, start));
                BigInteger n2 = new BigInteger(s.substring(start));
                BigInteger sum = n1.add(n2);
                System.out.println(sum);
                return;
            }
            int min = Math.max(start, l - start);
            if (min > Math.max(end, l - end)) {
                BigInteger n1 = new BigInteger(s.substring(0, end));
                BigInteger n2 = new BigInteger(s.substring(end));
                BigInteger sum = n1.add(n2);
                System.out.println(sum);
            } else if (min == Math.max(end, l - end)) {
                BigInteger n1 = new BigInteger(s.substring(0, start));
                BigInteger n2 = new BigInteger(s.substring(start));
                BigInteger sum1 = n1.add(n2);
                n1 = new BigInteger(s.substring(0, end));
                n2 = new BigInteger(s.substring(end));
                BigInteger sum2 = n1.add(n2);
                if (sum1.compareTo(sum2) < 0) {
                    System.out.println(sum1);
                } else {
                    System.out.println(sum2);
                }
            } else {
                BigInteger n1 = new BigInteger(s.substring(0, start));
                BigInteger n2 = new BigInteger(s.substring(start));
                BigInteger sum = n1.add(n2);
                System.out.println(sum);
            }
        }
//        BigInteger min = new BigInteger(s);
//        int start = (l - 1) / 2;
//        boolean zero = false;
//        while (start > 1 && s.charAt(start) == '0') {
//            start--;
//            zero = true;
//        }
//        int end = start + 1;
//        while (end < l - 1 && s.charAt(end) == '0') {
//            end++;
//        }
//        int len = l;
//        int split = start;
//        while (start < l) {
//            if (s.charAt(start) == '0') {
//                start++;
//                if (zero) {
//                    start = end;
//                }
//                continue;
//            }
//            int min = Math.max(start, l - start);
//            if (min < len) {
//                len = min;
//                split = start;
//            }
//            start++;
//        }
//        BigInteger n1 = new BigInteger(s.substring(0, split));
//        BigInteger n2 = new BigInteger(s.substring(split));
//        BigInteger sum = n1.add(n2);
//        System.out.println(sum);
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