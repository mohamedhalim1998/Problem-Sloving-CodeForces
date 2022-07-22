package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF63_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int[] arr = new int[10000];
        int n = scanner.nextInt();
        Arrays.fill(arr, 1);
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            for (int j = 0; j < arr.length; j++) {
                if (!compare(j, a, b, c)) {
                    arr[j] = 0;
                }
            }
        }
        int ans = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                if(ans == -1) {
                    ans = i;
                } else {
                    System.out.println("Need more data");
                    return;
                }
            }
        }
        if(ans == -1){
            System.out.println("Incorrect data");
        } else {
            System.out.printf("%04d", ans);
        }
    }

    private static boolean compare(int n, int a, int b, int c) {
        String s1 = "0000" + n;
        String s2 = "0000" + a;
        s1 = s1.substring(s1.length() - 4);
        s2 = s2.substring(s2.length() - 4);
        int[] digits = new int[10];
        for (int i = 0; i < 4; i++) {
            digits[s1.charAt(i) - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            if(digits[i] > 1) {
                return false;
            }
        }
        int b1 = 0;
        int c1 = 0;
        for (int i = 0; i < 4; i++) {
            if(s1.charAt(i) == s2.charAt(i)) {
                b1++;
            }
        }
        for (int i = 0; i < 4; i++) {
            if(s1.contains("" + s2.charAt(i))){
                c1++;
            }
        }
        c1 -= b1;

        return b == b1 && c == c1;
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
