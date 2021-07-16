package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1097_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
//        String[] arr = new String[n];
        HashMap<Integer, Integer> r = new HashMap<>();
        HashMap<Integer, Integer> l = new HashMap<>();
//        HashMap<String, Pair> map = new HashMap<>();
        int balance = 0;
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            int left = 0;
            int right = 0;

            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.add(c);
                } else {
                    if (stack.isEmpty()) {
                        left++;
                    } else {
                        stack.pop();
                    }
                }
            }
            right = stack.size();

            if (left == 0 && right == 0) {
                balance++;
            }
            if (left == 0) {
                r.put(right, r.getOrDefault(right, 0) + 1);
            } else if (right == 0) {
                l.put(left, l.getOrDefault(left, 0) + 1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> e : r.entrySet()) {
            count += Math.min(l.getOrDefault(e.getKey(), 0), e.getValue());
        }

        System.out.println(count + (balance / 2));
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