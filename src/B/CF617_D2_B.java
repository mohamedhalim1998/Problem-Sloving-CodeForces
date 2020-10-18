package B;

import java.util.Scanner;

public class CF617_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        int count = 0;
        long total = 1;
        boolean startCount = false;
        for (int i : p) {
            if (i == 1 && !startCount) {
                count++;
                startCount = true;
            } else if (startCount && i == 1) {
                total *= count;
                count = 1;
            } else if(i == 0 && startCount){
                count++;
            }
        }
        if(!startCount){
            System.out.println(0);
            return;
        }
        System.out.println(total);

    }
}
