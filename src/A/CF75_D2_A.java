package A;

import java.util.Scanner;

public class CF75_D2_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = a + b;
        a = Long.parseLong((""+a).replaceAll("0",""));
        b = Long.parseLong((""+b).replaceAll("0",""));
        c = Long.parseLong((""+c).replaceAll("0",""));

        if(a + b == c){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
