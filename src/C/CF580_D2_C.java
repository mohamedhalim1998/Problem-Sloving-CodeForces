package C;

import java.util.*;

public class CF580_D2_C {
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, scanner.nextInt());
        }
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            graph.get(a).add(new Edge(nodes[a], nodes[b]));
            graph.get(b).add(new Edge(nodes[b], nodes[a]));

        }
        dfs(nodes, m);
        int count = 0;

        for (Node node : nodes) {
            if (node.leaf && node.cat <= m) {
                count++;
            }
        }
        System.out.println(count);

    }

    private static void dfs(Node[] nodes, int m) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes[0]);
        boolean[] visited = new boolean[nodes.length];
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            visited[current.n] = true;
            if (graph.get(current.n).size() == 1 && current.n != 0) {
                current.leaf = true;
            }
            if (current.cat <= m) {
                for (Edge edge : graph.get(current.n)) {
                    if (!visited[edge.b.n]) {
                        queue.add(edge.b);
                        if (edge.b.cat > 0 || graph.get(edge.b.n).size() == 0) {
                            edge.b.cat += current.cat;
                        }
                    }
                }
            }
        }
    }

    static class Node {
        int n, cat;
        boolean leaf = false;
        public Node(int n, int cat) {
            this.n = n;
            this.cat = cat;
        }
    }

    static class Edge {
        Node a, b;

        public Edge(Node a, Node b) {
            this.a = a;
            this.b = b;
        }
    }
}
