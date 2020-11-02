package A;

import java.util.Scanner;

public class CF459_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        double theta = Math.toDegrees(Math.atan2(y2 - y1, x2 - x1));
        if(theta < 0){
            theta += 180;
        }
        //System.out.println(theta);
        if (theta == 0 || theta == 180) {
            System.out.println(x1 + " " + (y1 + (Math.abs(x2 - x1))) + " " + x2 + " " + (y2 + (Math.abs(x2 - x1))));
        } else if (theta == 90) {
            System.out.println((x1 + (Math.abs(y2 - y1))) + " " + y1 + " " + (x2 + (Math.abs(y2 - y1))) + " " + y2);
        } else if (theta == 45 || theta == 135) {
            System.out.println(x1 + " " + y2 + " " + x2 + " " + y1);
        } else {
            System.out.println(-1);
        }
    }
}
