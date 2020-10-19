package B;

import java.util.ArrayList;
import java.util.Scanner;

public class CF437_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        int limit = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = limit; i > 0 && sum > 0; i--) {
            int lowBit = Integer.lowestOneBit(i);
            if (sum - lowBit >= 0) {
                sum -= lowBit;
                list.add(i);
            }
        }

        if (sum == 0) {
            System.out.println(list.size());
            printArrayInLine(list.toArray());
        } else {
            System.out.println(-1);
        }


    }

    private static int lowBit(int i) {
        int count = 0;
        while (i % 2 == 0) {
            count++;
            i = i / 2;
        }
        return (int) Math.pow(2, count);
    }



    public static void printArrayInLine(Object[] arr) {
        for (Object o : arr) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
