package A;

import java.util.Scanner;

public class CF59_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 2 min
        // debug  0 min
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int upper = 0;
        int lower = 0;

        for (char c : s.toCharArray()) {
            if(Character.isUpperCase(c)){
                upper++;
            } else {
                lower++;
            }
        }
        if(upper > lower){
            System.out.print(s.toUpperCase());
        } else {
            System.out.println(s.toLowerCase());
        }
    }
}
