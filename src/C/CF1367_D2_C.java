package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF1367_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.println(out);

    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            int count = 0;
            for (int i = 0; i < n; i += k + 1) {
                count++;
            }
            out.append(count).append('\n');
            return;
        }
        int count = 0;
        int first = list.get(0);
        for (int i = 0; i < first - k; i += k + 1) {
            count++;
        }
        for (int i = 1; i < list.size(); i++) {
            int prev = list.get(i - 1);
            int curr = list.get(i);
            for (int j = prev + k + 1; j < curr - k; j += k + 1) {
                count++;
            }
        }
        int last = list.get(list.size() - 1);
        for (int i = last + k + 1; i < n; i += k + 1) {
            count++;
        }
        out.append(count).append('\n');
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