package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class CF1307_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        long[] arr1 = new long[26];
        long[][] arr2 = new long[26][26];

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j++)
                arr2[j][c] += arr1[j];
            arr1[c]++;
        }
        long ans = 0;
        for (int i = 0; i < 26; i++)
            ans = max(ans, arr1[i]);
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < 26; j++)
                ans = max(ans, arr2[i][j]);
//        int freq = 1;
//        long count = 1;
//        char c = s.charAt(0);
//        for (int i = 1; i < s.length(); i++) {
//            if (c == s.charAt(i)) {
//                freq++;
//            } else {
//                c = s.charAt(i);
//                count *= freq;
//                freq = 1;
//            }
//        }
//        count *= freq;
//        int[] chars = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            chars[s.charAt(i) - 'a']++;
//        }
//        for (int i = 0; i < 26; i++) {
//            if (chars[i] > count) {
//                System.out.println(chars[i]);
//                return;
//            }
//        }
        System.out.println(ans);

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