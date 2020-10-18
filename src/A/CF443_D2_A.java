package A;

import java.util.HashSet;
import java.util.Scanner;

public class CF443_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 5 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = s.substring(1,s.length() - 1);
        if(s.equals("")){
            System.out.println(0);
            return;
        }
        String[] arr = s.split(", ");
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i].charAt(0));
        }
        System.out.println(set.size());
    }
}
