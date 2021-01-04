package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1196_D2_B {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(FastReader scanner) {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = nextArray(scanner, n);
        ArrayList<Integer> odd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 1)
                odd.add(i);
        }
        if (odd.size() < k) {
            System.out.println("NO");
            return;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            out.append(odd.get(i) + 1).append(' ');
        }
        if ((odd.size() - k + 1) % 2 ==1){
            out.append(n);
            System.out.println("YES");
            System.out.println(out);
        } else {
            System.out.println("NO");
        }
    }

    public static int[] nextArray(FastReader scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
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

    }
}