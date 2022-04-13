package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF1364_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int[] b = new int[n];
        Arrays.fill(b,-1);
        int count = 0;
        for (int i = 1; i < n; i++) {
            if(arr[i] != arr[i - 1]){
                b[i] = arr[i - 1];
                count++;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int x : arr){
            set.add(x);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while (count < n){
            if(!set.contains(i)){
                count++;
                list.add(i);
            }
            i++;
        }
        for (int j = 0, k= 0; j < n; j++) {
            if(b[j] == -1){
                b[j] = list.get(k++);
            }
        }
       printArrayInLine(b);

    }
    public static void printArrayInLine(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int value : arr) {
            builder.append(value).append(" ");
        }
        System.out.println(builder);
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
