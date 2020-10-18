package B;

import java.util.*;

public class CF216_D2_B {
    private static ArrayList<ArrayList<Integer>> graph;
    private static HashSet<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            addEdge(n1 - 1, n2 - 1);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                int res = isCycle(i);
                System.out.println(res);
                if (res != -1) {
                    count++;
                }
            }
        }
//        count =  count /3;
//        if((n - count) %2 == 1){
//            count++;
//        }
        System.out.println(count);

    }


    static void addEdge(int n1, int n2) {
        graph.get(n1).add(n2);
        graph.get(n2).add(n1);
    }

    static int isCycle(int parent) {
       // visited = new HashSet<>();
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(parent);
        int count = 0;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (visited.contains(current)) {
                return count;
            } else {
                visited.add(current);
            }
            ArrayList<Integer> enemies = graph.get(current);
            if (enemies.size() == 1) {
                return -1;
            }
            for (int j : enemies) {
                    count++;
                    stack.push(j);

            }

        }
        return -1;
    }
}