package C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CF1143_D2_C {
    static ArrayList<ArrayList<Vertex>> graph = new ArrayList<>();

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] parent = new int[n];
        ArrayList<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt() - 1;
            int c = scanner.nextInt();
            parent[i] = p;
            vertices.add(new Vertex(i, c));
        }
        for (int i = 0; i < n; i++) {
            if (parent[i] >= 0) {
                graph.get(parent[i]).add(vertices.get(i));
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (vertices.get(i).c == 1) {
                boolean remove = true;
                for (Vertex v : graph.get(i)) {
                    if(v.c == 0){
                        remove = false;
                        break;
                    }
                }
                if(remove){
                    list.add(i +1);
                }
            }
        }
        StringBuilder out = new StringBuilder();

        for (int x : list) {
            out.append(x).append(' ');
        }
        if (list.size() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(out);
        }
    }


    static class Vertex {
        int n, c;

        public Vertex(int n, int c) {
            this.n = n;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex vertex = (Vertex) o;
            return n == vertex.n &&
                    c == vertex.c;
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
    }
}