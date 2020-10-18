package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF525_D2_B {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        String s = scanner.next();
        int n = scanner.nextInt();
        int[] changes = new int[s.length() + 1];
        for (int i = 0; i < n; i++) {
            int l = scanner.nextInt() - 1;
            int r = s.length() - l;
            changes[l]++;
            changes[r]--;

        }
        char[] arr = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < changes.length /2; i++) {
            sum += changes[i];
            if (sum % 2 == 1) {
                int j = s.length() - i - 1;
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println(String.valueOf(arr));
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
    }
}
