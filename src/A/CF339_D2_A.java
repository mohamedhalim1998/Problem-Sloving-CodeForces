package A;

import java.util.Arrays;
import java.util.Scanner;

public class CF339_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug 2 min
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        String[] arr = in.split("\\+");
        Arrays.sort(arr);
        System.out.print(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            System.out.print("+"+ arr[i]);
        }
        System.out.println();
    }
}
