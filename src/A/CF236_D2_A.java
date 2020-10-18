package A;

import java.util.ArrayList;
import java.util.Scanner;

public class CF236_D2_A {
    public static void main(String[] args) {
        // time reading 2 min
        // think 1 min
        // implement time 4 min
        // debug  0 min

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        ArrayList<Character> a = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if(!a.contains(c)){
              a.add(c);
            }
        }

        if(a.size() % 2 ==1){
            System.out.println("IGNORE HIM!");
        } else {
            System.out.println("CHAT WITH HER!");
        }
    }
}
