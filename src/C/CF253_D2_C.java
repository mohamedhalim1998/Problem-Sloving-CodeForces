package C;

import java.io.*;
import java.util.*;

public class CF253_D2_C {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] dist;

    public static void main(String[] args) throws IOException {
//        FastScanner scanner = new FastScanner();
        FastScanner scanner = new FastScanner("input.txt");
        int n = scanner.nextInt();
        int[] arr = scanner.nextArray(n);
        int r1 = scanner.nextInt() - 1;
        int c1 = scanner.nextInt() - 1;
        int r2 = scanner.nextInt() - 1;
        int c2 = scanner.nextInt() - 1;
        int m = -1;
        for (int i = 0; i < n; i++) {
            m = Math.max(m, arr[i]);
        }
       dist = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Queue<Pair> queue = new LinkedList<>();
        dist[r1][c1] = 0;
//        dfs(map.get(new Pair(r1, c1)), -1, dist, visited);
        queue.add(new Pair(r1, c1));
        while (!queue.isEmpty()) {
            Pair curr = queue.remove();

            if(curr.r == r2 && curr.c == c2) {
                break;
            }
            if (curr.c > 0 && dist[curr.r][curr.c - 1] == Integer.MAX_VALUE) {
                dist[curr.r][curr.c - 1] = Math.min(dist[curr.r][curr.c] + 1, dist[curr.r][curr.c - 1]);
                queue.add(new Pair(curr.r, curr.c - 1));
            }
            if (curr.c < arr[curr.r] && dist[curr.r][curr.c+1] == Integer.MAX_VALUE) {
                dist[curr.r][curr.c + 1] = Math.min(dist[curr.r][curr.c] + 1, dist[curr.r][curr.c + 1]);
                queue.add(new Pair(curr.r, curr.c + 1));
            }
            if (curr.r < n - 1) {
                if (curr.c < arr[curr.r + 1]) {
                    if (dist[curr.r + 1][curr.c] == Integer.MAX_VALUE) {
                        dist[curr.r + 1][curr.c] = Math.min(dist[curr.r][curr.c] + 1, dist[curr.r + 1][curr.c]);
                        queue.add(new Pair(curr.r + 1, curr.c));
                    }
                } else {
                    if (dist[curr.r + 1][curr.c]== Integer.MAX_VALUE) {
                        dist[curr.r + 1][arr[curr.r + 1]] = Math.min(dist[curr.r][curr.c] + 1, dist[curr.r + 1][arr[curr.r + 1]]);
                        queue.add(new Pair(curr.r + 1, arr[curr.r + 1]));
                    }
                }
            }
            if (curr.r > 0) {
                if (curr.c < arr[curr.r - 1 ]) {
                    if (dist[curr.r - 1 ][curr.c] == Integer.MAX_VALUE) {
                        dist[curr.r - 1 ][curr.c] = Math.min(dist[curr.r][curr.c] + 1, dist[curr.r - 1 ][curr.c]);
                        queue.add(new Pair(curr.r - 1 , curr.c));
                    }
                } else {
                    if (dist[curr.r - 1 ][curr.c]== Integer.MAX_VALUE) {
                        dist[curr.r - 1 ][arr[curr.r - 1 ]] = Math.min(dist[curr.r][curr.c] + 1, dist[curr.r - 1 ][arr[curr.r - 1 ]]);
                        queue.add(new Pair(curr.r - 1 , arr[curr.r - 1 ]));
                    }
                }
            }

        }

//            int curr = queue.remove();
//            visited[curr] = true;
//            if (curr == map.get(new Pair(r2, c2))) {
//                break;
//            }
//            for (int x : graph.get(curr)) {
//                if (!visited[x]) {
//                    dist[x] = Math.min(dist[x], dist[curr] + 1);
//                    queue.add(x);
//                }
//            }


        //        System.out.println(dist[map.get(new Pair(r2, c2))]);
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output.txt"));
        fileWriter.write("" + dist[r2][c2]);
        fileWriter.close();

    }


    static class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return r == pair.r && c == pair.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        public FastScanner(String fileName) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(fileName));
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
