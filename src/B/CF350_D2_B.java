package B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF350_D2_B {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int[] types = scanner.nextArray(n);
        int[] parents = scanner.nextArray(n);
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            if (parents[i] != 0)
                count[parents[i] - 1]++;
        }
        ArrayList<Integer> path = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (types[i] == 1) {
                ArrayList<Integer> list = bfs(i, parents, count);
                if (path.size() < list.size()) {
                    path = list;
                }
            }
        }
        System.out.println(path.size());
        Collections.reverse(path);
        printArrayInLine(path);

    }

    public static void printArrayInLine(ArrayList<Integer> arr) {
        StringBuilder builder = new StringBuilder();
        for (Object value : arr) {
            builder.append(value).append(" ");
        }
        System.out.println(builder);
    }

    private static ArrayList<Integer> bfs(int i, int[] parent, int[] count) {
        ArrayList<Integer> path = new ArrayList<>();
        int curr = i;
        while (curr != -1) {
            path.add(curr +1);
            curr = parent[curr] - 1;
            if(curr == -1){
                break;
            }
            if (count[curr] > 1) {
                break;
            }
        }
        return path;
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
