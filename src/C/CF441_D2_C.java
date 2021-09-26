package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF441_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        StringBuilder out = new StringBuilder();
        int i = 1;
        int j = 1;
        boolean start = true;
        int rem = n * m - (k - 1) * 2;
        while (k > 0) {
            if (k > 1) {
                int count = 0;
                out.append(2);
                while (count < 2) {
                    if (start) {
                        while (j <= m && count < 2) {
                            out.append(' ').append(i).append(' ').append(j);
                            j++;
                            count++;
                        }
                        if (j == m + 1) {
                            i++;
                            j = m;
                            start = false;
                        }
                    } else {
                        while (j > 0 && count < 2) {
                            out.append(' ').append(i).append(' ').append(j);
                            j--;
                            count++;
                        }
                        if (j == 0) {
                            i++;
                            j = 1;
                            start = true;
                        }
                    }
                }
                k--;
                out.append('\n');
            } else {
                out.append(rem);
                while (i <= n) {
                    if (start) {
                        while (j <= m) {
                            out.append(' ').append(i).append(' ').append(j);
                            j++;
                        }
                        if (j == m + 1) {
                            i++;
                            j = m;
                            start = false;
                        }
                    } else {
                        while (j > 0) {
                            out.append(' ').append(i).append(' ').append(j);
                            j--;
                        }
                        if (j == 0) {
                            i++;
                            j = 1;
                            start = true;
                        }
                    }
                }
                break;
            }
        }
        System.out.println(out);
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