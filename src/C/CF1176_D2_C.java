package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CF1176_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        // 4 8 15 16 23 42
        ArrayList<Integer> a4 = new ArrayList<>();
        ArrayList<Integer> a8 = new ArrayList<>();
        ArrayList<Integer> a15 = new ArrayList<>();
        ArrayList<Integer> a16 = new ArrayList<>();
        ArrayList<Integer> a23 = new ArrayList<>();
        ArrayList<Integer> a42 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            switch (arr[i]) {
                case 4:
                    a4.add(i);
                    break;
                case 8:
                    a8.add(i);
                    break;
                case 15:
                    a15.add(i);
                    break;
                case 16:
                    a16.add(i);
                    break;
                case 23:
                    a23.add(i);
                    break;
                case 42:
                    a42.add(i);
                    break;
            }
        }
        int count = 0;
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
        int index = -1;
        for (; a < a4.size(); a++) {
            index = a4.get(a);
            for (; b < a8.size(); b++) {
                if (a8.get(b) > index) {
                    index = a8.get(b++);
                    break;
                }
            }
            if(arr[index] != 8){
                break;
            }
            for (; c < a15.size(); c++) {
                if (a15.get(c) > index) {
                    index = a15.get(c++);
                    break;
                }
            }
            if(arr[index] != 15){
                break;
            }
            for (; d < a16.size(); d++) {
                if (a16.get(d) > index) {
                    index = a16.get(d++);
                    break;
                }
            }
            if(arr[index] != 16){
                break;
            }
            for (; e < a23.size(); e++) {
                if (a23.get(e) > index) {
                    index = a23.get(e++);
                    break;
                }
            }
            if(arr[index] != 23){
                break;
            }
            for (; f < a42.size(); f++) {
                if (a42.get(f) > index) {
                    index = a42.get(f++);
                    break;
                }
            }
            if (arr[index] == 42) {
                count++;
            } else {
                break;
            }
        }

        System.out.println(n - count * 6);



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