package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF165_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int k = scanner.nextInt();
        String s = scanner.next();
        int[] count = new int[(int) 1e6 + 9];
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        if (ones < k) {
            System.out.println(0);
            return;
        }
        int[] sum = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            sum[i + 1] = sum[i];
            if (s.charAt(i) == '1') {
                sum[i + 1]++;
            }
        }
        long res = 0;
        for (int i = 0; i < sum.length; i++) {
            int index = sum[i] - k;
            if (index >= 0)
                res += count[index];
            count[sum[i]]++;
        }
        System.out.println(res);


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
