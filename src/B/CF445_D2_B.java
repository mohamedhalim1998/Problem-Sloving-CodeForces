package B;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CF445_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph.get(x - 1).add(y - 1);
            graph.get(y - 1).add(x - 1);
        }

        int max = Integer.MIN_VALUE;
        int start = -1;
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() > max) {
                max = graph.get(i).size();
                start = i;
            }
        }
        int[] visited = new int[graph.size()];
        long danger = bsf(graph, start, visited , 1);
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 0){
                danger = bsf(graph, i, visited, danger);
            }
        }
        System.out.println(danger);
    }

    private static long bsf(ArrayList<ArrayList<Integer>> graph, int start, int[] visited, long danger) {

        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(start);
        while (!linkedList.isEmpty()) {
            int x = linkedList.removeFirst();
            if (visited[x] == 0) {
                visited[x] = 1;
            } else {
                continue;
            }
            danger *= 2;
            for (int i = 0; i < graph.get(x).size(); i++) {
                if (visited[graph.get(x).get(i)] == 0) {
                    linkedList.add(graph.get(x).get(i));
                }
            }
        }
        return danger / 2;
    }

}
