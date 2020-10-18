package B;

import java.util.Scanner;

public class CF141_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        if (x >= a || x <= -a) {
            System.out.println(-1);
            return;
        }
        if(y % a == 0){
            System.out.println(-1);
            return;
        }
        int h = (int) Math.ceil(y * 1.0 / a);
        if (h % 2 == 1&& h != 1) {
            if (x == 0) {
                System.out.println(-1);
            } else {

                int cell = h + (h / 2) - 1;
                if(x > 0){
                    cell++;
                }
                System.out.println(cell);
            }
        } else {
            if(x >= a/2.0 || x <= - a/2.0){
                System.out.println(-1);
            } else {
                int cell = h + Math.max(h / 2- 1 , 0);
                System.out.println(cell);
            }
        }


    }
}
