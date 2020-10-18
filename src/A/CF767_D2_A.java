package A;

import java.util.PriorityQueue;
import java.util.Scanner;

public class CF767_D2_A {
    public static void main(String[] args) {
        // time reading 5 min
        // think 5 min
        // implement time 5 min
        // debug 20 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int size = n;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            queue.add(-x);
            if (x == size) {
                size--;
                System.out.print(-queue.remove());
                size = printQueue(queue, size);
            } else {
                if (i < n - 1)
                    System.out.println();
            }
        }
        printQueue(queue, -1);


    }

    private static int printQueue(PriorityQueue<Integer> queue, int size) {
        int y = queue.size();
        if (size == -1) {
            for (int i = 0; i < y - 1; i++) {
                int x = -queue.remove();
                System.out.print(x + " ");
            }
            if (y > 0) {
                System.out.print(-queue.remove());
                System.out.println();
            }
            return -1;
        }
        for (int i = 0; i < y; i++) {
            int x = -queue.remove();
            if (x == size) {
                System.out.print(" " + x);
                size--;
            } else {
                queue.add(-x);
                break;
            }
        }
        System.out.println();
        return size;
    }
}
