package B;

import java.util.HashSet;
import java.util.Scanner;

public class CF454_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = nextArray(scanner, n);
        int s = minIndex(arr);
        if (s == 0) {
            int m = n - 1;
            while (m > 0 && arr[m] == arr[0]) {
                m--;
            }
            if(m <= 0){
                System.out.println(0);
                return;
            }
            s = m + 1;
        }
        if (isSorted(arr, s)) {
            System.out.println((n - s) % n);
        } else {
            System.out.println(-1);
        }
    }

    private static int minIndex(int[] arr) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }


    private static boolean isSorted(int[] arr, int s) {
        for (int i = s; i < s + arr.length - 1; i++) {
            int index = i % arr.length;
            if (arr[index] > arr[(index + 1) % arr.length])
                return false;
        }
        return true;
    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
