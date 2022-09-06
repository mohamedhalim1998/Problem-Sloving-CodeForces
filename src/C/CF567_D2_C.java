package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF567_D2_C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        long[] arr = scanner.nextArray(n);
        HashMap<Long, Integer> left = new HashMap<>();
        HashMap<Long, Integer> right = new HashMap<>();
        long count = 0;
        for (int i = 0; i < n; i++) {
            right.put(arr[i], right.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] % k == 0) {
                long l = left.getOrDefault(arr[i] / k, 0);
                long r = right.getOrDefault(arr[i] * k, 0);
                if(arr[i] * k == arr[i])
                    r--;
                count += l * r;
            }
            left.put(arr[i], left.getOrDefault(arr[i], 0) + 1);
            right.put(arr[i], right.getOrDefault(arr[i], 0) - 1);
        }
        System.out.println(count);

//        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            ArrayList<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
//            list.add(i);
//            map.put(arr[i], list);
//        }
//        long count = 0;
//        if (k == 1) {
//            for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
//                if (e.getValue().size() >= 3) {
//                    count += nCr(e.getValue().size(), 3);
//                }
//            }
//        } else {
//            for (Map.Entry<Integer, ArrayList<Integer>> e : map.entrySet()) {
//                ArrayList<Integer> a = e.getValue();
//                ArrayList<Integer> b = map.getOrDefault(e.getKey() * k, new ArrayList<>());
//                ArrayList<Integer> c = map.getOrDefault(e.getKey() * k * k, new ArrayList<>());
//                for (int x : a) {
//                    int y = greaterSearch(b, x);
//                    if(y == -1){
//                        break;
//                    }
//                    for (int i = y; i < b.size(); i++) {
//                        int z = greaterSearch(c, b.get(i));
//                        if (z == -1) {
//                           break;
//                        }
//                        count += c.size() - z;
//                    }
//                }
//            }
//        }
//        System.out.println(count);

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

    public static long nCr(long n, long r) {
        long ans = 1;
        for (int k = 0; k < r; k++) {
            ans = ans * (n - k) / (k + 1);
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

        long[] nextArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
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
