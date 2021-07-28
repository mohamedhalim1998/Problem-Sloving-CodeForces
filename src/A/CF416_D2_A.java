package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class CF416_D2_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        long min = (long) -2e9;
        long max = (long) 2e9;
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            int x = scanner.nextInt();
            char ans = scanner.next().toLowerCase().charAt(0);
            switch (s) {
                case ">=":
                    if (ans == 'y')
                        min = Math.max(min, x);
                    else
                        max = Math.min(max, x-1);
                    break;
                case ">":
                    if (ans == 'y')
                        min = Math.max(min, x + 1);
                    else
                        max = Math.min(max, x);
                    break;
                case "<=":
                    if (ans == 'y')
                        max = Math.min(max, x);
                    else
                        min = Math.max(min, x+1);
                    break;
                default:
                    if (ans == 'y')
                        max = Math.min(max, x - 1);
                    else
                        min = Math.max(min, x);
            }
        }
        if(max < min){
            System.out.println("Impossible");
            return;
        }
        System.out.println(min);

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