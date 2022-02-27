package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF91_D1_A {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        String s1 = scanner.next();
        String s2 = scanner.next();
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            ArrayList<Integer> list = map.getOrDefault(c, new ArrayList<>());
            list.add(i);
            map.put(c, list);
        }
        for (char c : s2.toCharArray()) {
            if (!map.containsKey(c)) {
                System.out.println(-1);
                return;
            }
        }

        int index = -1;
        int count = 1;
        for (int i = 0; i < s2.length(); i++) {
            ArrayList<Integer> list = map.get(s2.charAt(i));
            int x = greaterSearch(list, index);
            if (x == -1) {
                count++;
                index = list.get(0);
            } else {
                index = list.get(x);
            }

        }

        System.out.println(count);


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