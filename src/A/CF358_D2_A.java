package A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class CF358_D2_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        if(n == 1){
            System.out.println("no");
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        list.add(arr[1]);
        Collections.sort(list);
        for (int i = 2; i < n; i++) {
            int x = arr[i - 1];
            int y = arr[i];
            list.add(y);
            int min = Math.min(x, y);
            int max = Math.max(x, y);
            Collections.sort(list);
            int index = binarySearch(list, min);
            if(list.get(0) == min && list.get(list.size() - 1) == max){
                continue;
            }
            if (list.get(index + 1) != max) {
                System.out.println("yes");
                return;
            }
        }

        System.out.println("no");
//        int min = Integer.MIN_VALUE;
//        int max = Integer.MAX_VALUE;
//        int x = scanner.nextInt();
//        int y = scanner.nextInt();
//        min = Math.min(x, y);
//        max = Math.max(x, y);
//        for (int i = 0; i < n - 2; i++) {
//            x = y;
//            y = scanner.nextInt();
//            if (Math.min(x, y) < min || Math.max(x, y) > max) {
//                System.out.println("yes");
//                return;
//            }
//
//            min = Math.min(x, y);
//            max = Math.max(x, y);
//        }
//        System.out.println("no");
    }

    static int binarySearch(ArrayList<Integer> arr, int x) {
        int start = 0, end = arr.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) > x) {
                end = mid - 1;
            } else if (arr.get(mid) == x) {
                return mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
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