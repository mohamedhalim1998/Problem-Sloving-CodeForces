package B;

import java.util.Scanner;

public class CF546_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[5000];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            arr[x] += 1;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 1) {
                int change = 0;
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] == 0) {
                        change = j;
                        arr[j] = 1;
                        break;
                    }
                }
                sum += change - i;
                arr[i]--;
            }
        }
        System.out.println(sum);
    }
}
