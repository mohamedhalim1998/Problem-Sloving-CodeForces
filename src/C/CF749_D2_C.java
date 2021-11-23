package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF749_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        String s = scanner.next();
        TreeSet<Integer> d = new TreeSet<>();
        TreeSet<Integer> r = new TreeSet<>();
        boolean[] removed = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'D') {
                d.add(i);
            } else {
                r.add(i);
            }
        }
        int count = 0;
        while (count < n - 1) {
            for (int i = 0; i < n; i++) {
                if (!removed[i]) {
                    if (s.charAt(i) == 'D') {
                        if (r.size() == 0) {
                            System.out.println("D");
                            return;
                        }
                        int x = -1;
                        if (r.ceiling(i) != null) {
                            x = r.ceiling(i);
                        } else {
                            x = r.first();
                        }
                        removed[x] = true;
                        r.remove(x);
                    } else {
                        if (d.size() == 0) {
                            System.out.println("R");
                            return;
                        }
                        int x = -1;
                        if (d.ceiling(i) != null) {
                            x = d.ceiling(i);
                        } else {
                            x = d.first();
                        }
                        removed[x] = true;
                        d.remove(x);
                    }
                    count++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (!removed[i]) {
                System.out.println(s.charAt(i));
                return;
            }
        }


    }

    static int greaterSearch(ArrayList<Integer> arr, int target) {
        int start = 0, end = arr.size() - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr.get(mid) <= target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
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