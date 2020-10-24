package A;

import java.util.Scanner;

public class CF478_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] c = nextArray(scanner, 5);
        int n = sumArray(c);
        if(n == 0){
            System.out.println(-1);
            return;
        }
        if (n % 5 == 0) {
            System.out.println(n / 5);
        } else {
            System.out.println(-1);
        }

    }

    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
