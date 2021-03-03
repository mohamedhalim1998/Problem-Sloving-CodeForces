package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1373_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            solve(scanner, out);
        }
        System.out.print(out);
    }

    private static void solve(FastScanner scanner, StringBuilder out) {
        String s = scanner.next();
        int[] plus = new int[s.length() + 2];
        int[] minus = new int[s.length() + 2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                plus[i + 1] = plus[i] + 1;
                minus[i + 1] = minus[i];
            } else {
                plus[i + 1] = plus[i];
                minus[i + 1] = minus[i] + 1;
            }
        }
        minus[minus.length - 1] = Integer.MAX_VALUE;
        int i = 0;
        long res = 0;
        while (true) {
            int index = greaterSearch(minus, i);
            if (index > s.length()) {
                res += s.length();
                break;
            } else {
                int p = plus[index];
                int m = minus[index];
                while (i + p >= m && index <= s.length()) {
                    index = greaterSearch(minus, i + p);
                    p = plus[index];
                    m = minus[index];
                }
                if (index > s.length()) {
                    res += s.length();
                    break;
                } else {
                    res += index;
                }
            }
            i++;

        }
        out.append(res).append('\n');
    }

    static int greaterSearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
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