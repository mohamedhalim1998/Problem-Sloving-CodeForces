package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF990_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }

        HashMap<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = arr[i];
            Stack<Character> stack = new Stack<>();
            int r = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.add('(');
                } else {

                    if (stack.size() == 0) {
                        r++;
                    } else {
                        stack.pop();
                    }
                }
            }
            int l = stack.size();
            if (l == 0 && r == 0) {
                map.put(0, map.getOrDefault(0, 0L) + 1);
            } else if (l == 0) {
                map.put(r, map.getOrDefault(r, 0L) + 1);
            } else if (r == 0) {
                map.put(-l, map.getOrDefault(-l, 0L) + 1);
            }

            long count = 0;
            for (Map.Entry<Integer, Long> e : map.entrySet()) {
                if (e.getKey() > 0) {
                    count += e.getValue() * map.getOrDefault(-e.getKey(), 0L);
                }
            }
            count += map.getOrDefault(0, 0L) * map.getOrDefault(0, 0L);
            System.out.println(count);


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