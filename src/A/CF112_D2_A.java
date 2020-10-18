package A;

import java.util.Scanner;

public class CF112_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 3 min
        // debug  5 min
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine().toLowerCase();
        String s2 = scanner.nextLine().toLowerCase();
        int res = s1.compareTo(s2);
        if (res > 0) {
            System.out.println("1");

        } else if (res < 0) {
            System.out.println("-1");
        } else {
            System.out.println("0");
        }
//        if(s1.equals(s2)){
//            System.out.println("0");
//            return;
//        }
//        for (int i = 0; i < s1.length(); i++) {
//            char c1 = s1.charAt(i);
//            char c2 = s2.charAt(i);
//            if (c1 > c2) {
//                System.out.println("1");
//                break;
//            } else if (c1 < c2) {
//                System.out.println("-1");
//                break;
//            }
//        }


    }
}
