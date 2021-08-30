package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1404_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String s = scanner.next();
        int z = 0;
        int o = 0;
        int q = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < n - k; i++) {
            if (arr[i] != '?' && arr[i + k] == '?') {
                arr[i + k] = arr[i];
            }
        }
        for (int i = n - 1; i >= k; i--) {
            if (arr[i] != '?' && arr[i - k] == '?') {
                arr[i - k] = arr[i];
            }
        }
        for (int i = 0; i < k; i++) {

            switch (arr[i]) {
                case '0':
                    z++;
                    break;
                case '1':
                    o++;
                    break;
                default:
                    q++;
                    break;
            }

        }
        int diff = Math.abs(z - o);
        if (diff > q) {
            System.out.println("NO");
            return;
        }
        boolean bl = true;
        for (int j = k; j < n; j++) {
            if (arr[j - k] != arr[j]) {
                bl = false;
                break;
            }
        }
        if(bl){
            System.out.println("YES");
        } else {
            System.out.println("NO");
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