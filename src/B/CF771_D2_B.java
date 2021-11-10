package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.StringTokenizer;

public class CF771_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        String[] ans = new String[n - k + 1];
        boolean yes = false;
        for (int i = 0; i < n - k + 1; i++) {
            ans[i] = scanner.next();
            if(ans[i].equals("YES")){
                yes = true;
            }
        }
        String[] arr = new String[n];
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int index = 0;
        for (int i = 0; i < n; i++) {
                if (index < alphabet.length) {
                    arr[i] = String.valueOf(alphabet[index++]).toUpperCase();
                } else {
                    char[] a = {'A', alphabet[index - alphabet.length]};
                    arr[i] = String.valueOf(a);
                    index++;
                }

        }
        if (!yes) {
            for (int i = 0; i < n; i++) {
                arr[i] = "A";
            }
        } else {
            for (int i = 0; i < ans.length; i++) {
                if (ans[i].equals("NO")) {
                    arr[i + k - 1] = arr[i];
                }
            }
//            for (int i = 0; i < n; i++) {
//                if (arr[i] == null) {
//                    if (index < alphabet.length) {
//                        arr[i] = String.valueOf(alphabet[index++]).toUpperCase();
//                    } else {
//                        char[] a = {'A', alphabet[index - alphabet.length]};
//                        arr[i] = String.valueOf(a);
//                        index++;
//                    }
//                }
//            }

        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
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

        long[] nextArrayLong(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        Long[] nextArrayLong(int n, boolean object) {
            Long[] arr = new Long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}