package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF1174_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = nextArray(scanner, 2 * n);
        Arrays.sort(arr);
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < n; i++) {
            s1 += arr[i];
            s2 += arr[i + n];
        }
        if(s1 != s2){
            printArrayInLine(arr);
        } else {
            System.out.println("-1");
        }

    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void printArrayInLine(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
