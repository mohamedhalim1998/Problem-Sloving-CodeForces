package A;

import java.lang.reflect.Array;
import java.util.Scanner;

public class CF514_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 5 min
        // debug 3 min
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        char[] arr = ("" + n).toCharArray();
        if (Character.getNumericValue(arr[0]) == 9) {
            System.out.print(arr[0]);
        } else if (Character.getNumericValue(arr[0]) >= 5) {
            System.out.print(9 - Character.getNumericValue(arr[0]));
        } else {
            System.out.print(arr[0]);
        }
        for (int i = 1; i < arr.length; i++) {
            char c = arr[i];
            if (Character.getNumericValue(c) >= 5) {
                System.out.print(9 - Character.getNumericValue(c));
            } else {
                System.out.print(c);
            }
        }
        System.out.println();
    }
}
