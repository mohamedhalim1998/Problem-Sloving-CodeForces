package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1066_D2_B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                for (int j = Math.max(0, i - r + 1); j <= Math.min(n - 1, i + r - 1); j++) {
                    HashSet<Integer> set = map.get(j);
                    set.add(i);
                    map.put(j, set);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (map.get(i).size() == 0) {
                System.out.println(-1);
                return;
            }
            int max = 1;
            int maxIndex = i;
            for (int x : map.get(i)) {
                int count = 1;
                for (int j = i + 1; j < n; j++) {
                    if (map.get(j).contains(x)) {
                        count++;
                    } else {
                        break;
                    }
                }
                if (max < count) {
                    max = count;
                    maxIndex = x;
                }
            }
            ans++;
            i += max - 1;
        }
        System.out.println(ans);
//        HashSet<Integer> set = new HashSet<>();
//        int curr = 0;
//        for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
//            System.out.println(Arrays.toString(e.getValue().toArray()));
//            if (e.getValue().size() == 0) {
//                System.out.println(-1);
//                return;
//            } else {
//                int max = -1;
//                int
//                for (int x : e.getValue()) {
//
//                }
//
//            }
//        }
//        System.out.println(set.size());

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