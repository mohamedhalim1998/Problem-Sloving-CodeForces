package A;

import java.util.Arrays;
import java.util.Scanner;

public class CF560_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        if(arr[0] == 1){
            System.out.println(-1);
        } else {
            System.out.println(1);
        }
    }
}
