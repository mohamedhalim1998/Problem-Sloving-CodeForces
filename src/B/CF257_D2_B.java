package B;

import java.util.Scanner;

public class CF257_D2_B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        StringBuilder builder = new StringBuilder();
        // start red
        int i = 0, j = 0;
        char current = 'R';
        boolean p = true;
        for (int k = 1; i < n && j < m; k++) {
            if (p) {
                builder.append(current);
                p = false;
                if (current == 'R') {
                    i++;
                } else {
                    j++;
                }
            } else {
                p = true;
                if (current == 'R') {
                    builder.append('B');
                    current = 'B';
                    j++;
                } else {
                    builder.append('R');
                    current = 'R';
                    i++;
                }
            }
        }
        while (i < n) {
            builder.append('R');
            i++;
        }
        while (j < m) {
            builder.append('B');
            j++;
        }
        //System.out.println(builder);
        int pScore = 0;
        int vScore = 0;
        String redFirst = builder.toString();
        for (int k = 0; k < redFirst.length() - 1; k++) {
            if (redFirst.charAt(k) == redFirst.charAt(k + 1)) {
                pScore++;
            } else {
                vScore++;
            }
        }
//        System.out.println(pScore);
//        System.out.println(vScore);
        // start Blue
        builder = new StringBuilder();
        i = 0;
        j = 0;
        current = 'B';
        p = true;
        for (int k = 1; i < n && j < m; k++) {
            if (p) {
                builder.append(current);
                p = false;
                if (current == 'R') {
                    i++;
                } else {
                    j++;
                }
            } else {
                p = true;
                if (current == 'R') {
                    builder.append('B');
                    current = 'B';
                    j++;
                } else {
                    builder.append('R');
                    current = 'R';
                    i++;
                }
            }
        }
        while (i < n) {
            builder.append('R');
            i++;
        }
        while (j < m) {
            builder.append('B');
            j++;
        }
     //   System.out.println(builder);
        String blueFirst = builder.toString();
        int pScore2 = 0;
        int vScore2 = 0;
        for (int k = 0; k < blueFirst.length() - 1; k++) {
            if (blueFirst.charAt(k) == blueFirst.charAt(k + 1)) {
                pScore2++;
            } else {
                vScore2++;
            }
        }
        if (pScore2 > pScore) {
            System.out.println(pScore2 + " " + vScore2);
        } else {
            System.out.println(pScore + " " + vScore);
        }
    }
}
