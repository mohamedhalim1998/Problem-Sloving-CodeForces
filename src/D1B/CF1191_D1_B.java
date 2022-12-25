package D1B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF1191_D1_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int[] update = new int[n];
        int q = scanner.nextInt();
        ArrayList<Payout> list = new ArrayList<>();
        list.add(new Payout(0, 0));
        for (int i = 0; i < q; i++) {
            int c = scanner.nextInt();
            if (c == 2) {
                list.add(new Payout(scanner.nextInt(), i + 1));
            } else {
                int index = scanner.nextInt() - 1;
                arr[index] = scanner.nextInt();
                update[index] = i + 1;
            }
        }
        int[] maxArr = new int[q+1];
        int curr = list.size() - 1;
        maxArr[q] = list.get(curr).m;
        int index = q -1;

        while (index >= 0 && curr > 0) {
            if (index == list.get(curr - 1).t) {
                curr--;
            }
            maxArr[index] = Math.max(maxArr[index + 1], list.get(curr).m);
            index--;
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < n; i++) {
            index = greaterSearch(list, update[i] - 1);
            int max = arr[i];
            if (index > -1) {
                max = Math.max(max, maxArr[list.get(index).t]);
            }
          out.append(max).append(' ');
        }
        System.out.println(out);
//        printArrayInLine(arr);

    }

    static int greaterSearch(ArrayList<Payout> arr, int target) {
        int start = 0, end = arr.size() - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr.get(mid).t <= target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    public static class Payout {
        int m, t;

        public Payout(int m, int t) {
            this.m = m;
            this.t = t;
        }
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
