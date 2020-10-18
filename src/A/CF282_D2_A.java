package A;

import java.util.Scanner;

public class CF282_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = 0;
        for (int i = 0; i < n; i++) {
            String com = scanner.next();
            if(com.charAt(1) == '+'){
                x++;
            }else {
                x--;
            }
        }
        System.out.println(x);
    }
}
