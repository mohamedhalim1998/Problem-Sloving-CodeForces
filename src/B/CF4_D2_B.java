package B;

import java.util.Scanner;

public class CF4_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        int sumAll = scanner.nextInt();
        int[] minArr = new int[d];
        int sumMin = 0;
        int[] maxArr = new int[d];
        int sumMax = 0;
        for (int i = 0; i < d; i++) {
            int min = scanner.nextInt();
            int max = scanner.nextInt();
            minArr[i] = min;
            maxArr[i] = max;
            sumMin += min;
            sumMax += max;
        }
        if (sumAll > sumMax || sumAll < sumMin) {
            System.out.println("NO");
            return;
        }
        int rest = sumAll - sumMin;
        int i = 0;
        while (rest > 0) {
            int min = minArr[i];
            minArr[i] = maxArr[i];
            rest = rest - maxArr[i] + min;
            if(rest < 0){
                minArr[i] += rest;
            }
            i++;
        }
        System.out.println("YES");
        printArrayInLine(minArr);
    }

    public static void printArrayInLine(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
