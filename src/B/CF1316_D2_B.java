package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF1316_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        String s = scanner.next();
        char min = s.charAt(0);
        for (char c : s.toCharArray()) {
            if (min > c) {
                min = c;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == min) {
                list.add(i);
            }
        }
        String res = s;
        int minIndex = 0;
        for (int x : list) {
            String temp = convert(s, x);
            if (res.compareTo(temp) > 0) {
                res = temp;
                minIndex = x;
            }
        }
        System.out.println(res);
        System.out.println(minIndex + 1);

//        System.out.println(convert(s, 2));
    }

    private static String convert(String s, int k) {

        String r = s.substring(k);
        String o;
        if (s.length() % 2 == k  % 2) {
            o = s.substring(0, k);
        } else {
            o = reverse(s.substring(0, k));
        }

        s = r + o;
        return s;
    }

    private static String reverse(String s) {
        char[] arr = s.toCharArray();
        int left, right = 0;
        right = arr.length - 1;

        for (left = 0; left < right; left++, right--) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        return String.valueOf(arr);
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