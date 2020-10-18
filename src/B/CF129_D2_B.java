package B;

import java.util.ArrayList;
import java.util.Scanner;

public class CF129_D2_B {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        // time reading 3 min
        // think 3 min
        // implement time 7 min
        // debug 9 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            addEdge(x - 1, y - 1);
        }
        int count = 0;
        int groups = 0;

        do {
            count = 0;
            ArrayList<Integer> toRemove = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (graph.get(i).size() == 1) {
                    toRemove.add(i);
                    count++;
                }
            }
            for (int i : toRemove) {
                if (graph.get(i).size() > 0) {
                    int x = graph.get(i).get(0);
                    graph.get(i).remove(0);
                    graph.get(x).remove((Integer) i);
                }
            }
            if (count != 0) {
                groups++;
            }
        } while (count > 0);
        System.out.println(groups);

    }

    private static void addEdge(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }


}
