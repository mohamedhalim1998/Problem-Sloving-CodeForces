package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class CF468_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        if (n < 4) {
            System.out.println("NO");
            return;
        }
        if (n == 4) {
            System.out.println("YES");
            System.out.println("3 * 4 = 12");
            System.out.println("12 * 2 = 24");
            System.out.println("24 * 1 = 24");
            return;
        }
        if (n == 5) {
            System.out.println("YES");
            System.out.println("4 * 5 = 20");
            System.out.println("20 + 3 = 23");
            System.out.println("2 - 1 = 1");
            System.out.println("23 + 1 = 24");
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == 4 || i == 6) {
                continue;
            }
            list.add(i);
        }
        StringBuilder out = new StringBuilder();
        out.append("YES\n");
        out.append("4 * 6 = 24\n");
        ArrayList<Integer> rem = new ArrayList<>();
        for (int i = list.size() - 1; i > 0; i -= 2) {
            int diff = list.get(i) - list.get(i - 1);
            out.append(list.get(i)).append(" - ").append(list.get(i - 1)).append(" = ").append(diff).append('\n');
            rem.add(diff);
        }
        if(list.size() % 2 == 1){
            rem.add(1);
        }
   //     System.out.println(Arrays.toString(rem.toArray()));

        while (rem.size() > 1) {
            Collections.sort(rem);
            ArrayList<Integer> copy = new ArrayList<>();
            for (int i = rem.size() - 1; i > 0; i -= 2) {
                int diff = rem.get(i) - rem.get(i - 1);
                out.append(rem.get(i)).append(" - ").append(rem.get(i - 1)).append(" = ").append(diff).append('\n');
                copy.add(diff);
            }
            if(rem.size() % 2 == 1){
                copy.add(rem.get(0));
            }
            rem = new ArrayList<>(copy);
         //   System.out.println(Arrays.toString(rem.toArray()));
        }
        if(rem.get(0) == 1){
            out.append("24 * 1 = 24\n");
        } else if(rem.get(0) == 0){
            out.append("24  + 0 = 24\n");
        }
        System.out.println(out);


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