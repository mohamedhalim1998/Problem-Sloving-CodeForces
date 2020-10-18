package B;

import java.util.Scanner;

public class CF47_D2_B {
    public static void main(String[] args) {
        // time reading 3 min
        // think 5 min
        // implement time 5 min
        // debug 0 min
        Scanner scanner = new Scanner(System.in);
        Pair[] pairs = new Pair[3];
        for (int i = 0; i < 3; i++) {
            String x = scanner.next();
            if (x.charAt(1) == '>') {
                pairs[i] = new Pair(x.charAt(0), x.charAt(2));
            } else {
                pairs[i] = new Pair(x.charAt(2), x.charAt(0));
            }
        }
        int a = 0;
        int b = 0;
        int c = 0;
        for (Pair p : pairs) {
            if(p.x == 'A'){
                a++;
            } else if(p.x == 'B'){
                b++;
            } else {
                c++;
            }
            if(p.y == 'A'){
                a--;
            } else if(p.y == 'B'){
                b--;
            } else {
                c--;
            }
        }
        if(a == b || b == c || a== c) {
            System.out.println("Impossible");
            return;
        }
        if(a == -2){
            System.out.print("A");
        }
        if(b == -2){
            System.out.print("B");
        }
        if(c == -2){
            System.out.print("C");
        }
        if(a == 0){
            System.out.print("A");
        }
        if(b == 0){
            System.out.print("B");
        }
        if(c == 0){
            System.out.print("C");
        }
        if(a == 2){
            System.out.println("A");
        }
        if(b == 2){
            System.out.println("B");
        }
        if(c == 2){
            System.out.println("C");
        }



    }

    static class Pair {
        char x;
        char y;

        public Pair(char x, char y) {
            this.x = x;
            this.y = y;
        }
    }
}
