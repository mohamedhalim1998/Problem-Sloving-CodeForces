package B;

import java.util.Scanner;

public class CF1097_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = nextArray(scanner, n);
        int sum = 0;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sum += arr[j];
                } else {
                    sum -= arr[j];
                }
            }
            if(sum >= 360){
                sum = sum % 360;
            }
            if(sum == 0){
                System.out.println("YES");
                return;
            } else {
                sum = 0;
            }
        }
        System.out.println("NO");
    }

    public static int[] nextArray(Scanner scanner, int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}
