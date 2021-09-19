package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1545_D1_A {
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
        int[] sorted = Arrays.copyOf(arr, n);
        Arrays.sort(sorted);
        HashMap<Integer, Item> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Item item = map.getOrDefault(arr[i], new Item());
            if (i % 2 == 0) {
                item.even++;
            } else {
                item.odd++;
            }
            map.put(arr[i], item);
        }
        HashMap<Integer, Item> mapSort = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Item item = mapSort.getOrDefault(sorted[i], new Item());
            if (i % 2 == 0) {
                item.even++;
            } else {
                item.odd++;
            }
            mapSort.put(sorted[i], item);
        }
        for (Map.Entry<Integer, Item> e : map.entrySet()) {
            if(!e.getValue().equals(mapSort.get(e.getKey()))){
                System.out.println("NO");
                return;
            }
        }


//        for (int i = 0; i < n; i++) {
//            int x = arr[i];
//            int lowest = lowest(sorted, x - 1);
//            int highest = highest(sorted, x + 1);
//            if (Math.abs(lowest - i) % 2 != 0) {
//                if (highest - lowest + 1 == 1) {
//                    System.out.println("NO");
//                    return;
//                }
//            }
//        }
//        int start = 0;
//        for (int i = 0; i < n; i++) {
//            int x = arr[i];
//            boolean found = false;
//            for (int j = -2; j < 3; j++) {
//                int index = i + j;
//                if (index < 0) {
//                    index += n;
//                }
//                if (index >= n) {
//                    index -= n;
//                }
//                if (sorted[index] == x && !used[index] && Math.abs(index - i) % 2 == 0) {
//                    found = true;
//                    used[index] = true;
//                    break;
//                }
//            }
//            if (!found) {
//                System.out.println("NO");
//                return;
//            }

//            if (index < start) {
//                index = start;
//            }
//            boolean found = false;
//            while (index < n && sorted[index] == x) {
//                if (!used[index] && Math.abs(index - i) % 2 == 0) {
//                    used[index] = true;
//                    found = true;
//                    if (index == start) {
//                        start++;
//                    }
//                    break;
//                }
//                index++;
//            }
//            if (!found) {
//                System.out.println("NO");
//                return;
//            }
//        }
        System.out.println("YES");
    }

    static class Item {
        int odd, even;

        public Item() {
            this.odd = 0;
            this.even = 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return odd == item.odd &&
                    even == item.even;
        }

        @Override
        public int hashCode() {
            return Objects.hash(odd, even);
        }
    }

    static int lowest(int[] arr, int x) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= x) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    static int highest(int[] arr, int x) {
        int start = 0, end = arr.length - 1;

        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= x) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
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
    }
}