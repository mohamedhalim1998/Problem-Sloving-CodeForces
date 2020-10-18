package C;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CF546_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k1 = scanner.nextInt();

        Queue<Integer> p1 = new LinkedList<>();

        for (int i = 0; i < k1; i++) {
            p1.add(scanner.nextInt());
        }
        int k2 = scanner.nextInt();
        Queue<Integer> p2 = new LinkedList<>();
        for (int i = 0; i < k2; i++) {
            p2.add(scanner.nextInt());
        }
        int i = 0;
        while (!p1.isEmpty() && !p2.isEmpty() && i < 50 * n) {
            int a = p1.poll();
            int b = p2.poll();
            if (a > b) {
                p1.add(b);
                p1.add(a);
            } else if (a < b) {
                p2.add(a);
                p2.add(b);
            }
            i++;
        }
        if(i == 50*n){
            System.out.println(-1);
            return;
        }
        if (p1.isEmpty()) {
            System.out.println(i + " 2");
        } else {
            System.out.println(i + " 1");
        }

    }
}
