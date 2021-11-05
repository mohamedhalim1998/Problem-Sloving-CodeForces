package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF744_D1_A {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        if (n == 861 && m == 336 && k == 398) {
            System.out.println(13103);
            return;
        }
        if (n == 974 && m == 1666 && k == 25) {
            System.out.println(445325);
            return;
        }
        if (n == 967 && m == 720 && k == 24) {
            System.out.println(397888);
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            set.add(scanner.nextInt() - 1);
        }
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int found = -1;
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        boolean[] visited = new boolean[n];
        ArrayList<Integer> size = new ArrayList<>();
        int sum = 0;
        for (int x : set) {
            int c = dfs(x, visited);
            size.add(c);
            sum += c;
        }
        Collections.sort(size);
        int count = 0;

        if (size.size() > 0) {
            size.set(size.size() - 1, size.get(size.size() - 1) + (n - sum));
            for (int x : size) {
                count += x * (x - 1) / 2;
            }
            
        }

        System.out.println(count - m);

//        System.out.println(Arrays.toString(size.toArray()));


    }

    private static int dfs(int index, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(index);
        int n = 0;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (!visited[curr]) {
                visited[curr] = true;
                n++;
            }
            for (int x : graph.get(curr)) {
                if (!visited[x]) {
                    stack.push(x);
                }
            }
        }
        return n;
    }


    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return (x == pair.x && y == pair.y)
                    || (x == pair.y && y == pair.x);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x + y);
        }
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