package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF471_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        Item[] arr = new Item[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Item(i + 1, scanner.nextInt());
        }
        Arrays.sort(arr);
        HashSet<Integer> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        appendList(arr, builder);
        boolean found = false;
        for (int i = 0; i < n - 1; i++) {
            if (!set.contains(i) && arr[i].x == arr[i + 1].x) {
                Item t = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = t;
                set.add(i);
                found = true;
                break;
            }
        }
        if(found) {
            appendList(arr, builder);
        }
         found = false;
        for (int i = 0; i < n - 1; i++) {
            if (!set.contains(i) && arr[i].x == arr[i + 1].x) {
                Item t = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = t;
                set.add(i);
                found = true;
                break;
            }
        }
        if(found) {
            System.out.println("YES");
            appendList(arr, builder);
            System.out.println(builder);
            return;
        }
        System.out.println("NO");

    }

    static void appendList(Item[] arr, StringBuilder builder) {
        for (Item item : arr) {
            builder.append(item).append(' ');
        }
        builder.append('\n');
    }

    static class Item implements Comparable<Item> {
        int index, x;

        public Item(int index, int x) {
            this.index = index;
            this.x = x;
        }

        @Override
        public int compareTo(Item item) {
            return Integer.compare(x, item.x);
        }

        @Override
        public String toString() {
            return "" + index;
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