package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF160_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        int[] arr = scanner.nextArray(n);
        Arrays.sort(arr);
        ArrayList<Item> list = new ArrayList<>();
        Item curr = new Item(arr[0], 1);
        for (int i = 1; i < n; i++) {
            if (curr.n != arr[i]) {
                list.add(curr);
                curr = new Item(arr[i], 1);
            } else {
                curr.count++;
            }
        }
        list.add(curr);
        long count = 0;
        for (int i = 0; i < list.size(); i++) {
            count += list.get(i).count * n;
            if(count >= k) {
                count -= list.get(i).count * n;

                for (int j = 0; j < list.size(); j++) {
                    count += list.get(i).count * list.get(j).count;
                    if (count >= k) {
                        System.out.println(list.get(i).n + " " + list.get(j).n);
                        return;
                    }
                }
            }
        }
        System.out.println(list.get(list.size() - 1).n + " " + list.get(list.size() - 1).n);

    }

    static class Item {
        int n;
        long count;

        public Item(int n, int count) {
            this.n = n;
            this.count = count;
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
    }
}
