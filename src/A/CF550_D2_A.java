package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF550_D2_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();

        int index = s.indexOf("AB");
        ArrayList<Integer> ab = new ArrayList<>();
        while (index != -1) {
            ab.add(index);
            index = s.indexOf("AB", index+1);
        }
        index = s.indexOf("BA");
        ArrayList<Integer> ba = new ArrayList<>();
        while (index != -1) {
            ba.add(index);
            index = s.indexOf("BA", index+1);
        }
        if (ab.isEmpty() || ba.isEmpty()) {
            System.out.println("NO");
            return;
        }
        for (int x : ab) {
            for (int y : ba) {
                if (Math.abs(x - y) > 1) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
//        int ba = s.indexOf("BA", ab);
//        if (ab == -1 || ba == -1 || ab == ba - 1) {
//            ba = s.indexOf("BA");
//            ab = s.indexOf("AB", ba);
//            if (ab == -1 || ba == -1 || ab == ba + 1) {
//                System.out.println("NO");
//            } else {
//                System.out.println("YES");
//            }
//        } else {
//            System.out.println("YES");
//        }

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