package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF148_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a + b + 1 > n) {
            System.out.println(-1);
            return;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        int max = 1;
        int sum = 1;
        int i = 1;

        for (int j = 0; j < b; j++) {
            arr[i++] = sum + 1;
            max = sum + 1;
            sum += sum + 1;
        }
        for (int j = i; j < n - a; j++) {
            arr[i++] = 1;
            sum++;
        }
        for (int j = 0; j < a; j++) {
            arr[i++] = max + 1;
            max++;
            sum += max;
        }
        max = arr[0];
        sum = arr[0];
        int a2 = 0;
        int b2 = 0;
        for (int j = 1; j < n; j++) {
            if (arr[j] > sum) {
                b2++;
            } else if (arr[j] > max) {
                a2++;
                max = arr[j];
            }
            sum += arr[j];

        }
        if (a2 == a && b2 == b) {
            printArrayInLine(arr);
        } else {
            System.out.println(-1);
        }

    }

    public static void printArrayInLine(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int value : arr) {
            builder.append(value).append(" ");
        }
        System.out.println(builder);
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
