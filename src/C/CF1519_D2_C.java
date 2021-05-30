package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1519_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int max = 0;
        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            s[i] = x - 1;
            max = Math.max(max, x);
        }


        ArrayList<ArrayList<Long>> lists = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            lists.add(new ArrayList<>());
            lists.get(i).add(0L);
        }
        for (int i = 0; i < n; i++) {
            lists.get(s[i]).add(scanner.nextLong());
        }
        for (int i = 0; i < max; i++) {
            Collections.sort(lists.get(i));
        }

        for (int i = 0; i < max; i++) {
            for (int j = 1; j < lists.get(i).size(); j++) {
                lists.get(i).set(j, lists.get(i).get(j) + lists.get(i).get(j - 1));
            }
        }
        StringBuilder out = new StringBuilder();
        long[] res = new long[n + 1];
        for (ArrayList<Long> list : lists) {
            int size = list.size();
            for (int i = 1; i <= n && i <= size; i++) {
                res[i] += list.get(size - 1) - list.get((size - 1) % i);
            }
        }
        for (int i = 1; i <= n; i++) {
            out.append(res[i]).append(' ');
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
    }
}