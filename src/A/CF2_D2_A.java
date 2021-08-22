package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF2_D2_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        HashMap<String, Integer> map = new HashMap<>();
        int n = scanner.nextInt();
        String[] names = new String[n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            int val = scanner.nextInt();
            names[i] = s;
            values[i] = val;
            map.put(s, map.getOrDefault(s, 0) + val);

        }
        int max = -1;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            max = Math.max(max, e.getValue());
        }
        HashSet<String> set = new HashSet<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() == max) {
                set.add(e.getKey());
            }
        }
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(names[i])) {
                map.put(names[i], map.getOrDefault(names[i], 0) + values[i]);
                int val = map.get(names[i]);
                if (val >= max) {
                    System.out.println(names[i]);
                    return;
                }
            }

        }

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