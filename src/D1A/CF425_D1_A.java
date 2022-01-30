package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class CF425_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {

                ArrayList<Integer> l1 = new ArrayList<>();
                for (int i = l; i <= r; i++) {
                    l1.add(arr[i]);
                }
                Collections.sort(l1);
                ArrayList<Integer> l2 = new ArrayList<>();
                for (int i = 0; i < l; i++) {
                    l2.add(arr[i]);
                }
                for (int i = r + 1; i < n; i++) {
                    l2.add(arr[i]);
                }
                Collections.sort(l2);
                int s = 0;
                for (int x : l1) {
                    s += x;
                }
                max = Math.max(s, max);
                int sub = 0;
                int add = 0;
                for (int i = 0; i < k && i < l1.size() && l2.size() - i > 0; i++) {
                    sub += l1.get(i);
                    add += l2.get(l2.size() - 1 - i);
                    max = Math.max(s - sub + add, max);
                }
            }
        }

        System.out.println(max);

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