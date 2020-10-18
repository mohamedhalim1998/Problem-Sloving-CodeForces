package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF304_D2_C {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        if (n % 2 == 0) {
            System.out.println("-1");
            return;
        }
        int[] n1 = new int[n];
        for (int i = 0; i < n; i++) {
            n1[i] = i;
        }
        int[] n2 = new int[n];
        for (int i = 0; i < n - 1; i++) {
            n2[i] = i + 1;
        }
        int[] n3 = new int[n];
        for (int i = 0; i < n; i++) {
            n3[i] = (n1[i] + n2[i]) % n;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(n1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(n2[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(n3[i] + " ");
        }
        System.out.println();
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
