package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF1253_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        long sum = 0;
        int count = 0;
        int c = 0;
        StringBuilder out = new StringBuilder();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            if (set.contains(x)) {
                System.out.println(-1);
                return;
            }
            if (x > 0) {
                set.add(x);
            } else {
                if (!set.contains(-x)) {
                    System.out.println(-1);
                    return;
                }
            }
            sum += x;
            c++;
            if (sum == 0) {
                count++;
                out.append(c).append(' ');
                set = new HashSet<>();
                c = 0;
            }
        }
        if(sum != 0){
            System.out.println(-1);
            return;
        }
        System.out.println(count);
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

        Integer[] nextArray(int n, boolean object) {
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
    }
}