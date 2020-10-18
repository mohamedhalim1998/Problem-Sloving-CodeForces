package A;

import java.util.Scanner;

public class CF265_D2_A {
    public static void main(String[] args) {
        // reading time 4 min
        // think time 1 min
        // implement time 3 min
        // debug time 0 min
        Scanner scanner = new Scanner(System.in);
        String s  = scanner.next();
        String t = scanner.next();
        int pos = 0;
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i) == s.charAt(pos)){
                pos++;
            }
        }
        System.out.println(++pos);

    }
}
