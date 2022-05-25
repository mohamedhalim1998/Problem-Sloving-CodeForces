package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF122_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        long sum = 0;
        char[] arr = new char[20];
        Arrays.fill(arr, '0');
        arr[19] = 4;
        long next = getNext(arr);
        for (int i = l; i <= r; i++) {
            if(i <= next) {
              //  System.out.println(i + ":" + next);
                sum += next;
            } else {
                next = getNext(arr);
                i--;
            }
        }
        System.out.println(sum);


    }

    private static long getNext(char[] arr) {
        for (int i = 19; i >= 0; i--) {
            if (arr[i] == '4') {
                arr[i] = '7';
                break;
            } else if(arr[i] == '7'){
                arr[i] = '4';
            } else {
                arr[i] = '4';
                break;
            }
        }

        return Long.parseLong(String.valueOf(arr));
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
