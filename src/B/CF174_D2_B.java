package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF174_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s = scanner.next();
        ArrayList<Integer> dot = new ArrayList<>();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                dot.add(i);
            }
        }
        if (dot.size() == 0) {
            System.out.println("NO");
            return;
        }
        int last = 0;
        for (int i = 0; i < dot.size() - 1; i++) {
            String name = s.substring(last, dot.get(i));
            last = Math.min(dot.get(i) + 4, dot.get(i + 1) - 1);
            String ext = s.substring(dot.get(i), last);
            if (name.length() > 8 || ext.length() < 2 || name.length() == 0) {
                System.out.println("NO");
                return;
            }
            out.append(name).append(ext).append('\n');
        }
        String name = s.substring(last, dot.get(dot.size() - 1));
        String ext = s.substring(dot.get(dot.size() - 1));
        if (name.length() > 8 || ext.length() > 4 || ext.length() < 2 || name.length() == 0) {
            System.out.println("NO");
            return;
        }
        out.append(name).append(ext).append('\n');
        System.out.println("YES");
        System.out.println(out);
//        StringBuilder file = new StringBuilder();
//        ArrayList<String> list = new ArrayList<>();
//        int count = 0;
//        boolean dot = false;
//        for (int i = s.length() - 1; i > 0; i--) {
//            if (s.charAt(i) == '.' && s.charAt(i - 1) =='.') {
//                System.out.println("NO");
//                return;
//            }
//            if (s.charAt(i) == '.') {
//                file.append('.');
//                count = 0;
//                dot = true;
//                continue;
//            }
//            if (!dot && count < 4) {
//                file.append(s.charAt(i));
//                count++;
//            } else if (!dot) {
//                System.out.println("NO");
//                return;
//            } else if (count < 8 && s.charAt(i - 1) != '.') {
//                file.append(s.charAt(i));
//                count++;
//            } else if (count == 8 || s.charAt(i - 1) == '.') {
//                count = 0;
//                dot = false;
//                list.add(file.reverse().toString());
//                file = new StringBuilder();
//                i++;
//            } else if (count >= 8) {
//                System.out.println("NO");
//                return;
//            }
//        }
//        if (!dot && file.length() > 0) {
//            System.out.println("NO");
//            return;
//        }
//        file.append(s.charAt(0));
//        list.add(file.reverse().toString());
//        System.out.println("YES");
//        StringBuilder out = new StringBuilder();
//        for (int i = list.size() - 1; i >= 0; i--) {
//            out.append(list.get(i)).append('\n');
//        }
//        System.out.println(out);
//        int dot = s.lastIndexOf('.');
//        int count = 0;
//        for (int i = s.length() - 1; i >= dot; i++) {
//            file.append(s.charAt(i));
//        }
//        StringBuilder out = new StringBuilder();
//        for (int i = dot - 1; i > 0; i--) {
//            if (count < 8 && s.charAt(i - 1) != '.') {
//                file.append(s.charAt(i));
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