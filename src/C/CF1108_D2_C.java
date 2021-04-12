package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF1108_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        char[] arr = scanner.next().toCharArray();
        int min = Integer.MAX_VALUE;

        if (n == 1) {
            System.out.println(0);
            System.out.println(String.valueOf(arr));
            return;
        }

        String[] permutation = {"RBG", "RGB", "BRG", "BGR", "GRB", "GBR"};
        int index = 0;
        for (int i = 0; i <permutation.length ; i++) {
            char[] colors = permutation[i].toCharArray();
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (colors[j % 3] != arr[j])
                    count++;
            }
            if(count < min) {
              min = count;
              index = i;
            }
        }

        char[] colors = permutation[index].toCharArray();
        for (int i = 0; i < n; i++) {
             arr[i] = colors[i % 3];
        }
        System.out.println(min);
        System.out.println(String.valueOf(arr));
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