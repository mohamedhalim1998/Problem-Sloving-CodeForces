package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF368_D2_B {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = nextArray(scanner, n);

        int[] d = new int[n + 1];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = n - 1; i > 0; i--) {
            set2.add(a[i]);
            d[i + 1] = set.size() - set2.size();
        }

        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            System.out.println(set.size() - d[l]);
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
