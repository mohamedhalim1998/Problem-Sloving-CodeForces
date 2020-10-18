package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF435_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        int k = scanner.nextInt();
        for (int i = 0; i < num.length() && k > 0; i++) {
            int m = maxIndex(num.substring(i, Math.min(i + k + 1, num.length())).toCharArray()) + i;
            num = num.substring(0, i) + num.charAt(m) + num.substring(i, m) + num.substring(m + 1);
            k = k - (m - i);
        }
        System.out.println(num);
    }

    public static int maxIndex(char[] arr) {
        char max = arr[0];
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] > max) {
                max = arr[j];
                i = j;
            }
        }
        return i;
    }
}
