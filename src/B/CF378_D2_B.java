package B;

import java.util.Arrays;
import java.util.Scanner;

public class CF378_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] c1 = new int[n];
        int[] c2 = new int[n];
        for (int i = 0; i < n; i++) {
            c1[i] = scanner.nextInt();
            c2[i] = scanner.nextInt();
        }
        char[] f1 = new char[n];
        char[] f2 = new char[n];
        Arrays.fill(f1, '0');
        Arrays.fill(f2 , '0');
        for (int i = 0; i < n / 2; i++) {
            f1[i] = '1';
            f2[i] = '1';
        }
        for (int i = 0 , x = 0 , y = 0; i < n; i++) {
            if(c1[x] < c2[y]){
                f1[x] = '1';
                x++;
            } else {
                f2[y] = '1';
                y++;
            }
        }
        System.out.println(String.valueOf(f1));
        System.out.println(String.valueOf(f2));
    }
}
