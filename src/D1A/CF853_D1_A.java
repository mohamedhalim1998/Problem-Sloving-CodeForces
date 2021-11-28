package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CF853_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt() + 1;
        int[] arr = scanner.nextArray(n);
        long count = 0;
        int[] res = new int[n];
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(i, arr[i]);
        }
        Arrays.sort(items);
        int curr = k;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Item item = items[i];
            if (set.contains(curr)) {
                curr++;
                i--;
                continue;
            }
            if (item.index + 1 > curr) {
                set.add(item.index + 1);
                res[item.index] = item.index + 1;
            } else {
                count += item.d * (curr - item.index - 1);
                res[item.index] = curr;
                set.add(curr);
                curr++;
            }
        }
//        for (int i = k; i < k + n; i++) {
//            PriorityQueue<Item> queue = new PriorityQueue<>();
//            for (int j = 0; j < i && j < n; j++) {
//                if (res[j] == 0) {
//                    queue.add(new Item(j, arr[j] * (i - j)));
//                }
//            }
//            Item item = queue.poll();
//            res[item.index] = i;
//            count += item.d - arr[item.index];
//        }
        System.out.println(count);
        printArrayInLine(res);

    }

    public static void printArrayInLine(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int value : arr) {
            builder.append(value).append(" ");
        }
        System.out.println(builder);
    }

    static class Item implements Comparable<Item> {
        int index;
        long d;

        public Item(int index, long d) {
            this.index = index;
            this.d = d;
        }

        @Override
        public int compareTo(Item item) {
            return Long.compare(item.d, d);
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