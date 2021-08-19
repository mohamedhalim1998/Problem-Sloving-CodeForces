package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class CF276_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] freq = new int[(int) (2e5 + 9)];
        long[] arr = scanner.nextLongArray(n);
        Arrays.sort(arr);
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;
            freq[l]++;
            freq[r + 1]--;
        }
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] > 0){
                list.add(new Pair(i, freq[i]));
            }
        }
        Collections.sort(list);
        long sum = 0;
        int i = n - 1;
        for(Pair p : list){
            sum += p.n * arr[i];
            i--;
        }

        System.out.println(sum);
    }

    static class Pair implements Comparable<Pair> {
        int index;
        int n;

        public Pair(int index, int n) {
            this.index = index;
            this.n = n;
        }

        @Override
        public int compareTo(Pair pair) {

            return Integer.compare(pair.n , n);
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

        long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
    }
}