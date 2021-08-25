package D3D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1409_D3_D {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }
    }

    private static void solve(FastScanner scanner) {
        String n = scanner.next();
        int s = scanner.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 20 - n.length(); i++) {
            builder.append('0');
        }
        builder.append(n);
        char[] arr = builder.toString().toCharArray();
        int sum = 0;
        for (int i = 0; i < 20; i++) {
            sum += Character.getNumericValue(arr[i]);
        }
        while (sum > s) {
            boolean up = false;
            sum = 0;
            for (int i = 0; i < 20; i++) {
                if (up) {
                    arr[i] = '0';
                    continue;
                }
                sum += Character.getNumericValue(arr[i]);
                if (sum > s) {
                    for (int j = i - 1; j >= 0; j--) {
                        if (arr[j] == '9') {
                            arr[j] = '0';
                        } else {
                            arr[j] += 1;
                            break;
                        }
                    }
                    arr[i] = '0';
                    up = true;
                }
            }
        }
        long num2 = Long.parseLong(String.valueOf(arr));
        long num = Long.parseLong(n);
        System.out.println(num2 - num);

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