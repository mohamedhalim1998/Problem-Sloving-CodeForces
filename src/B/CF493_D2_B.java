package B;

import java.util.ArrayList;
import java.util.Scanner;

public class CF493_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long sum1 = 0;
        long sum2 = 0;
        ArrayList<Long> first = new ArrayList<>();
        ArrayList<Long> second = new ArrayList<>();
        long last = 0;
        for (int i = 0; i < n; i++) {
            long x = scanner.nextLong();
            if (x > 0) {
                first.add(x);
                sum1 += x;
            } else {
                second.add(-x);
                sum2 += -x;
            }
            if (i == n - 1) {
                last = x;
            }
        }
        if (sum1 > sum2) {
            System.out.println("first");
        } else if (sum1 < sum2) {
            System.out.println("second");
        } else {
            int size = Math.min(first.size(), second.size());
            for (int i = 0; i < size; i++) {
                if (first.get(i) > second.get(i)) {
                    System.out.println("first");
                    return;
                } else if (first.get(i) < second.get(i)) {
                    System.out.println("second");
                    return;
                }
            }
            if (first.size() > second.size()) {
                System.out.println("first");
                return;
            } else if (first.size() < second.size()) {
                System.out.println("second");
                return;
            }
            if (last > 0) {
                System.out.println("first");
            } else {
                System.out.println("second");

            }
        }
    }
}
