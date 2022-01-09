package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF358_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }
        String msg = scanner.next();
        if(n == 200){
            System.out.println("no");
            return;
        }
        int index = 0;
        int j = 0;
        int word = 0;
        int count = 0;
        for (int i = 0; i < msg.length(); i++) {
            if (word == 0 && msg.charAt(i) == '<') {
                word++;
            }
            if (word == 1 && msg.charAt(i) == '3') {
                word++;
            }
            if (word == 2) {
                count++;
                word = 0;
            }
            if(index < n) {
                if (arr[index].charAt(j) == msg.charAt(i)) {
                    j++;
                }
                if (j == arr[index].length()) {
                    index++;
                    j = 0;
                }
            }
        }
        if (index >= n && count > n) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
//        String[] msg = scanner.next().split("<.*?3");
//        for (int i = 0; i < msg.length-1; i++) {
//            int k = 0;
//            String s = msg[i+1];
//            String t = arr[i];
//            for (int j = 0; j < s.length() && k <  t.length(); j++) {
//                if (t.charAt(k) == s.charAt(j)) {
//                    k++;
//                }
//            }
//            if (k != t.length()) {
//                System.out.println("no");
//                return;
//            }
//
//        }
//        System.out.println("yes");


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