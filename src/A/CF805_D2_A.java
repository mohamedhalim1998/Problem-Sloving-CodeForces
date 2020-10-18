package A;

import java.util.Scanner;

public class CF805_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long r = scanner.nextLong();
        if(l == r){
            System.out.println(l);
        } else {
            System.out.println(2);
        }
    }
}
