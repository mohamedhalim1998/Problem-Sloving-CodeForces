package B;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CF79_D12_B {
    public static void main(String[] args) {
        // time reading 3 min
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int t = scanner.nextInt();
        int[] waste = new int[k];
        for (int i = 0; i < k; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int index = (x - 1) * m + y - 1;
            waste[i] = index;
        }
        Arrays.sort(waste);
        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int index = (x - 1) * m + y - 1;
            int res = index;
            for (int j = 0; j < k; j++) {
                if (waste[j] < index) {
                    res--;
                } else if (waste[j] == index) {
                    res = -1;
                    System.out.println("Waste");
                }

            }
            if (res == -1) {
                continue;
            }
            res = res % 3;

            switch (res) {
                case 0:
                    System.out.println("Carrots");
                    break;
                case 1:
                    System.out.println("Kiwis");
                    break;
                case 2:
                    System.out.println("Grapes");
                    break;

            }


        }


    }

}
