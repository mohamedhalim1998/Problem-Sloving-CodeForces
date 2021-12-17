package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF149_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        Item[] arr = new Item[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Item(i+1, scanner.nextLong());
        }
        Arrays.sort(arr);
        ArrayList<Integer> a = new ArrayList<>();
        long sumA = 0;
        ArrayList<Integer> b = new ArrayList<>();
        long sumB = 0;
        for (int i = 0; i < n; i++) {
            if (sumA < sumB) {
                a.add(arr[i].index);
                sumA += arr[i].value;
            } else {
                b.add(arr[i].index);
                sumB += arr[i].value;
            }
        }
        StringBuilder out = new StringBuilder();
        out.append(a.size()).append('\n');
        for(int x : a){
            out.append(x).append('\n');
        }
        out.append(b.size()).append('\n');
        for (int x : b) {
            out.append(x).append('\n');
        }
        System.out.println(out);




    }

    static class Item implements Comparable<Item> {
        int index;
        long value;

        public Item(int index, long value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Item item) {
            return Long.compare(value, item.value);
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