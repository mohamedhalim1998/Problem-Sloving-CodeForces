package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF363_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        String o = s;
        // three
        StringBuilder out = new StringBuilder();
        boolean change = true;
        while (change) {
            change = removeThrees(s, out);
            s = out.toString();
            out = new StringBuilder();
        }
        change = true;
        while (change) {
            change = removeDoubles(s, out);
            s = out.toString();
            out = new StringBuilder();
        }
        String res1 = s;
        s = o;
        change = true;
        while (change) {
            change = removeDoubles(s, out);
            s = out.toString();
            out = new StringBuilder();
        }

        change = true;
        while (change) {
            change = removeThrees(s, out);
            s = out.toString();
            out = new StringBuilder();
        }

        System.out.println(s.length() > res1.length() ? s : res1);
    }

    private static boolean removeDoubles(String s, StringBuilder out) {
        boolean change = false;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 3 && s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 2) == s.charAt(i + 3)) {
                out.append(s.charAt(i)).append(s.charAt(i)).append(s.charAt(i + 2));
                i += 3;
                change = true;
            } else {
                out.append(s.charAt(i));
            }
        }
        return change;
    }

    private static boolean removeThrees(String s, StringBuilder out) {
        boolean change = false;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 2 && s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
                out.append(s.charAt(i)).append(s.charAt(i));
                i += 2;
                change = true;
            } else {
                out.append(s.charAt(i));
            }
        }
        return change;
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