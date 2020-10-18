package A;

import java.util.Scanner;

public class CF659_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int g = a;
        for (int i = 0; i < Math.abs(b); i++) {
            if(b > 0){
                g++;
            } else {
                g--;
            }
            if(g == 0){
                g = n;
            }
            if(g == n + 1){
                g = 1;
            }
        }
        System.out.println(g);
    }
}
