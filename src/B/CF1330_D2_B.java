package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class CF1330_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            solve(scanner);
        }

    }

    private static void solve(FastScanner scanner) {
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);

        StringBuilder out = new StringBuilder();
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }
        int count = 0;
        boolean flag = true;
        boolean[] found = new boolean[max + 9];
        for (int i = 0; i < max; i++) {
            found[arr[i]] = true;
        }

        for (int i = 1; i < max + 1; i++) {
            flag = flag && found[i];
        }
        found = new boolean[max + 9];
        for (int i = max; i < n; i++) {
            found[arr[i]] = true;
        }

        for (int i = 1; i <= n - max; i++) {
            flag = flag && found[i];
        }
        if (flag) {
            count++;
            out.append(max).append(' ').append(n - max).append('\n');
        }
        if (max * 2 != n) {

            flag = true;
            found = new boolean[max + 9];
            for (int i = 0; i < n - max; i++) {
                found[arr[i]] = true;
            }

            for (int i = 1; i <= n - max; i++) {
                flag = flag && found[i];
            }
            found = new boolean[max + 9];
            for (int i = n - max; i < n; i++) {
                found[arr[i]] = true;
            }

            for (int i = 1; i < max + 1; i++) {
                flag = flag && found[i];
            }
            if (flag) {
                count++;
                out.append(n - max).append(' ').append(max).append('\n');
            }
        }

//        for (int i = 1; i < n-1; i++) {
//            if (max == i && n - i == n - max) {
//                out.append(i).append(' ').append(n - i).append('\n');
//                count++;
//                break;
//            }
//        }
//        for (int i = 1; i < n-1; i++) {
//            if (n - max== i && n - i == max ) {
//                out.append(i).append(' ').append(n - i).append('\n');
//                count++;
//                break;
//            }
//        }
        System.out.println(count);
        System.out.print(out);
//        HashSet<Integer> set = new HashSet<>();
//        int max = 0;
//        int len = 0;
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            len++;
//            max = Math.max(max, arr[i]);
//            if (max == len) {
//                list.add(len);
//                len = 0;
//                max = 0;
//            }
//
////            if (!set.contains(arr[i])) {
////                set.add(arr[i]);
////                max = Math.max(max, arr[i]);
////                len++;
////
////            } else {
////                if (max == len) {
////                    count++;
////                    out.append(i).append(' ').append(n - i).append('\n');
////                    break;
////                }
////            }
//        }
////        set = new HashSet<>();
//        len = 0;
//        max = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            len++;
//            max = Math.max(max, arr[i]);
//            if (len == max) {
//                list.add(len);
//                len = 0;
//                max = 0;
//            }
//        }
//        int count = list.size() / 2;
//        System.out.println(count);
//        for (int i = 0; i < count * 2; i += 2) {
//            if (list.get(i) + list.get(i + 1) == n) {
//                System.out.println(list.get(i) + " " + list.get(i + 1));
//            }
//        }
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