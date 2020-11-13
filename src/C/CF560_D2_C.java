package C;

import java.util.Arrays;
import java.util.Scanner;

public class CF560_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sides = nextArray(scanner, 6);
        int count = (sides[1] + sides[2] + sides[3]);
        count *= count;
        count -= sides[1] * sides[1];
        count -= sides[3] * sides[3];
        count -= sides[5] * sides[5];
        System.out.println(count);
    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

}
