package A;

import java.util.Scanner;

public class CF667_D2_A {
    public static void main(String[] args) {
        // reading time 4 min
        // think time  6 min
        // implement time 5 min
        // debug time 0 min
        Scanner scanner = new Scanner(System.in);
        double r = scanner.nextDouble() / 2;
        double h = scanner.nextDouble();
        double v = scanner.nextDouble();
        double e = scanner.nextDouble();
        double inRate = Math.PI * r * r*e;
        if(inRate > v){
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        double sec = (Math.PI * r * r * h) / (v - Math.PI * r*r*e);
        System.out.println(sec);

    }
}
