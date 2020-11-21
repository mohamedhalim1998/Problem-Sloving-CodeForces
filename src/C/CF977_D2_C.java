package C;

import java.util.Arrays;
import java.util.Scanner;

public class CF977_D2_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Integer[] arr = nextArray(scanner, n);
        Arrays.sort(arr);
        if(k == 0){
            int x = arr[0] - 1;
            if(x > 0){
                System.out.println(x);
            } else {
                System.out.println(-1);
            }
            return;
        }
        int last = arr[k - 1];
        if (k < n && arr[k - 1].equals(arr[k])) {
            System.out.println(-1);
        } else {
            System.out.println(last);
        }

    }

    public static Integer[] nextArray(Scanner scanner, int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
