package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF296_D2_C {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        long[] arr = nextArray(scanner, n);
        Operation[] operations = new Operation[m];
        for (int i = 0; i < m; i++) {
            operations[i] = new Operation(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        }

        long[] opCount = new long[m + 9];
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            opCount[x]++;
            opCount[y + 1]--;
        }
        for (int i = 1; i < m + 1; i++) {
            opCount[i] = opCount[i - 1] + opCount[i];
        }
        long[] sums = new long[n + 9];
        for (int i = 0; i < m; i++) {
            Operation o = operations[i];
            long count = opCount[i + 1];
            sums[o.l] += (count * o.d);
            sums[o.r + 1] -= (count * o.d);
        }
        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + sums[i];
        }
        for (int i = 0; i < n; i++) {
            arr[i] += sums[i + 1];
        }


        printArrayInLine(arr);


    }

    private static void applyOperation(long[] arr, Operation operation, int count) {
        for (int i = operation.l - 1; i < operation.r; i++) {
            arr[i] += (operation.d * count);

        }
    }

    public static long[] nextArray(FastReader scanner, int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
//            arr[i] = i;
        }
        return arr;
    }

    static class Operation {
        int l;
        int r;
        int d;

        public Operation(int l, int r, int d) {
            this.l = l;
            this.r = r;
            this.d = d;
        }
    }

    public static void printArrayInLine(long[] arr) {
        for (long l : arr) {
            System.out.print(l + " ");
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
