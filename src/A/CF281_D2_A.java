package A;

import java.util.Scanner;

public class CF281_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        s = s.substring(0,1).toUpperCase()+ s.substring(1);
        System.out.println(s);
    }
}
