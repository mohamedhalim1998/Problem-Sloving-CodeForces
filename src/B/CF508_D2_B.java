package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF508_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        int n = Integer.MAX_VALUE;
        int index = -1;
        char[] arr = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            int d = Character.getNumericValue(arr[i]);
            int a = Character.getNumericValue(arr[s.length() - 1]);
            if (d % 2 == 0) {
                if (n == Integer.MAX_VALUE) {
                    n = d;
                    index = i;
                } else {
                    if(d < a){
                        n = d;
                        index = i;
                    }
                }
            }
        }
        if (n == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            char temp = arr[index];
            arr[index] = arr[s.length() - 1];
            arr[s.length() - 1] = temp;
            System.out.println(String.valueOf(arr));
        }
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