package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CF49_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String n1 = scanner.next();
        String n2 = scanner.next();
        ArrayList<Integer> list = new ArrayList<>();
        for (char c : n1.toCharArray()) {
            list.add((int) c);
        }
        for (char c : n2.toCharArray()) {
            list.add((int) c);
        }
        Collections.sort(list);
        int max = list.get(list.size() - 1);
        int ans = 0;
        for (int i = 2; i <= 9; i++) {
            if (max < i + 48) {
                int sum = (Integer.parseInt(n1, i) + Integer.parseInt(n2, i));
                ans = Math.max(ans, Integer.toString(sum, i).length());
            }
        }
        for (int i = 0; i < 6; i++) {
            if (max < i + 65) {
                int sum = (Integer.parseInt(n1, i+10) + Integer.parseInt(n2, i+10));
                ans = Math.max(ans, Integer.toString(sum, i+10).length());
            }
        }
        System.out.println(ans);
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