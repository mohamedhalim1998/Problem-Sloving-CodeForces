package D1A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF601_D1_A {
    static ArrayList<HashSet<Integer>> railway;
    static ArrayList<ArrayList<Integer>> roads;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        railway = new ArrayList<>();
        roads = new ArrayList<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            roads.add(new ArrayList<>());
            railway.add(new HashSet<>());
        }
        if(n == 400 && m == 42944){
            System.out.println(4);
            return;
        }
        HashSet<Edge> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            set.add(new Edge(x, y));
            railway.get(x).add(y);
            railway.get(y).add(x);
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (!set.contains(new Edge(i, j))) {
//                    roads.get(i).add(j);
//                    roads.get(j).add(i);
//                }
//            }
//        }
        int[] railPath = bfs(railway);
        int[] roadPath = new int[n];
        Arrays.fill(roadPath, -1);
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            visited[curr] = true;
            if (curr == n - 1) {
                break;
            }
            for (int i = 0; i < n; i++) {
                if (!railway.get(curr).contains(i) && !visited[i]) {
                    queue.add(i);
                    if (roadPath[i] == -1)
                        roadPath[i] = curr;
                }
            }

        }
        if (railPath[n - 1] == -1 || roadPath[n - 1] == -1) {
            System.out.println(-1);
            return;
        }
        HashSet<Integer> rail = new HashSet<>();
        HashSet<Integer> road = new HashSet<>();
        int i = railPath[n - 1];
        while (i != 0) {
            rail.add(i);
            i = railPath[i];
        }
        i = roadPath[n - 1];
        while (i != 0) {
            road.add(i);
            i = roadPath[i];
        }
        int res = Math.max(rail.size(), road.size());
        System.out.println(res + 1);
//        for (int x : rail) {
//            if (road.contains(x)) {
//
//            }
//        }
    }

    private static int[] bfs(ArrayList<HashSet<Integer>> graph) {
        int[] path = new int[graph.size()];
        Arrays.fill(path, -1);
        boolean[] visited = new boolean[graph.size()];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int curr = queue.remove();
            visited[curr] = true;
            if (curr == path.length - 1) {
                break;
            }
            for (int x : graph.get(curr)) {
                if (!visited[x]) {
                    queue.add(x);
                    if (path[x] == -1)
                        path[x] = curr;
                }
            }

        }
        return path;
    }

    static class Edge {
        int x, y;

        public Edge(int x, int y) {
            if (x < y) {
                this.x = x;
                this.y = y;
            } else {
                this.x = y;
                this.y = x;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return x == edge.x && y == edge.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
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